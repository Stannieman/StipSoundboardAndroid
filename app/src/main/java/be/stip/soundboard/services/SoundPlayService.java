package be.stip.soundboard.services;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.AsyncTask;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.inject.Inject;

import stannieman.commonservices.models.IHasDataAndSuccessState;
import stannieman.commonservices.models.IHasSuccessState;
import stannieman.commonservices.models.ServiceResult;

public class SoundPlayService implements ISoundPlayService {
    private static final String MP3_EXTENSION = ".mp3";

    @Inject
    public IAssetService assetService;

    private MediaPlayer player;
    private Lock playerLock = new ReentrantLock();

    @Inject
    public SoundPlayService(){
        player = new MediaPlayer();
    }

    @Override
    public void playSoundAsync(String soundName, IPlaySoundAsyncCallback callback) {
        new PlaySoundAsyncTask(callback, player, playerLock).execute(soundName);
    }

    private class PlaySoundAsyncTask extends AsyncTask<String, Void, IHasSuccessState> implements MediaPlayer.OnCompletionListener {
        private IPlaySoundAsyncCallback callback;
        private MediaPlayer player;
        private Lock playerLock;

        public PlaySoundAsyncTask(IPlaySoundAsyncCallback callback, MediaPlayer player, Lock playerLock) {
            this.callback = callback;
            this.player = player;
            this.playerLock = playerLock;

            this.player.setOnCompletionListener(this);
        }

        @Override
        protected IHasSuccessState doInBackground(String... params) {
            IHasDataAndSuccessState<AssetFileDescriptor> result = assetService.getFileDescriptorForAsset(params[0].concat(MP3_EXTENSION));

            if (!result.isSuccess()) {
                return new ServiceResult<>(SoundServiceResultCodes.CannotPlaySound);
            }
            AssetFileDescriptor fd = result.getData();

            playerLock.lock();
            if (player.isPlaying()) {
                player.stop();
            }
            player.reset();

            try {
                player.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
                player.prepare();
                player.start();
                return new ServiceResult();
            } catch (Exception e) {
                return new ServiceResult<>(SoundServiceResultCodes.CannotPlaySound);
            } finally {
                playerLock.unlock();
            }
        }

        @Override
        public void onCompletion(MediaPlayer mp) {
            if (callback != null) {
                callback.playSoundAsyncCallback();
            }
        }
    }
}

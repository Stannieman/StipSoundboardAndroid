package be.stip.soundboard.services;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.AsyncTask;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.inject.Inject;

public class SoundPlayService implements ISoundPlayService {
    private static final String MP3_EXTENSION = ".mp3";

    private IAssetService assetService;

    private MediaPlayer player;
    private Lock playerLock = new ReentrantLock();

    @Inject
    public SoundPlayService(IAssetService assetService){
        this.assetService = assetService;
        player = new MediaPlayer();
    }

    @Override
    public ServiceResult playSound(String soundName) {
        try {
            return new PlaySoundAsyncTask(null, player, playerLock).execute(soundName).get();
        }
        catch (Exception e) {
            return new ServiceResult(false);
        }
    }

    @Override
    public ServiceResult playSoundAsync(String soundName, IPlaySoundAsyncCallback callback) {
        try{
            return new PlaySoundAsyncTask(callback, player, playerLock).execute(soundName).get();
        }
        catch (Exception e){
            return new ServiceResult(false);
        }
    }

    private class PlaySoundAsyncTask extends AsyncTask<String, Void, ServiceResult> implements MediaPlayer.OnCompletionListener {
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
        protected ServiceResult doInBackground(String... params) {
            ServiceResult<AssetFileDescriptor> result = assetService.getFileDescriptorForAsset(params[0].concat(MP3_EXTENSION));

            if (!result.isSuccessful()) {
                return new ServiceResult(false);
            }
            AssetFileDescriptor fd = result.getResponse();

            playerLock.lock();
            if (player.isPlaying()) {
                player.stop();
            }
            player.reset();

            try {
                player.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
                player.prepare();
                player.start();
                return new ServiceResult(true);
            } catch (Exception e) {
                return new ServiceResult(false, e.getMessage());
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

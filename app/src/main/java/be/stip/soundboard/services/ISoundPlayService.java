package be.stip.soundboard.services;

public interface ISoundPlayService {
    void playSoundAsync(String soundName, ISoundPlayService.IPlaySoundAsyncCallback callback);
    interface IPlaySoundAsyncCallback {
        void playSoundAsyncCallback();
    }
}

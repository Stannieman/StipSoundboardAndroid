package be.stip.soundboard.services;

public interface ISoundPlayService {
    ServiceResult playSound(String soundName);
    ServiceResult playSoundAsync(String soundName, ISoundPlayService.IPlaySoundAsyncCallback callback);
    interface IPlaySoundAsyncCallback {
        void playSoundAsyncCallback();
    }
}

package be.stip.soundboard.viewmodels;

import be.stip.soundboard.helpers.ISoundHelper;
import be.stip.soundboard.services.ISoundPlayService;
import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelsModule {
    @Provides
    public ButtonsViewModel provideButtonsViewModel(ISoundHelper soundHelper, ISoundPlayService soundPlayService) {
        return new ButtonsViewModel(soundHelper, soundPlayService);
    }
}

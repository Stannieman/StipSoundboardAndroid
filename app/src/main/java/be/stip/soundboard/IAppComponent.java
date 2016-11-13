package be.stip.soundboard;

import javax.inject.Singleton;

import be.stip.soundboard.helpers.HelpersModule;
import be.stip.soundboard.services.AssetService;
import be.stip.soundboard.services.ServicesModule;
import be.stip.soundboard.services.SoundPlayService;
import be.stip.soundboard.viewmodels.ButtonsViewModel;
import be.stip.soundboard.viewmodels.ViewModelsModule;
import be.stip.soundboard.views.ButtonsView;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ServicesModule.class, HelpersModule.class, ViewModelsModule.class})
public interface IAppComponent {
    void inject(AssetService assetService);
    void inject(SoundPlayService soundPlayService);
    void inject(ButtonsViewModel buttonsViewModel);
    void inject(ButtonsView buttonsView);
}

package be.stip.soundboard;

import javax.inject.Singleton;

import be.stip.soundboard.helpers.HelpersModule;
import be.stip.soundboard.services.ServicesModule;
import be.stip.soundboard.views.ButtonsView;
import dagger.Component;
import stannieman.mvvm.MvvmModule;

@Singleton
@Component(modules = {AppModule.class, ServicesModule.class, HelpersModule.class, MvvmModule.class})
public interface IAppComponent {
    void inject(SplashScreenActivity splashScreenActivity);
    void inject(ButtonsView buttonsView);
}

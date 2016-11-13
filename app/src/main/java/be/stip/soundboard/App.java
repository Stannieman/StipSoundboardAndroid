package be.stip.soundboard;

import android.app.Application;
import android.content.Context;

import be.stip.soundboard.helpers.HelpersModule;
import be.stip.soundboard.services.ServicesModule;
import be.stip.soundboard.viewmodels.ViewModelsModule;

public class App extends Application {
    private static Context context;
    private static IAppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();

        component = DaggerIAppComponent.builder()
                .appModule(new AppModule(context))
                .servicesModule(new ServicesModule())
                .helpersModule(new HelpersModule())
                .viewModelsModule(new ViewModelsModule())
                .build();
    }

    public static IAppComponent getComponent() {
        return component;
    }
}

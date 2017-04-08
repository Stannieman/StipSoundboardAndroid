package be.stip.soundboard;

import android.app.Application;

public class App extends Application {
    private static IAppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerIAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();
    }

    public static IAppComponent getAppComponent() {
        return appComponent;
    }
}

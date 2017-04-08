package be.stip.soundboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import be.stip.soundboard.views.ButtonsView;
import stannieman.mvvm.navigation.INavigationService;

public class SplashScreenActivity extends AppCompatActivity {

    @Inject
    INavigationService navigationService;

    public SplashScreenActivity() {
        App.getAppComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        navigationService.navigateTo(ButtonsView.class);
        finish();
    }

}

package be.stip.soundboard.viewmodels;

import android.os.Handler;
import android.view.View;

import javax.inject.Inject;

import stannieman.mvvm.ViewModelBase;
import stannieman.mvvm.navigation.INavigationService;

public class EasterEggViewModel extends ViewModelBase {
    private static final int autoNavigateBackDelay = 5000;
    private final Handler navigateBackHandler;
    private final Runnable navigateBackRunnable;

    @Inject
    INavigationService navigationService;

    @Inject
    public EasterEggViewModel() {
        navigateBackHandler = new Handler();
        navigateBackRunnable = new Runnable() {
            @Override
            public void run() {
                navigationService.navigateBack();
            }
        };
    }

    @Override
    public void onResume() {
        navigateBackHandler.postDelayed(navigateBackRunnable, autoNavigateBackDelay);
    }

    @Override
    public void onPause() {
        navigateBackHandler.removeCallbacks(navigateBackRunnable);
    }

    public void onPictureClicked(View view) {
        navigationService.navigateBack();
    }
}

package be.stip.soundboard.viewmodels;

import android.databinding.Bindable;

import java.util.List;

import javax.inject.Inject;

import be.stip.soundboard.BR;
import be.stip.soundboard.helpers.ISoundHelper;
import be.stip.soundboard.models.Sound;
import be.stip.soundboard.services.ISoundPlayService;
import be.stip.soundboard.views.EasterEggView;
import stannieman.mvvm.ViewModelBase;
import stannieman.mvvm.navigation.INavigationService;

public class ButtonsViewModel extends ViewModelBase {
    private static final String EASTER_EGG_BUTTON_ORDER = "adfijg";

    @Inject
    ISoundHelper soundHelper;
    @Inject
    ISoundPlayService soundPlayService;
    @Inject
    INavigationService navigationService;

    private List<Sound> sounds;
    private String buttonsClicked = "";

    @Bindable
    public List<Sound> getSounds(){
        return sounds;
    }

    public void setSounds(List<Sound> sounds){
        if (this.sounds != sounds){
            this.sounds = sounds;
            notifyPropertyChanged(BR.sounds);
        }
    }

    @Inject
    public ButtonsViewModel() {}

    @Override
    protected void onFirstStart() {
        setSounds(soundHelper.getSounds());
    }

    public void playSound(Sound sound) {
        buttonsClicked += sound.getId();
        if (!EASTER_EGG_BUTTON_ORDER.startsWith(buttonsClicked)) {
            buttonsClicked = "";
        }
        else if (buttonsClicked.equals(EASTER_EGG_BUTTON_ORDER)) {
            navigationService.navigateTo(EasterEggView.class);
            buttonsClicked = "";
            return;
        }

        soundPlayService.playSoundAsync(sound.getFileName(), null);
    }
}

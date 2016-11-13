package be.stip.soundboard.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

import javax.inject.Inject;

import be.stip.soundboard.helpers.ISoundHelper;
import be.stip.soundboard.models.Sound;
import be.stip.soundboard.services.ISoundPlayService;

public class ButtonsViewModel extends BaseObservable {
    private ISoundPlayService soundPlayService;

    private List<Sound> sounds;

    @Bindable
    public List<Sound> getSounds(){
        return sounds;
    }

    public void setSounds(List<Sound> sounds){
        if (this.sounds != sounds){
            this.sounds = sounds;
            //notifyPropertyChanged(BR.sounds);
        }
    }

    @Inject
    public ButtonsViewModel(ISoundHelper soundHelper, ISoundPlayService soundPlayService){
        this.soundPlayService = soundPlayService;

        setSounds(soundHelper.getSounds());
    }

    public void playSound(Sound sound) {
        soundPlayService.playSound(sound.getFileName());
    }
}

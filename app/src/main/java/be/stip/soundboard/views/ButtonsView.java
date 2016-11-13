package be.stip.soundboard.views;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;

import java.util.List;

import javax.inject.Inject;

import be.stip.soundboard.App;
import be.stip.soundboard.BR;
import be.stip.soundboard.R;
import be.stip.soundboard.databinding.ButtonsViewBinding;
import be.stip.soundboard.models.Sound;
import be.stip.soundboard.viewmodels.ButtonsViewModel;


public class ButtonsView extends AppCompatActivity {

    @Inject
    public ButtonsViewModel viewModel;

    @Inject
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.getComponent().inject(this);
        ButtonsViewBinding binding = DataBindingUtil.setContentView(this, R.layout.buttons_view);
        binding.setViewModel(viewModel);

        final AbsoluteLayout buttonsGrid = (AbsoluteLayout)findViewById(R.id.buttonsGrid);
        createButtons(buttonsGrid, viewModel.getSounds());

        viewModel.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                switch(i) {
                    case BR.sounds:
                        createButtons(buttonsGrid, viewModel.getSounds());
                        break;
                }
            }
        });
    }

    private void createButtons(AbsoluteLayout buttonsGrid, List<Sound> sounds) {

        buttonsGrid.removeAllViews();

        int size = getWindowWidth() / 2;

        int nSounds = sounds.size();
        for (int i = 0; i < nSounds; i++) {
            int width;
            if (nSounds % 2 != 0 && i == nSounds - 1) {
                width = size * 2;
            }
            else {
                width = size;
            }

            AbsoluteLayout.LayoutParams params = new AbsoluteLayout.LayoutParams(width, size, (i%2)*size, (i/2)*size);

            buttonsGrid.addView(createButton(sounds.get(i), width, size), params);
        }
    }

    private Button createButton(final Sound sound, int width, int height) {
        final Button button = new Button(context);
        button.setText(sound.getName());
        button.setSoundEffectsEnabled(false);
        button.setTextColor(Color.rgb(237, 28, 36));
        button.setBackground(context.getResources().getDrawable(R.drawable.button_border_shape));
        button.setWidth(width);
        button.setMaxWidth(width);
        button.setHeight(height);
        button.setMaxHeight(height);
        button.setTransformationMethod(null);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.playSound(sound);
            }
        });

        return button;
    }

    private int getWindowWidth() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }
}

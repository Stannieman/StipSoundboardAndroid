package be.stip.soundboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import be.stip.soundboard.views.ButtonsView;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, ButtonsView.class);
        startActivity(intent);
        finish();
    }

}

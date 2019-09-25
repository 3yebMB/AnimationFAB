package dev.m13d.animationfab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import dev.m13d.animationfab.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bi;
    boolean isRotate = false;
    private static final String TAG = "miniButtonsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_main);

        bi.fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRotate = ViewAnimation.rotateFab(v, isRotate);
            }
        });
        ViewAnimation.init(bi.fabMic);
        ViewAnimation.init(bi.fabCall);

        bi.fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRotate = ViewAnimation.rotateFab(v, !isRotate);
                if (isRotate) {
                    ViewAnimation.showIn(bi.fabCall);
                    ViewAnimation.showIn(bi.fabMic);
                } else {
                    ViewAnimation.showOut(bi.fabCall);
                    ViewAnimation.showOut(bi.fabMic);
                }
            }
        });

        bi.fabCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Calling", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onClick: Calling");
            }
        });

        bi.fabMic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "mic", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onClick: Microphone");
            }
        });
    }
}

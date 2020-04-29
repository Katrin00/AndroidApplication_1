package com.example.laba_1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startActivity(new Intent(this, MainActivity.class));

        sleep();
        finish();
    }

    public void sleep () {
        try {
            Thread.sleep(2000);
        } catch (Exception e) { }
    }
}

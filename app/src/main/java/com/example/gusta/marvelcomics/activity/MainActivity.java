package com.example.gusta.marvelcomics.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gusta.marvelcomics.R;

public class MainActivity extends AppCompatActivity implements Runnable{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler h = new Handler();
        h.postDelayed(this, 3000);
    }

    public void run() {
        startActivity(new Intent(this, ActionBarActivity.class));
        finish();
    }
}

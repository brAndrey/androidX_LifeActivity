package com.example.androidxlifeactivity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private static final String LOG = SecondActivity.class.getSimpleName();
    private MyLocationListener myLocationListener;

    @Override
    protected void onStart() {
        super.onStart();
        myLocationListener.enable();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myLocationListener = new MyLocationListener(this,getLifecycle(),null,MyLocationListener.Owner.ACTIVITY2 );
        Log.d(LOG, "onCreate");
        setContentView(R.layout.activity_second);

        // сервис https://habr.com/ru/post/349102/
    }


}

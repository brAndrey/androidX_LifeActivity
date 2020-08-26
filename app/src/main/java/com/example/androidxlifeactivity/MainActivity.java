package com.example.androidxlifeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

// ссылка с которой все началось
// https://developer.android.com/topic/libraries/architecture/lifecycle

public class MainActivity extends AppCompatActivity {

 private MyLocationListener myLocationListener;
    private static final String LOG = MainActivity.class.getSimpleName();

    @Override
    protected void onStart() {
        super.onStart();
        myLocationListener.enable();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         myLocationListener = new MyLocationListener(this,getLifecycle(),null,MyLocationListener.Owner.ACTIVITY );
        Log.d(LOG, "onCreate");
        setContentView(R.layout.activity_main);

        // сервис https://habr.com/ru/post/349102/
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(LOG,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LOG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOG,"onDestroy");
    }

    public void GoSecondActivity(View view) {
        Intent intent =new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}
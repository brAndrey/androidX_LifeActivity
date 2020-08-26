package com.example.androidxlifeactivity;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class SomeObserver implements LifecycleObserver {
    private Owner owner;

    public SomeObserver(Lifecycle lifecycle, Owner owner) {
        this.owner = owner;
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
        Log.d("Observer", owner + ": onCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop() {
        Log.d("Observer", owner + ": onStop");
    }

    enum Owner {
        ACTIVITY, FRAGMENT, PROCESS, SERVICE
    }

}

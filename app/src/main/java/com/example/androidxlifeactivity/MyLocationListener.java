package com.example.androidxlifeactivity;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import java.security.acl.Owner;

import javax.security.auth.callback.Callback;

import static androidx.lifecycle.Lifecycle.State.STARTED;

public class MyLocationListener implements LifecycleObserver {
    private static final String LOG = MyLocationListener.class.getSimpleName();

    private boolean enabled = false;
    private Context context;
    private Lifecycle lifecycle;
    private Callback callback;
    private Owner owner;



    public MyLocationListener(Context context, Lifecycle lifecycle, Callback callback,Owner owner) {
        this.context = context;
        this.lifecycle = lifecycle;
        this.callback = callback;

        // вешаем слушателя состояния
        lifecycle.addObserver(this);
        this.owner = owner;
    }

    public void enable() {
        enabled = true;
        if (lifecycle.getCurrentState().isAtLeast(STARTED)) {
            // connect if not connected
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void create() { Log.d(LOG, owner+": onCreate");}

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void start() {
        if (!enabled) {
            Log.d(LOG, owner+": onStart");}
        }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void resume() { Log.d(LOG, owner+": onResume");}

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void pause() { Log.d(LOG, owner+": onPause");}

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void destroy(){Log.d(LOG, owner+": onDestroy");}

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void stop() { Log.d(LOG, owner+": onStop"); }

    enum Owner {
        ACTIVITY, FRAGMENT, PROCESS, SERVICE, ACTIVITY2
    }
}

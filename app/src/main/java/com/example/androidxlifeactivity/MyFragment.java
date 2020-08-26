package com.example.androidxlifeactivity;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class MyFragment extends Fragment {

    private MyLocationListener myLocationListener;

    public MyFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_my, container, false);
        myLocationListener = new MyLocationListener(view.getContext() ,getLifecycle(),null,MyLocationListener.Owner.FRAGMENT );

        return view;
    }

}

package com.udacity.gradle.builditbigger.paid;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.callbacks.AdCallback;

public class MainActivityFragment extends Fragment implements View.OnClickListener{

    private final AdCallback sAdCallback = new AdCallback() {
        @Override
        public void tellJoke() {

        }
    };
    private AdCallback adCallback = sAdCallback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof AdCallback) {
            adCallback = (AdCallback) activity;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.joke_button).setOnClickListener(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        adCallback = sAdCallback;
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        switch (id) {
            case R.id.joke_button:
                adCallback.tellJoke();
                break;
        }
    }
}

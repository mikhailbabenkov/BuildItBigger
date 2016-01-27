package com.udacity.gradle.builditbigger.free;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.callbacks.AdCallback;


public class MainActivityFragment extends Fragment implements OnClickListener{

    private final AdCallback sAdCallback = new AdCallback() {
        @Override
        public void tellJoke() {

        }
    };
    private AdCallback adCallback = sAdCallback;
    private AdView mAdView;

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
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        mAdView.setVisibility(View.GONE);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.joke_button).setOnClickListener(this);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                mAdView.setVisibility(View.GONE);
                adCallback.tellJoke();
            }
        });
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
                showAdd();
                break;
        }
    }

    private void showAdd() {
        mAdView.setVisibility(View.VISIBLE);

    }
}

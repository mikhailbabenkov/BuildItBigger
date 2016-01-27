package com.example.michaelbabenkov.androidjokelib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = JokeActivity.class.getSimpleName() + ":extra_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        wireControls();
    }

    private void wireControls() {
        final Intent intent = getIntent();
        if(intent != null){
            final String joke = intent.getStringExtra(EXTRA_JOKE);
            final TextView jokeTextView = (TextView) findViewById(R.id.joke_text_view);
            jokeTextView.setText(joke);
        }
    }
}

package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ProgressBar;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

/**
 * Created by michaelbabenkov on 26/01/16.
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTest  {

    @Test
    public void testAsyncTaskWithNull(){
        String testString = null;
        try {
            final ProgressBar progressBar = new ProgressBar(InstrumentationRegistry.getContext());
            testString = new  MainActivity.TellJokeTask(progressBar).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(testString);
    }

}
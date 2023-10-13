package com.example.sendmessageviewbinding;

import android.app.Application;
import android.util.Log;

/**
 * @author Carlos Bocka López
 * Clase que será instanciada representando nuestra aplicación en particular
 */
public class MessageApplication extends Application {

    public final static String TAG = "MessageApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "MessageApplication -> onCreate()");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "MessageApplication -> onTerminate()");
    }
}

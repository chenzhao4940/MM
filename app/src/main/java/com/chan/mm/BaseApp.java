package com.chan.mm;

import android.app.Application;
import android.graphics.Typeface;

/**
 * Created by chan on 2016/9/2.
 */
public class BaseApp extends Application {
    private static BaseApp mBaseAppInstance;
    private Typeface typeFace;
    public static BaseApp getInstance() {
        return mBaseAppInstance;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        mBaseAppInstance = this;
        initFonts();
    }

    private void initFonts() {
        typeFace = Typeface.createFromAsset(getAssets(), "fonts/typeface.ttf");
    }

    public Typeface getTypeface() {
        return typeFace;
    }
}

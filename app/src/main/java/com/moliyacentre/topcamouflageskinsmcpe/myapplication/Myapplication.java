package com.moliyacentre.topcamouflageskinsmcpe.myapplication;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.moliyacentre.topcamouflageskinsmcpe.R;
import com.moliyacentre.topcamouflageskinsmcpe.utils.SharedPref;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;


public class Myapplication extends Application {
    private static Context mContext;
    private static Myapplication mInstance;

    static  void lambda$onCreate$0(InitializationStatus initializationStatus) {
    }

    @Override 
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mContext = this;
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override 
            public final void onInitializationComplete(InitializationStatus initializationStatus) {
                Myapplication.lambda$onCreate$0(initializationStatus);
            }
        });
    }

    public static Context getContext() {
        return mContext;
    }

    public static Myapplication getInstance() {
        return mInstance;
    }
}

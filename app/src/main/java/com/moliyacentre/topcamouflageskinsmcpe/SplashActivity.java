package com.moliyacentre.topcamouflageskinsmcpe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {
    private final Handler mHandler = new Handler();
    private final Runnable mPendingLauncherRunnable = new Runnable() { 
        @Override 
        public final void run() {
            SplashActivity.this.movenext();
        }
    };

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler.postDelayed(this.mPendingLauncherRunnable, 1000L);
    }

    void movenext() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}

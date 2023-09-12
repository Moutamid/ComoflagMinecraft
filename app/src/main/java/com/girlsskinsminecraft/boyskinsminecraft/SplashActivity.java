package com.girlsskinsminecraft.boyskinsminecraft;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.PurchaseInfo;
import com.anjlab.android.iab.v3.SkuDetails;
import com.girlsskinsminecraft.boyskinsminecraft.utils.ConstantFunctions;

import java.util.ArrayList;
import java.util.List;


public class SplashActivity extends AppCompatActivity implements BillingProcessor.IBillingHandler {
    private final Handler mHandler = new Handler();
    private final Runnable mPendingLauncherRunnable = new Runnable() { 
        @Override 
        public final void run() {
            SplashActivity.this.movenext();
        }
    };
    BillingProcessor bp;
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler.postDelayed(this.mPendingLauncherRunnable, 1000L);


    }

    void movenext() {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        bp = BillingProcessor.newBillingProcessor(this, ConstantFunctions.LICENSE_KEY, this);
        bp.initialize();

        ArrayList<String> ids = new ArrayList<>();
        ids.add(ConstantFunctions.VIP_MONTH);
        bp.getSubscriptionsListingDetailsAsync(ids, new BillingProcessor.ISkuDetailsResponseListener() {
            @Override
            public void onSkuDetailsResponse(@Nullable List<SkuDetails> products) {
                Log.d("PURSS", "Size : " + products.size());
                for (int i = 0; i < products.size(); i++){
                    boolean isSub = products.get(i).isSubscription;
                    myEdit.putBoolean("VIP", isSub);
                    myEdit.commit();
                }
            }

            @Override
            public void onSkuDetailsError(String error) {

            }
        });
        Log.d("PURSS", "init : " + bp.isInitialized());

        if (bp.isSubscribed(ConstantFunctions.VIP_MONTH)){
            myEdit.putBoolean("VIP", true);
            myEdit.commit();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            myEdit.putBoolean("VIP", false);
            myEdit.commit();
            startActivity(new Intent(this, SubscriptionActivity.class));
            finish();
        }

    }

    @Override
    public void onProductPurchased(@NonNull String productId, @Nullable PurchaseInfo details) {

    }

    @Override
    public void onPurchaseHistoryRestored() {

    }

    @Override
    public void onBillingError(int errorCode, @Nullable Throwable error) {

    }

    @Override
    public void onBillingInitialized() {

    }
}

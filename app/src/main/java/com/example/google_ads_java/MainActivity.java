 package com.example.google_ads_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

 public class MainActivity extends AppCompatActivity {
     private AdView adView;
     AdRequest adRequest;
     InterstitialAd mInterstitialAd;
     Button btn;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         MobileAds.initialize(this, new OnInitializationCompleteListener() {
             @Override
             public void onInitializationComplete(InitializationStatus initializationStatus) {
             }
         });
         btn = findViewById(R.id.indusAd);
         AdRequest adRequest = new AdRequest.Builder().build();

         InterstitialAd.load(getApplicationContext(),"ca-app-pub-3940256099942544/1033173712", adRequest,
                 new InterstitialAdLoadCallback() {
                     @Override
                     public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                         // The mInterstitialAd reference will be null until
                         // an ad is loaded.
                         mInterstitialAd = interstitialAd;

                     }

                     @Override
                     public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                         // Handle the error

                         mInterstitialAd = null;
                     }
                 });


         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 mInterstitialAd.show(MainActivity.this);
             }
         });
    /*     adView = (AdView) findViewById(R.id.ad_view);
         adRequest = new AdRequest.Builder().build();
         adView.loadAd(adRequest);

         adView.setAdListener(new AdListener() {
             @Override
             public void onAdClicked() {
                 super.onAdClicked();
                 Toast.makeText(MainActivity.this, "ad is clicked", Toast.LENGTH_SHORT).show();
             }
         });*/
     }

}
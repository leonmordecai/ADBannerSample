package com.example.leon.adbanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class MainActivity extends AppCompatActivity {

    int currentCoin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button2);
        final TextView textview1 = (TextView) findViewById(R.id.textView);

        final RewardedVideoAd rewardAd = MobileAds.getRewardedVideoAdInstance(this);
        rewardAd.loadAd("ca-app-pub-3630158546388661/3207432403", new AdRequest.Builder().build());
        MobileAds.initialize(this);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rewardAd.isLoaded()) {
                    rewardAd.show();
                } else {
                    rewardAd.loadAd("ca-app-pub-3630158546388661/3207432403", new AdRequest.Builder().build());
                }
            }
        });

        rewardAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            @Override
            public void onRewardedVideoAdLoaded() {

            }

            @Override
            public void onRewardedVideoAdOpened() {

            }

            @Override
            public void onRewardedVideoStarted() {

            }

            @Override
            public void onRewardedVideoAdClosed() {

            }

            @Override
            public void onRewarded(RewardItem rewardItem) {

                currentCoin = currentCoin + 10;
                textview1.setText("Coins : " + currentCoin);
            }

            @Override
            public void onRewardedVideoAdLeftApplication() {

            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int i) {

            }
        });


    }
}

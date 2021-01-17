package com.mert.hr190011_mert_kuskurdan_final_proje.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import com.mert.hr190011_mert_kuskurdan_final_proje.R;
import com.mert.hr190011_mert_kuskurdan_final_proje.activity.ListeActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (networkController()){
            init();
        }
        else{
            networkAlertNotification();
        }
    }
    private void init(){
        CountDownTimer countDownTimer =new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                openListeActivity();
            }
        };

        countDownTimer.start();

    }
    private void openListeActivity(){

        Intent secondActivityIntent=new Intent(getApplicationContext(), ListeActivity.class);
        startActivity(secondActivityIntent);
        finish();

    }

    private void networkAlertNotification ()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
        builder.setTitle(getResources().getString(R.string.splashAlertDialogSetTitle));
        builder.setMessage(getResources().getString(R.string.splashAlertDialogSetMessage));

        builder.setNegativeButton(getResources().getString(R.string.splashsetNegativeButton), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setPositiveButton(getResources().getString(R.string.splashsetPositiveButton), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
            }
        });
        builder.show();
    }

    public boolean networkController() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager.getActiveNetworkInfo() != null
                && manager.getActiveNetworkInfo().isAvailable()
                && manager.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }
}
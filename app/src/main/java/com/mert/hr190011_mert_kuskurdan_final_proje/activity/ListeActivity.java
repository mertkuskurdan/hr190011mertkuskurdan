package com.mert.hr190011_mert_kuskurdan_final_proje.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.mert.hr190011_mert_kuskurdan_final_proje.model.KisilerModel;
import com.mert.hr190011_mert_kuskurdan_final_proje.adaptor.KisilerAdaptor;
import com.mert.hr190011_mert_kuskurdan_final_proje.R;
import com.mert.hr190011_mert_kuskurdan_final_proje.network.Service;
import com.mert.hr190011_mert_kuskurdan_final_proje.util.Constants;
import com.mert.hr190011_mert_kuskurdan_final_proje.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        ProgressDialogShow();
        init();

    }

    private  void  init()
    {
        kisileriGetir();
    }

    void  kisileriGetir()
    { 

        new Service().getServiceApi().kisileriGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<KisilerModel>>() {

                    List<KisilerModel> kisilerModel =new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<KisilerModel> kisilerList) {
                        kisilerModel = kisilerList;
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("RETROFIT_ERROR", "YOUR LOG MESSAGE");
                    }

                    @Override
                    public void onComplete()
                    {
                        if(kisilerModel.size()>0) {

                            initRecycleView(kisilerModel);
                        }
                    }
                });
    }

    private  void  initRecycleView(List<KisilerModel> kisilerModelList)
    {
        recyclerView =findViewById(R.id.rcvKisiler);
        KisilerAdaptor kisilerAdaptor =new KisilerAdaptor(kisilerModelList, getApplicationContext(), new KisilerAdaptor.OnItemClickListener() {
            @Override
            public void onClick(int position) {

                KisilerModel tiklananKisi = kisilerModelList.get(position);
                Toast.makeText(getApplicationContext(), "TIKLANAN ADI : " + tiklananKisi.getAdiSoyadi(), Toast.LENGTH_SHORT).show();
                openListeActivity(tiklananKisi);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(kisilerAdaptor);
    }

    private void openListeActivity(KisilerModel tiklananKisi){

        Intent secondActivityIntent=new Intent(getApplicationContext(), KisiDetayActivity.class);
        String tiklananKisiString = ObjectUtil.kisiToJsonString(tiklananKisi);
        secondActivityIntent.putExtra(Constants.TIKLANAN_KISI_TASINANIN_BASLIGI,tiklananKisiString);
        startActivity(secondActivityIntent);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ListeActivity.this);
        builder.setTitle(getResources().getString(R.string.onBackSplashsetTitle));
        builder.setNegativeButton(getResources().getString(R.string.onBackSplashsetNegativeButton), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setPositiveButton(getResources().getString(R.string.onBackSplashsetPositiveButton), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }

    private void ProgressDialogShow(){
        ProgressDialog progressDialog = new ProgressDialog(ListeActivity.this);
        progressDialog.setMessage(getResources().getString(R.string.onBackSplashsetMessage));
        progressDialog.show();
    }
}
package com.mert.hr190011_mert_kuskurdan_final_proje.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.mert.hr190011_mert_kuskurdan_final_proje.R;
import com.mert.hr190011_mert_kuskurdan_final_proje.model.KisilerModel;
import com.mert.hr190011_mert_kuskurdan_final_proje.util.Constants;
import com.mert.hr190011_mert_kuskurdan_final_proje.util.GlideUtil;
import com.mert.hr190011_mert_kuskurdan_final_proje.util.ObjectUtil;

public class  KisiDetayActivity extends AppCompatActivity {


    ImageView imgKapak;
    TextView txtBaslik;
    TextView txtDetay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisi_detay);
        init();
    }


    private void init()
    {
        String tasinanKisiString = getIntent().getStringExtra(Constants.TIKLANAN_KISI_TASINANIN_BASLIGI);
        KisilerModel kisilerModelList = ObjectUtil.jsonStringToKisi(tasinanKisiString);

        imgKapak = findViewById(R.id.imgKapak);
        txtBaslik = findViewById(R.id.txtBaslik);
        txtDetay = findViewById(R.id.txtDetay);

        txtBaslik.setText(kisilerModelList.getAdiSoyadi());
        txtDetay.setText(kisilerModelList.getBilgi());
        GlideUtil.resmiIndiripGoster(getApplicationContext(),kisilerModelList.getBuyukResimURL(), imgKapak);
    }
}
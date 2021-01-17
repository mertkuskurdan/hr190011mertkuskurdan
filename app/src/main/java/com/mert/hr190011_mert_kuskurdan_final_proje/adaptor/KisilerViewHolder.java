 package com.mert.hr190011_mert_kuskurdan_final_proje.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mert.hr190011_mert_kuskurdan_final_proje.R;

public class KisilerViewHolder  extends RecyclerView.ViewHolder {

    ImageView imgKisi;
    TextView txtAdSoyad;
    TextView txtDogumTarihi;
    TextView txtOlumTarihi;

    public KisilerViewHolder(@NonNull View itemView, KisilerAdaptor.OnItemClickListener listener) {
        super(itemView);

        imgKisi =itemView.findViewById(R.id.imgKisi);
        txtAdSoyad =itemView.findViewById(R.id.txtIsim);
        txtDogumTarihi =itemView.findViewById(R.id.txtTarih);
        txtOlumTarihi =itemView.findViewById(R.id.txtOlumTarih);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onClick(getAdapterPosition());
            }
        });
    }
}
package com.mert.hr190011_mert_kuskurdan_final_proje.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mert.hr190011_mert_kuskurdan_final_proje.R;
import com.mert.hr190011_mert_kuskurdan_final_proje.model.KisilerModel;
import com.mert.hr190011_mert_kuskurdan_final_proje.util.GlideUtil;

import java.util.List;

public class KisilerAdaptor  extends RecyclerView.Adapter<KisilerViewHolder> {


    List<KisilerModel> kisilerModel;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClick( int position);
    }

    public KisilerAdaptor(List<KisilerModel> kisilerModel, Context context, OnItemClickListener listener) {
        this.kisilerModel = kisilerModel;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public KisilerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_kisiler,parent,false);
        return new KisilerViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull KisilerViewHolder viewHolder, int position) {

        viewHolder.txtAdSoyad.setText(kisilerModel.get(position).getAdiSoyadi());
        viewHolder.txtDogumTarihi.setText(kisilerModel.get(position).getDogumTarihi());
        viewHolder.txtOlumTarihi.setText(kisilerModel.get(position).getOlumTarihi());

        GlideUtil.resmiIndiripGoster(context, kisilerModel.get(position).getKucukResimURL(),viewHolder.imgKisi);

    }

    @Override
    public int getItemCount() {
        return kisilerModel.size();
    }
}

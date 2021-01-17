package com.mert.hr190011_mert_kuskurdan_final_proje.network;

import com.mert.hr190011_mert_kuskurdan_final_proje.model.KisilerModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET("TariheYonVermisKisiler.json")
    Observable<List<KisilerModel>> kisileriGetir();
}

package com.mert.hr190011_mert_kuskurdan_final_proje.util;

import com.google.gson.Gson;
import com.mert.hr190011_mert_kuskurdan_final_proje.model.KisilerModel;


public class ObjectUtil {

    public  static String kisiToJsonString(KisilerModel kisilerModel)
    {
        Gson gson = new Gson();
        return   gson.toJson(kisilerModel);
    }

    public  static KisilerModel jsonStringToKisi(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,KisilerModel.class);
    }
}

package com.mert.hr190011_mert_kuskurdan_final_proje.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KisilerModel {

    @SerializedName("AdiSoyadi")
    @Expose
    private String adiSoyadi;
    @SerializedName("DogumTarihi")
    @Expose
    private String dogumTarihi;
    @SerializedName("OlumTarihi")
    @Expose
    private String olumTarihi;
    @SerializedName("Bilgi")
    @Expose
    private String bilgi;
    @SerializedName("KucukResimURL")
    @Expose
    private String kucukResimURL;
    @SerializedName("BuyukResimURL")
    @Expose
    private String buyukResimURL;

    public String getAdiSoyadi() {
        return adiSoyadi;
    }

    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getOlumTarihi() {
        return olumTarihi;
    }

    public void setOlumTarihi(String olumTarihi) {
        this.olumTarihi = olumTarihi;
    }

    public String getBilgi() {
        return bilgi;
    }

    public void setBilgi(String bilgi) {
        this.bilgi = bilgi;
    }

    public String getKucukResimURL() {
        return kucukResimURL;
    }

    public void setKucukResimURL(String kucukResimURL) {
        this.kucukResimURL = kucukResimURL;
    }

    public  String getBuyukResimURL() {
        return buyukResimURL;
    }

    public void setBuyukResimURL(String buyukResimURL) {
        this.buyukResimURL = buyukResimURL;
    }

}
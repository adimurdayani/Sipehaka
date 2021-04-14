package com.fauzia.sipehaka.Model;

public class DataModel {

    private String kode, judul;

    public DataModel(String kode, String judul) {
        this.kode = kode;
        this.judul = judul;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
}

package com.ubl.uas_jaler.model;

import com.google.gson.annotations.SerializedName;

public class Tournament {

    @SerializedName("id")
    private int id;

    @SerializedName("nama")
    private String nama;

    @SerializedName("game")
    private String game;

    @SerializedName("tanggal")
    private String tanggal;

    @SerializedName("gambar")
    private String gambar;

    public Tournament() {
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getGame() {
        return game;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getGambar() {
        return gambar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
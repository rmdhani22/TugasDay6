package com.example.day6;

public class ModelItem {
    private String namaItem;
    private int gambarItem;
    private String deskripsiItem;
    private double hargaItem;

    public ModelItem(String namaItem, int gambarItems, String deskripsiItem, double hargaItem) {
        this.namaItem = namaItem;
        this.gambarItem = gambarItems;
        this.deskripsiItem = deskripsiItem;
        this.hargaItem = hargaItem;
    }


    public String getDeskripsiItem() {
        return deskripsiItem;
    }

    public void setDeskripsiItem(String deskripsiItem) {
        this.deskripsiItem = deskripsiItem;
    }

    public double getHargaItem() {
        return hargaItem;
    }

    public void setHargaItem(double hargaItem) {
        this.hargaItem = hargaItem;
    }


    public String getNamaItem() {
        return namaItem;
    }

    public void setNamaItem(String namaItem) {
        this.namaItem = namaItem;
    }

    public int getGambarItem() {
        return gambarItem;
    }

    public void setGambarItem(int gambarItems) {
        this.gambarItem = gambarItems;
    }
}
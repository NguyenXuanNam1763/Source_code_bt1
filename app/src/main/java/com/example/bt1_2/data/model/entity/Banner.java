package com.example.bt1_2.data.model.entity;

public class Banner {
    private int idBanner;
    private String img_url;

    public Banner(int idBanner, String img_url) {
        this.idBanner = idBanner;
        this.img_url = img_url;
    }

    public int getIdBanner() {
        return idBanner;
    }

    public void setIdBanner(int idBanner) {
        this.idBanner = idBanner;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}

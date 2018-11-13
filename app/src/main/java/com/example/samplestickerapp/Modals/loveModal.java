package com.example.samplestickerapp.Modals;

public class loveModal {

    String imgsrc;

    public loveModal(String url) {
        this.imgsrc = url;
    }

    public loveModal() {
    }

    public String getUrl() {
        return imgsrc;
    }

    public void setUrl(String url) {
        this.imgsrc = url;
    }
}

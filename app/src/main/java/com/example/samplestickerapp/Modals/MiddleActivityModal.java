package com.example.samplestickerapp.Modals;

public class MiddleActivityModal {

    String imgsrc;

    public MiddleActivityModal(String url) {
        this.imgsrc = url;
    }

    public MiddleActivityModal() {
    }

    public String getUrl() {
        return imgsrc;
    }

    public void setUrl(String url) {
        this.imgsrc = url;
    }
}

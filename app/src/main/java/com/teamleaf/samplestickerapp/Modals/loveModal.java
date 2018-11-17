package com.teamleaf.samplestickerapp.Modals;

public class loveModal {

    String imgsrc;
    String parent;

    public loveModal() {
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public loveModal(String url) {
        this.imgsrc = url;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }
}

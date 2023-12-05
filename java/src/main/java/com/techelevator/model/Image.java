package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {

    private int id;
    private byte[] data;
    private String mediatype;


    public Image(int id, byte[] data, String mediatype) {
        this.id = id;
        this.data = data;
        this.mediatype = mediatype;
    }

    public Image(byte[] data, String mediatype) {
        this(-1, data, mediatype);
    }

    public int getId() {
        return id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public boolean hasId() {
        return this.id >= 0;
    }

    public String getMediatype() {
        return mediatype;
    }
}


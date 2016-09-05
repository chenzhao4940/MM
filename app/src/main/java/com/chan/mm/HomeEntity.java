package com.chan.mm;

import java.io.Serializable;

/**
 * Created by chan on 2016/9/1.
 */
public class HomeEntity implements Serializable {

    private String des;
    private String coversUrl;
    private int id;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getCoversUrl() {
        return coversUrl;
    }

    public void setCoversUrl(String coversUrl) {
        this.coversUrl = coversUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package com.wn.doolittle.content.blueprintitem.client.model;

import com.wn.doolittle.content.client.ContentEntity;

public class BluePrintItemContent extends ContentEntity {
    private static final long serialVersionUID = 1L;

    private String src ;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}

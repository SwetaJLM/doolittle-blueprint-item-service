package com.wn.doolittle.content.blueprintitem.client.model;

import com.wn.doolittle.content.client.AggregatedContentEntity;

public class BluePrintItemContent extends AggregatedContentEntity {
    private static final long serialVersionUID = 1L;

    private ImageProperties src; // BluePrintItem API - Add image field

    public ImageProperties getSrc() {
        return src;
    }

    public void setSrc(ImageProperties src) {
        this.src = src;
    }

}

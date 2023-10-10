package com.wn.doolittle.content.blueprintitem.service.model.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import com.wn.doolittle.content.model.AggregatedContentEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "blueprintitemcontent")
@EntityListeners({ AuditingEntityListener.class })
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

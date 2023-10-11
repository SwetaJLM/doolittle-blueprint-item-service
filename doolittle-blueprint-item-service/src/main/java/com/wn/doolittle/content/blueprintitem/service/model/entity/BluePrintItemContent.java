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

    private String src; // BluePrintItem API - Add src field

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}

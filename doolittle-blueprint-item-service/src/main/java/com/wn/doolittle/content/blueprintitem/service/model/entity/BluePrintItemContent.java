package com.wn.doolittle.content.blueprintitem.service.model.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import com.wn.doolittle.content.model.AggregatedContentEntity;
import com.wn.doolittle.content.model.ContentEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "content")
@EntityListeners({ AuditingEntityListener.class })
public class BluePrintItemContent extends ContentEntity {
    private static final long serialVersionUID = 1L;
    private String src;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}

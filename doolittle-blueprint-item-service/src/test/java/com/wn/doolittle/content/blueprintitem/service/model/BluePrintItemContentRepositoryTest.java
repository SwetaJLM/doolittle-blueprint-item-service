package com.wn.doolittle.content.blueprintitem.service.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.wn.doolittle.content.blueprintitem.service.model.entity.BluePrintItemContent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.wn.doolittle.test.jpa.BaseJpaTest;

@EnableAutoConfiguration
public class BluePrintItemContentRepositoryTest extends BaseJpaTest {

    @Autowired
    private BluePrintItemContentRepository repository;

    @Test
    public void testSaveContentComponents() {
        BluePrintItemContent itemContent = new BluePrintItemContent();
        itemContent.setSrc("./blueprintUrl");

        itemContent = repository.save(itemContent);

        flushAndClearEntityManager();

        BluePrintItemContent bc1 = repository.findById(itemContent.getId()).get();
        assertThat(bc1.getSrc()).isEqualTo("./blueprintUrl");
    }

}

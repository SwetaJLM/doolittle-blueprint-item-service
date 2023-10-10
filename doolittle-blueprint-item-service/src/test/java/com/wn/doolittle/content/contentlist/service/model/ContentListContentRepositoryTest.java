package com.wn.doolittle.content.contentlist.service.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Lists;
import com.wn.doolittle.content.contentlist.service.model.entity.ContentListContent;
import com.wn.doolittle.content.model.CollapseMode;
import com.wn.doolittle.content.model.ContentComponent;
import com.wn.doolittle.content.model.LayoutCell;
import com.wn.doolittle.content.model.LayoutCellType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.wn.doolittle.test.jpa.BaseJpaTest;

import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
public class ContentListContentRepositoryTest extends BaseJpaTest {

    @Autowired
    private ContentListContentRepository repository;

    @Test
    public void testSaveContentComponents() {
        ContentComponent contentComponent = new ContentComponent("Image", "ccId", "imageId", 1L);
        contentComponent.setCollapseMode(CollapseMode.Expanded);
        contentComponent.setConfig("config");
        contentComponent.setCompletionRequired(true);
        contentComponent.setNumbered(false);
        LayoutCell layoutCell = new LayoutCell(LayoutCellType.Component, contentComponent.getId(), 1);
        List<LayoutCell> layoutCells = Lists.newArrayList(layoutCell);
        List<List<LayoutCell>> layout = new ArrayList<>();
        layout.add(layoutCells);
        ContentListContent c = new ContentListContent();
        c.setContentId("contentlistId");
        c.setContentComponents(Lists.newArrayList(contentComponent));
        c.setLayout(layout);
        c.setTemplateId("1");
        c.setTemplateVersion(Long.valueOf(1));

        c = repository.save(c);

        flushAndClearEntityManager();

        ContentListContent c1 = repository.findById(c.getId()).get();
        assertThat(c1.getContentComponents().get(0).getId()).isEqualTo("ccId");
        assertThat(c1.getContentComponents().get(0).getContentType()).isEqualTo("Image");
        assertThat(c1.getContentComponents().get(0).getContentId()).isEqualTo("imageId");
        assertThat(c1.getContentComponents().get(0).getContentVersion()).isEqualTo(1L);
        assertThat(c1.getContentComponents().get(0).getConfig()).isEqualTo("config");
        assertThat(c1.getContentComponents().get(0).getCollapseMode()).isEqualTo(CollapseMode.Expanded);
        assertThat(c1.getContentComponents().get(0).isNumbered()).isEqualTo(false);
        assertThat(c1.getContentComponents().get(0).isCompletionRequired()).isEqualTo(true);
        assertThat(c1.getLayout().get(0).get(0).getComponentId()).isEqualTo("ccId");
        assertThat(c1.getLayout().get(0).get(0).getSize()).isEqualTo(1);
        assertThat(c1.getLayout().get(0).get(0).getCellType()).isEqualTo(LayoutCellType.Component);
        assertThat(c1.getTemplateId()).isEqualTo("1");
        assertThat(c1.getTemplateVersion()).isEqualTo(Long.valueOf(1));
    }

    @Test
    public void testSaveContentTitleEmpty() {
        ContentListContent c = new ContentListContent();
        c.setContentId("contentListEmptyTitle");
        c = repository.save(c);

        flushAndClearEntityManager();

        ContentListContent c1 = repository.findById(c.getId()).get();
        assertThat(c1.getTitle()).isEqualTo(null);
    }

    @Test
    public void testSaveContentValidTitle() {
        ContentListContent c = new ContentListContent();
        c.setContentId("contentListValidTitle");
        c.setTitle("ValidTitle");
        c = repository.save(c);

        flushAndClearEntityManager();

        ContentListContent c1 = repository.findById(c.getId()).get();
        assertThat(c1.getTitle()).isEqualTo(c.getTitle());
    }
}

package com.wn.doolittle.content.contentlist.service.model.entity;

import com.wn.doolittle.content.model.CollapseMode;
import com.wn.doolittle.content.model.ContentComponent;
import com.wn.doolittle.content.model.LayoutCell;
import com.wn.doolittle.content.model.LayoutCellType;
import org.junit.jupiter.api.Test;

import com.google.common.collect.Lists;
import com.wn.doolittle.test.utils.ClientServerModelSerdeTests;

import java.util.ArrayList;
import java.util.List;

public class ModelSerdeTest {

    @Test
    public void testContestListContent() {
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

        ClientServerModelSerdeTests.testRoundtripSerialization(ContentListContent.class,
                com.wn.doolittle.content.contentlist.client.model.ContentListContent.class,
                 c);
    }
}

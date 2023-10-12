package com.wn.doolittle.content.blueprintitem.service.model.entity;

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
        BluePrintItemContent c = new BluePrintItemContent();
        c.setSrc("./blueprintUrl");

        ClientServerModelSerdeTests.testRoundtripSerialization(BluePrintItemContent.class,
                com.wn.doolittle.content.blueprintitem.client.model.BluePrintItemContent.class,
                 c);
    }
}

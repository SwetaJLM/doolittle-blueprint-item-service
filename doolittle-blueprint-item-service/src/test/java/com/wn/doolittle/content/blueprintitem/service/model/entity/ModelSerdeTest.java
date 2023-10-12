package com.wn.doolittle.content.blueprintitem.service.model.entity;

import org.junit.jupiter.api.Test;

import com.wn.doolittle.test.utils.ClientServerModelSerdeTests;

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

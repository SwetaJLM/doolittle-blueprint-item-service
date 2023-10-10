package com.wn.doolittle.content.blueprintitem.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wn.doolittle.content.cache.MultiGetContentPropertiesCacheClient;
import com.wn.doolittle.content.model.impl.DefaultContentProperties;
import com.wn.doolittle.content.model.impl.DefaultContentPropertiesRepository;
import com.wn.doolittle.content.service.DefaultContentController;
import com.wn.doolittle.content.cache.MultiGetCacheClient;
import com.wn.doolittle.content.blueprintitem.service.model.BluePrintItemContentRepository;
import com.wn.doolittle.content.blueprintitem.service.model.entity.BluePrintItemContent;

@RestController
@RequestMapping("/blueprintitemcontent")
public class BluePrintItemContentController
        extends DefaultContentController<BluePrintItemContent, BluePrintItemContentRepository> {
    public BluePrintItemContentController(BluePrintItemContentRepository itemcontentRepository,
                                          DefaultContentPropertiesRepository contentPropertiesRepository,
                                          MultiGetCacheClient<BluePrintItemContent> itemContentCacheClient,
                                          MultiGetContentPropertiesCacheClient<DefaultContentProperties> contentListPropertyCacheClient) {

        super(itemcontentRepository, contentPropertiesRepository, itemContentCacheClient, contentListPropertyCacheClient);
    }
}

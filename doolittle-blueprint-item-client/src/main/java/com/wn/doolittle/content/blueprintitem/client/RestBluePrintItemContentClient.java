package com.wn.doolittle.content.blueprintitem.client;

import com.wn.doolittle.content.client.BaseRestContentClient;
import com.wn.doolittle.content.client.DefaultContentProperties;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wn.doolittle.content.blueprintitem.client.model.BluePrintItemContent;

public class RestBluePrintItemContentClient extends BaseRestContentClient<BluePrintItemContent, DefaultContentProperties>
        implements BluePrintItemContentClient {

    public RestBluePrintItemContentClient(ObjectMapper mapper,
                                          WebClient webClient) {
        super(mapper, webClient, BluePrintItemContent.class, DefaultContentProperties.class);
    }

}


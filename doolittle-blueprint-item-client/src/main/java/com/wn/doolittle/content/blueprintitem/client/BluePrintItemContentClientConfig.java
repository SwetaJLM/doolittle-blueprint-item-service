package com.wn.doolittle.content.blueprintitem.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wn.doolittle.restclient.RestClientFactoryConfig;
import com.wn.doolittle.restclient.WebClientFactory;

@Configuration
@ComponentScan
@Import(RestClientFactoryConfig.class)
public class BluePrintItemContentClientConfig {

    public static final String BLUEPRINTITEM_SERVICE = "doolittle-blueprintitem-service";
    public static final String BLUEPRINTITEM_API_BASE = "/blueprintitem-service/v1";

    @Bean
    public BluePrintItemContentClient bluePrintItemContentClient(ObjectMapper mapper,
            WebClientFactory webClientFactory) {
        return new RestContentListContentClient(mapper,
                webClientFactory.createWebClient(BLUEPRINTITEM_SERVICE, BLUEPRINTITEM_API_BASE));
    }

}

package com.springbootresttemplate.resttemplateusage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplateConfig creates restTemplate and httpHeaders beans.
 *
 * @author  Kayhan ÖZTÜRK
 * @version 0.1
 */
@Component
public class RestTemplateConfig {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders getHttpHeaders(){
        return new HttpHeaders();
    }
}

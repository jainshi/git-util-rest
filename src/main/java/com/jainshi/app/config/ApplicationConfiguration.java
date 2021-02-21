package com.jainshi.app.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.build();
        //enhanceJsonMessageConverter(restTemplate);
        return restTemplate;
    }


/*    private void enhanceJsonMessageConverter(RestTemplate restTemplate) {
        HttpMessageConverter<?> jsonMessageConverter = restTemplate.getMessageConverters().stream()
                .filter(c -> c instanceof MappingJackson2HttpMessageConverter)
                .findFirst()
                .orElse(null);

        if (jsonMessageConverter == null) {
            return;
        }

        List<MediaType> supportedMediaTypes = new ArrayList<>(jsonMessageConverter.getSupportedMediaTypes());
        supportedMediaTypes.add(MediaType.valueOf("text/javascript;charset=UTF-8"));
        ((AbstractHttpMessageConverter) jsonMessageConverter).setSupportedMediaTypes(supportedMediaTypes);
    }*/

}

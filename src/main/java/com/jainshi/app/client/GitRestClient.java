package com.jainshi.app.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.jainshi.app.model.RepositoryInfo;
import com.jainshi.app.model.RepositoryInfoCollection;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Slf4j
@Component
public class GitRestClient {

    @Value("${gitutil.git.base-url}")
    private String gitUrl;

    private static final String REPOS = "repos";

    @Autowired
    private RestTemplate restTemplate;

    private ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

    @SneakyThrows
    public RepositoryInfoCollection getRepositories() {
        var responseJson = restTemplate.getForObject(gitUrl + REPOS, String.class);
        var response = objectMapper.readValue(responseJson, RepositoryInfo[].class);
        log.info("Retrieved repos : {}", response);
        return RepositoryInfoCollection.builder()
                .repositoryInfoList(Arrays.asList(response))
                .build();
    }

}

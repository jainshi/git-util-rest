package com.jainshi.app.resource;

import com.jainshi.app.client.GitRestClient;
import com.jainshi.app.model.RepositoryInfo;
import com.jainshi.app.model.RepositoryInfoCollection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
public class GitUtilResource {

    @Autowired
    private GitRestClient gitRestClient;

    @GetMapping("repositories")
    public ResponseEntity<RepositoryInfoCollection> getAllRepositories() {
        var result = gitRestClient.getRepositories();
        log.info("Result: {}", result);
        return ResponseEntity.ok(result);
    }
}

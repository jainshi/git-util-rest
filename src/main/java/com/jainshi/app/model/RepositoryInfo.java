package com.jainshi.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryInfo {
    private String id;
    private String name;
    private String fullName;
    private String cloneUrl;
    private boolean isPrivate;
    private String ownerLogin;
}

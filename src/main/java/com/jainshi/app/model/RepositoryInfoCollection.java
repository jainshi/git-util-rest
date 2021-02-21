package com.jainshi.app.model;

import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryInfoCollection {
    private List<RepositoryInfo> repositoryInfoList;
}

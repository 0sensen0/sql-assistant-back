package com.sensen.sqlassistant.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SqlCase {
    String name;
    String baseType;
    String fileName;
    String filePath;
    int id;
    String service;
    String userId;
    int fileStorageId;
}

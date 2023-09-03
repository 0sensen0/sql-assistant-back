package com.sensen.sqlassistant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SqlCaseDto {
    String name;
    String service;
    String userId;
}

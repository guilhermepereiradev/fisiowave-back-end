package com.grupo3.fisiowave.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;

@Getter
@Builder
public class EmailDto {

    private String recipient;
    private String subject;
    private String body;
    private HashMap<String, Object> variables;
}

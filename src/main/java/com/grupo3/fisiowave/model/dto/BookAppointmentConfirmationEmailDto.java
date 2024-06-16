package com.grupo3.fisiowave.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;

@Getter
@Builder
public class BookAppointmentConfirmationEmailDto {

    private String recipient;
    private String subject;
    private final String body = "book-appointment-confirmation.html";
    private HashMap<String, Object> variables;
}

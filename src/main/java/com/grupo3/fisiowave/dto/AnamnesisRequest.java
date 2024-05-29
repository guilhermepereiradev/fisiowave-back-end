package com.grupo3.fisiowave.dto;

import com.grupo3.fisiowave.model.Anamnesis;
import com.grupo3.fisiowave.model.Gender;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class AnamnesisRequest {

    @NotEmpty
    private Gender gender;
    @NotEmpty
    @Size(max = 255)
    private String profession;
    @NotNull
    @Positive
    private BigDecimal weight;
    @NotNull
    @Positive
    private BigDecimal height;
    @NotEmpty
    @Size(max = 255)
    private String chiefComplaint;
    @NotEmpty
    @Size(max = 255)
    private String pastMedicalHistory;
    @NotEmpty
    @Size(max = 255)
    private String currentMedications;

    @NotEmpty
    @Size(max = 1000)
    private String observation;

    public void copyToModel(Anamnesis anamnesis) {
        anamnesis.setGender(gender);
        anamnesis.setProfession(profession);
        anamnesis.setWeight(weight);
        anamnesis.setHeight(height);
        anamnesis.setChiefComplaint(chiefComplaint);
        anamnesis.setPastMedicalHistory(pastMedicalHistory);
        anamnesis.setCurrentMedications(currentMedications);
        anamnesis.setObservation(observation);
    }
}

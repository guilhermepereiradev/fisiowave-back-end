package com.grupo3.fisiowave.dto;

import com.grupo3.fisiowave.model.City;
import com.grupo3.fisiowave.model.State;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CityRequest {
    @NotBlank
    private String name;
    @NotBlank
    private State state;

    public void copyToModel(City city) {
        city.setName(this.name);
        city.setState(new State());
        city.getState().setId(this.state.getId());
    }


}

package com.grupo3.fisiowave.dto;

import com.grupo3.fisiowave.model.City;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class CityResponse {

    private UUID id;
    private String name;
    private StateResponse state;

    public static CityResponse of(City city) {
        return new CityResponse(city.getId(), city.getName(), StateResponse.of(city.getState()));
    }

    public static List<CityResponse> of(List<City> cities) {
        return cities.stream().map(CityResponse::of).toList();
    }
}

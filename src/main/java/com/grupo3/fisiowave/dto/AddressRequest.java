package com.grupo3.fisiowave.dto;

import com.grupo3.fisiowave.model.Address;
import com.grupo3.fisiowave.model.City;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class AddressRequest {

    @Size(max = 8)
    private String zipCode;
    @Size(max = 125)
    private String street;
    @Size(max = 8)
    private String number;
    @Size(max = 125)
    private String complement;
    @Size(max = 125)
    private String neighborhood;
    private CityIdRequest city;

    public void copyToModel(Address address) {
        address.setZipCode(this.zipCode);
        address.setStreet(this.street);
        address.setNumber(this.number);
        address.setComplement(this.complement);
        address.setNeighborhood(this.neighborhood);

        address.setCity(new City());
        address.getCity().setId(this.city.getId());
    }

    @Data
    public static class CityIdRequest {
        private UUID id;
    }
}

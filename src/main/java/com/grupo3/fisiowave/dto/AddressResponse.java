package com.grupo3.fisiowave.dto;

import com.grupo3.fisiowave.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressResponse {

    private String zipCode;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private CityResponse city;

    public static AddressResponse of(Address address) {
        if (address == null) return null;
        return new AddressResponse(
                address.getZipCode(),
                address.getStreet(),
                address.getNumber(),
                address.getComplement(),
                address.getNeighborhood(),
                CityResponse.of(address.getCity())
        );
    }
}

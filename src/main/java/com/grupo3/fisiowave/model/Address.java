package com.grupo3.fisiowave.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class Address {

    @Column(name = "address_zip_code", length = 8)
    private String zipCode;

    @Column(name = "address_street", length = 125)
    private String street;

    @Column(name = "address_number", length = 8)
    private String number;

    @Column(name = "address_complement", length = 125)
    private String complement;

    @Column(name = "address_neighborhood", length = 125)
    private String neighborhood;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_city_id")
    private City city;

}

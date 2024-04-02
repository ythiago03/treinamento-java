package com.treinamento.crud.models.dto;

import com.treinamento.crud.models.tables.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddressDto {
    private Long id;
    private Long idCustomer;
    private String street;
    private int number;
    private String zipCode;
    private String district;
    private String complement;


    public AddressDto(Address address){
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.zipCode = address.getZipCode();
        this.district = address.getDistrict();
        this.complement = address.getComplement();
    }
}

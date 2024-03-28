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
    

    public AddressDto(Address address){
        this.street = address.getStreet();
        this.number = address.getNumber();
    }
}

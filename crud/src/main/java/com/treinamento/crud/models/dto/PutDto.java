package com.treinamento.crud.models.dto;

import com.treinamento.crud.models.tables.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PutDto {

    
    private Long idCustomer;
    private Long id;
    private String name;
    private String email;
    private String birthday;
    private String zipCode;
    private String street;
    private String district;
    private String complement;
    private int number;


     public void putDto(Customer customer) {
        this.name = customer.getName();
        this.birthday = customer.getBirthday();
        this.email = customer.getEmail();
         if(!customer.getAddress().isEmpty())this.complement = customer.getAddress().get(0).getComplement();
         if(!customer.getAddress().isEmpty())this.zipCode = customer.getAddress().get(0).getZipCode();
         if(!customer.getAddress().isEmpty())this.district = customer.getAddress().get(0).getDistrict();
         if(!customer.getAddress().isEmpty())this.number = customer.getAddress().get(0).getNumber();
         if(!customer.getAddress().isEmpty())this.street = customer.getAddress().get(0).getStreet();
    }
}

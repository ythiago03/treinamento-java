package com.treinamento.crud.models.dto;

import com.treinamento.crud.models.tables.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerDto {
    private String name;
    private String email;
    private String phone;
    private String birthday;
    private String cpf;
    private Long id;

    public CustomerDto(Customer customer){
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();
        this.cpf = customer.getCpf();
        this.birthday = customer.getBirthday();
    }

    
}

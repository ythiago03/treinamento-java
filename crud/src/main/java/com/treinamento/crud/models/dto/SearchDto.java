package com.treinamento.crud.models.dto;

import com.treinamento.crud.models.tables.Customer;

public class SearchDto {
    String name;

    public SearchDto(Customer customer){
        this.name = customer.getName();
    }
}

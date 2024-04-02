package com.treinamento.crud.models.dto;

import com.treinamento.crud.models.tables.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FullSizeDto {
    private String name;
    private String email;
    private String cpf;
    private String birthday;
    private String zipCode;
    private String street;
    private String district;
    private String complement;
    private int number;
    private Long idCustomer;
    private Long id;
}

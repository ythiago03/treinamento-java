package com.treinamento.crud.models.dto;

import com.treinamento.crud.models.tables.Customer;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerDto {
        
    private Long id;

    @NotBlank(message = "Nome é um campo obrigatório")
    private String name;

    @NotBlank(message = "Cpf é um campo obrigatório")
    private String email;
   
    private String phone;

    @NotBlank(message = "Data de nascimento é um campo obrigatório")
    private String birthday;

    @NotBlank(message = "Cpf é um campo obrigatório")
    private String cpf;

    public CustomerDto(Customer customer){
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();  
        this.cpf = customer.getCpf();
        this.birthday = customer.getBirthday();
    }

    
}

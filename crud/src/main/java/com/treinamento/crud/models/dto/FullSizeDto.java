package com.treinamento.crud.models.dto;

import com.treinamento.crud.models.tables.Customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FullSizeDto {

    private Long idCustomer;
    private Long id;

    @NotBlank(message = "Nome é um campo obrigatório")
    @Size(min=2, max=50, message = "Nome precisa ter no minimo 2 letras e no máximo 50")
    private String name;

    @NotBlank(message = "Email é um campo obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "Cpf é um campo obrigatório")
    private String cpf;

    @NotBlank(message = "Data de nascimento é um campo obrigatório")
    private String birthday;

    @NotBlank(message = "Cep é um campo obrigatório")
    private String zipCode;

    @NotBlank(message = "Rua é um campo obrigatório")
    private String street;

    @NotBlank(message = "Bairro é um campo obrigatório")
    private String district;

    private String complement;

    @NotNull(message = "Número da casa é um campo obrigatório")
    @Min(1)
    private int number;


     public FullSizeDto(Customer customer) {
            this.name = customer.getName();
            this.birthday = customer.getBirthday();
            this.cpf = customer.getCpf();
            this.email = customer.getEmail();
         if(!customer.getAddress().isEmpty())this.complement = customer.getAddress().get(0).getComplement();
         if(!customer.getAddress().isEmpty())this.zipCode = customer.getAddress().get(0).getZipCode();
         if(!customer.getAddress().isEmpty())this.district = customer.getAddress().get(0).getDistrict();
         if(!customer.getAddress().isEmpty())this.number = customer.getAddress().get(0).getNumber();
         if(!customer.getAddress().isEmpty())this.street = customer.getAddress().get(0).getStreet();
    }
    
}

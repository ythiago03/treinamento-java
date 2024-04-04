package com.treinamento.crud.models.tables;

import java.util.ArrayList;
import java.util.List;

import com.treinamento.crud.models.dto.CustomerDto;
import com.treinamento.crud.models.dto.FullSizeDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 11)
    private String cpf;

    @Column(length = 50)
    private String name;

    @Column(length = 14)
    private String phone;

    @Column(length = 14)
    private String birthday;

    @Column(length = 20)
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Address> address = new ArrayList<Address>();



    public Customer(CustomerDto dto){
        this.name = dto.getName();
        this.cpf = dto.getCpf();
        this.email = dto.getEmail();
        this.phone = dto.getPhone();
        this.birthday = dto.getBirthday();
    }

    public Customer(FullSizeDto dto){
        this.name = dto.getName();
        this.cpf = dto.getCpf();
        this.email = dto.getEmail();
        this.birthday = dto.getBirthday();
        Address address = new Address(dto,this);
        this.address.add(address);
    }



    public void update(CustomerDto dto){
        if(dto.getName() != null) {
            this.name = dto.getName();
            System.out.println(this.getName());
        }
        if(dto.getCpf() != null) {
            this.cpf = dto.getCpf();
            System.out.println(this.getCpf());
        }
        if(dto.getEmail() != null) {
            this.email = dto.getEmail();
            System.out.println(this.getEmail());
        }
        if(dto.getPhone() != null) {
            this.phone = dto.getPhone();
            System.out.println(this.getPhone());
        }
    }
}

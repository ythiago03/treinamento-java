package com.treinamento.crud.models.tables;

import com.treinamento.crud.models.dto.AddressDto;
import com.treinamento.crud.models.dto.FullSizeDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 50)
    private String street;
    @Column(length = 10)
    private int number;
    @Column(length = 14)
    private String zipCode;
    @Column(length = 50)
    private String district;
    @Column(length = 20)
    private String complement;

    
    @ManyToOne
    @JoinColumn(name = "IdCustomer")
    private Customer customer;


    public Address(AddressDto dto, Customer customer){
        this.customer = customer;
        this.street = dto.getStreet();
        this.number = dto.getNumber();
        this.zipCode = dto.getZipCode();
        this.district = dto.getDistrict();
        this.complement = dto.getComplement();
    }

    public Address(FullSizeDto dto, Customer customer){
        this.customer = customer;
        this.street = dto.getStreet();
        this.number = dto.getNumber();
        this.zipCode = dto.getZipCode();
        this.district = dto.getDistrict();
        this.complement = dto.getComplement();
    }


    public void update(AddressDto dto){
        if(dto.getStreet() != null) this.street = dto.getStreet();
        if(dto.getNumber() >=0) this.number = dto.getNumber();
    }
}

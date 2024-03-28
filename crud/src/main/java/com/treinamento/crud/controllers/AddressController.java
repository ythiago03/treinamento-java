package com.treinamento.crud.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.crud.models.dto.AddressDto;
import com.treinamento.crud.models.tables.Address;
import com.treinamento.crud.service.AddressService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("address")
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public void post(@RequestBody AddressDto dto){
        addressService.saveAddress(dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
       addressService.deleteAddress(id);
    }

    @GetMapping("{id}")
    public AddressDto get(@PathVariable Long id){
        Address address = addressService.getAddress(id);
        return new AddressDto(address);
    }
    
    @PutMapping
    @Transactional
    public void put(@RequestBody AddressDto dto){
        addressService.putAddress(dto);
    }
    
}

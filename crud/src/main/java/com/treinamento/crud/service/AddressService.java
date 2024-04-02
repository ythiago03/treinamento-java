package com.treinamento.crud.service;

import org.springframework.stereotype.Service;

import com.treinamento.crud.models.dto.AddressDto;
import com.treinamento.crud.models.dto.FullSizeDto;
import com.treinamento.crud.models.tables.Address;
import com.treinamento.crud.models.tables.Customer;
import com.treinamento.crud.repository.AddressRepository;
import com.treinamento.crud.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    public void saveAddress(AddressDto dto){
        Customer customer = customerRepository.getReferenceById(dto.getIdCustomer());
        Address address = new Address(dto, customer);
        addressRepository.save(address);
        customer.getAddress().add(address);
    }

    public void saveAddress(FullSizeDto dto){
        Customer customer = customerRepository.getReferenceById(dto.getIdCustomer());
        Address address = new Address(dto, customer);
        addressRepository.save(address);
        customer.getAddress().add(address);
    }

    public void deleteAddress(Long id){
        addressRepository.deleteById(id);
    }

    public Address getAddress(Long id){
        return addressRepository.getReferenceById(id);
    }

    public void putAddress(AddressDto dto){
        Address address = addressRepository.getReferenceById(dto.getId());
        address.update(dto);
    }
}

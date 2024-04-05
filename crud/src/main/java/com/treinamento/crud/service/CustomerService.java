package com.treinamento.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.treinamento.crud.models.dto.CustomerDto;
import com.treinamento.crud.models.dto.FullSizeDto;
import com.treinamento.crud.models.dto.PutDto;
import com.treinamento.crud.models.tables.Address;
import com.treinamento.crud.models.tables.Customer;
import com.treinamento.crud.repository.AddressRepository;
import com.treinamento.crud.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service//Indica que é um serviços
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    public void save(CustomerDto dto){
        Customer customer = new Customer(dto);
        customerRepository.save(customer);
    }
    public void saveApi(FullSizeDto dto){
        Customer customer = new Customer(dto);
        customerRepository.save(customer);
    }

    public void delete(Long id){
        customerRepository.deleteById(id);
    }    
    public void deleteApi(String cpf){
        customerRepository.deleteByCpf(cpf);
    }    
    public Customer get(Long id){
        return customerRepository.getReferenceById(id);
    }
    public List<Customer> getAll(CustomerDto dto){
        return customerRepository.findAllByName(dto.getName());
    }

    public List<Customer> getAllByApi(String name){
        return customerRepository.findAllByName(name);
    }

    public void put(CustomerDto dto){
        Customer customer = customerRepository.getReferenceById(dto.getId());
        customer.update(dto);
    }
    
    public void putApi(String cpf, PutDto dto){
        Customer customer = customerRepository.getReferenceByCpf(cpf);
        customer.updateApi(dto);
        if(!customer.getAddress().isEmpty()){
            Address address = addressRepository.getReferenceById(customer.getAddress().get(0).getId());
            address.updateApi(dto);
        }   
    }
}

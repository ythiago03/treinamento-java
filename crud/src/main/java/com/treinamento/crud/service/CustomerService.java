package com.treinamento.crud.service;

import org.springframework.stereotype.Service;
import com.treinamento.crud.models.dto.CustomerDto;
import com.treinamento.crud.models.tables.Customer;
import com.treinamento.crud.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service//Indica que é um serviço
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void save(CustomerDto dto){
        Customer customer = new Customer(dto);
        customerRepository.save(customer);
    }
    public void delete(Long id){
        customerRepository.deleteById(id);
    }    
    public Customer get(Long id){
        return customerRepository.getReferenceById(id);
    }
    public void put(CustomerDto dto){
        Customer customer = customerRepository.getReferenceById(dto.getId());
        //System.out.println(customer.getName());
        customer.update(dto);
    }
    
}

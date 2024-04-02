package com.treinamento.crud.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.crud.models.dto.CustomerDto;
import com.treinamento.crud.models.dto.FullSizeDto;
import com.treinamento.crud.models.tables.Customer;
import com.treinamento.crud.service.CustomerService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> cadastrarCliente(@RequestBody CustomerDto dto){
        customerService.save(dto);
        return ResponseEntity.ok(dto);

    }

    @PostMapping("/apiCustomer")
    @CrossOrigin("http://localhost:4200/")
    public ResponseEntity<FullSizeDto> cadastrarClienteApi(@RequestBody FullSizeDto dto){
        System.out.println(dto.getName());
        customerService.saveApi(dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    public void deletarCliente(@PathVariable Long id){
        customerService.delete(id);
    }

    @GetMapping("{id}")
    public CustomerDto buscarCliente(@PathVariable Long id){
        Customer customer = customerService.get(id);
        return new CustomerDto(customer);
    }

    @GetMapping
    public void buscarClienteTeste(@RequestBody CustomerDto dto){
        List<Customer> list = customerService.getAll(dto);
    }

    @PutMapping
    @Transactional
    public void atualizarCliente(@RequestBody CustomerDto dto){
        customerService.put(dto);
    }
}
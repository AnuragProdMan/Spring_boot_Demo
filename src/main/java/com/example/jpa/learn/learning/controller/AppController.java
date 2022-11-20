package com.example.jpa.learn.learning.controller;

import com.example.jpa.learn.learning.dto.CustomerDto;
import com.example.jpa.learn.learning.entity.Customer;
import com.example.jpa.learn.learning.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class AppController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/get-cust")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> allCustomers = customerService.getAllCustomers();
        return ResponseEntity.ok(allCustomers);
    }

    @GetMapping(value = "/getByCompany")
    public ResponseEntity<List<Customer>> getByCompany(@RequestParam("company")String company){
        List<Customer> customers = customerService.findByCompany(company);
        return ResponseEntity.ok(customers);
    }

}

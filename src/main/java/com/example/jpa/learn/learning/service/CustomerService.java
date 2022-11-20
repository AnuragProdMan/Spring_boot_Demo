package com.example.jpa.learn.learning.service;

import com.example.jpa.learn.learning.dto.CustomerDto;
import com.example.jpa.learn.learning.entity.Customer;
import com.example.jpa.learn.learning.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerService {
    @Autowired
    public CustomerRepo customerRepo;

    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    public List<Customer> findByCompany(String company) {
        return customerRepo.findByCompany(company);
    }
}

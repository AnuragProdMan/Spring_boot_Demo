package com.example.jpa.learn.learning.controller;

import com.example.jpa.learn.learning.dto.CustomerDto;
import com.example.jpa.learn.learning.entity.Customer;
import com.example.jpa.learn.learning.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class AppController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/get-cust")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> allCustomers = customerService.getAllCustomers();
        //allCustomers.stream().filter(v -> v.getCompany().equals("HSBC")).collect(Collectors.toList());
        log.info("{}",allCustomers);
        return ResponseEntity.ok(allCustomers);
    }

    @GetMapping(value = "/getByCompany")
    public ResponseEntity<List<Customer>> getByCompany(@RequestParam("company")String company){
        //List<Customer> customers = customerService.findByCompany(company);
        //Call get-cust and then filter
        String url = "http://localhost:8084/get-cust";
        //1 solution
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);//Can pass entity as null if nothing is in header
//        Customer[] allCustomerByCompany = restTemplate.exchange(url,HttpMethod.GET,httpEntity,Customer[].class).getBody();
//        List<Customer> allCustomerByCompanyList = Arrays.asList(allCustomerByCompany);
        //To retrieve list
        List<Customer> allCustomerByCompanyList = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>() {}).getBody();
        allCustomerByCompanyList = allCustomerByCompanyList.stream().filter(v -> v.getCompany().equalsIgnoreCase(company)).collect(Collectors.toList());
        return ResponseEntity.ok(allCustomerByCompanyList);
    }






}

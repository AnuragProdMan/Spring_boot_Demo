package com.example.jpa.learn.learning.repository;

import com.example.jpa.learn.learning.dto.CustomerDto;
import com.example.jpa.learn.learning.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CustomerRepo extends JpaRepository<Customer,String> {
        @Query(value = "SELECT * FROM CREDIT.CUSTOMER WHERE COMPANY=:company",nativeQuery = true)
        List<Customer> findByCompany(@Param("company") String company);

}

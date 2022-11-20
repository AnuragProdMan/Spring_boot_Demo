package com.example.jpa.learn.learning.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(
        name = "Customer",
        schema = "credit"
)
public class Customer {

    @Id
    @Column(name = "id")
    public Integer id;
    @Column(name = "name")
    public String name;
    @Column(name = "company")
    public String company;

}

package com.alper.couponear.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="cpdb_companies")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company_name")
    private String name;

    @Column(name = "owner_id")
    private String owner;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "mail")
    private String email;

    @Column(name = "phone")
    private  String phone;

}

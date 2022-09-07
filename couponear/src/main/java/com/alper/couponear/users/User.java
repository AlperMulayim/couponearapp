package com.alper.couponear.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "cpdb_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_uid")
    private String  uid;

    @Column(name = "first_name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name =  "mail")
    private String email;
}

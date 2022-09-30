package com.alper.couponear.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Entity
@Table(name = "cpdb_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @Column(name = "available_system_cards")
    private Integer availableSystemCards;

    @ManyToMany
    @JoinTable(
            name = "cpdb_user_references",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "reference_id")
    )
    private List<User> references;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private UserRole role;

}

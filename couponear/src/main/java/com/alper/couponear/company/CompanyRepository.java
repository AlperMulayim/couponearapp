package com.alper.couponear.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
    Optional<Company> findById(Integer id);
    List<Company> findByCityAndOwner(String city, String ownerId);
    List<Company> findByOwner(String  owner);
    List<Company> findByCity(String city);
}

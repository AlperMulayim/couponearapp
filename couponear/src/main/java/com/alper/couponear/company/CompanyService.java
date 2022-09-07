package com.alper.couponear.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    @Autowired
    private  CompanyRepository repository;

    public List<Company> getCompanies(){
        return  repository.findAll();
    }

    public  List<Company> getCompanies(Optional<String> owner,Optional<String> city){

        List<Company> companies = repository.findAll();

        if(owner.isPresent()){
            companies = companies.stream()
                    .filter(company -> company.getOwner().equals(owner.get())).collect(Collectors.toList());
        }
        if(city.isPresent()){
            companies = companies.stream()
                    .filter(company -> company.getCity().toUpperCase().trim().equals(city.get().toUpperCase().trim()))
                    .collect(Collectors.toList());
        }

        return  companies;
    }

    public Optional<Company> getCompany(Integer id){
        return repository.findById(id);
    }

}

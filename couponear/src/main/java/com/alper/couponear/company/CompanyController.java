package com.alper.couponear.company;


import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/companies")
public class CompanyController {

    @Autowired
    private  CompanyService service;

    @GetMapping
    public List<Company> getCompanies(@RequestParam(name = "city",required = false) Optional<String> city,
                                      @RequestParam(name = "owner",required = false) Optional<String> owner){
        return  service.getCompanies(owner,city);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable(name = "id") Integer id){

        Optional<Company> companyOp = service.getCompany(id);

        if(companyOp.isPresent()){
            return   ResponseEntity.ok(companyOp.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
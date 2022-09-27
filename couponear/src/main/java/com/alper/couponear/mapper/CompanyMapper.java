package com.alper.couponear.mapper;

import com.alper.couponear.company.Company;
import org.springframework.stereotype.Component;

@Component("mapper-company")
public class CompanyMapper  implements  IEntityMapper<Company, CompanyDTO> {
    @Override
    public CompanyDTO toDTO(Company company) {
        return CompanyDTO.builder()
                .id(company.getId())
                .adress(company.getAddress())
                .city(company.getCity())
                .spec(company.getId() + "-" + company.getCity())
                .build();
    }

    @Override
    public Company toEntity(CompanyDTO companyDTO) {
        return Company.builder()
                .id(companyDTO.getId())
                .address(companyDTO.getAdress())
                .city(companyDTO.getCity())
                .build();
    }
}

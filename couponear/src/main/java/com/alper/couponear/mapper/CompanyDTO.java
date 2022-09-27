package com.alper.couponear.mapper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyDTO {
    private Integer id;
    private String adress;
    private String city;
    private String spec;
}

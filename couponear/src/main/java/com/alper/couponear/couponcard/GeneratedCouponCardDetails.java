package com.alper.couponear.couponcard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GeneratedCouponCardDetails {
    private String username;
    private String companyName;
    private String cardBarcode;
    private String qrCode;
    private String expireDate;
    private String name;
    private String details;
    private String rules;
}

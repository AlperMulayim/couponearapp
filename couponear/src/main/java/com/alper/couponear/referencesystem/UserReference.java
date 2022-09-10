package com.alper.couponear.referencesystem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReference {
    private Integer refereeId;
    private  String name;
    private String surname;
    private String email;
}

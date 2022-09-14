package com.alper.couponear.couponcard;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cpdb_discount_cards")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CouponCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name="campaing_id")
    private Integer campaingId;

    @Column(name = "campaing_name")
    private String campaingName;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "expire_date")
    private Date expireDate;

    @Column(name = "used_date")
    private Date usedDate;
}

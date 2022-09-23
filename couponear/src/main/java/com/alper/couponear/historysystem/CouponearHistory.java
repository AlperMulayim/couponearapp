package com.alper.couponear.historysystem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cpdb_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponearHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_content")
    private String content;

    @Column(name = "object_name")
    private String objectName;

    @Column(name = "create_date")
    private Date createDate;
}

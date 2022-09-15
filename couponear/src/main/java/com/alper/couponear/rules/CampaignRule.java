package com.alper.couponear.rules;

import com.alper.couponear.campaing.Campaign;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

//      CREATE TABLE cpdb_campaign_rules(
//        id INT NOT NULL AUTO_INCREMENT,
//        campaign_id INT,
//        rule_name VARCHAR(500),
//        create_date DATE,
//        rule_type ENUM("R_CAMPAIGN","R_DEFAULT"),
//        PRIMARY KEY(id),
//        FOREIGN KEY(campaign_id) REFERENCES cpdb_campaigns(id)
//        );
@Entity
@Table(name = "cpdb_rules")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CampaignRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rule_name")
    private String ruleName;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "rule_type", length = 255, columnDefinition = "enum")
    @Enumerated(EnumType.STRING)
    private CampaignRuleType campaignRuleType;
}

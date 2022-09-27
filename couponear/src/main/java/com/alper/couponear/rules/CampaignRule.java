package com.alper.couponear.rules;

import com.alper.couponear.campaing.Campaign;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "rule_type", length = 255, columnDefinition = "enum")
    @JsonProperty("type")
    @Enumerated(EnumType.STRING)
    private CampaignRuleType campaignRuleType;
}

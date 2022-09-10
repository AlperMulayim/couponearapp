package com.alper.couponear.company;

import com.alper.couponear.campaing.Campaign;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDetail {
    private String companyName;
    private Integer totalCampaigns;
    private Integer totalCards;
    private Integer totalUsedCards;
    private Integer activeCampaigns;
    private Integer availableTotalCampaign;
    private Integer availableTotalCard;
}

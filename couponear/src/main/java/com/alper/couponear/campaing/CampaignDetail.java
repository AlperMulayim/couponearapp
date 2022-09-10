package com.alper.couponear.campaing;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CampaignDetail {
    private Campaign campaign;
    private CampaignStatistic statistic;

}

package com.alper.couponear.campaing;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CampaignStatistic {
    private Integer totalCard;
    private Integer usedCard;
}

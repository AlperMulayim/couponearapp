package com.alper.couponear.campaing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cpdb_campaigns")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(name = "owner_id")
    private  Integer ownerId;
    @Column(name = "campaign_id")
    private  String uid;
    @Column(name = "num_of_cards")
    private Integer numOfCards;
    @Column(name = "campaign_name")
    private String  name;
    @Column(name = "campaign_detail")
    private String detail;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "expire_date")
    private Date expireDate;

    @ManyToMany
    @JoinTable(
            name="cpdb_campaign_categories",
            joinColumns = @JoinColumn(name = "campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CampaignCategories> categories;

}

package com.alper.couponear.company;

import com.alper.couponear.campaing.Campaign;
import com.alper.couponear.campaing.CampaignService;
import com.alper.couponear.couponcard.CouponCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    @Autowired
    private  CompanyRepository repository;

    @Autowired
    private CampaignService campaignService;

    @Autowired
    private CouponCardService cardService;

    @Value("${appset.totalcampaings}")
    private Integer appTotalCampaings;
    @Value("${appset.totalcards}")
    private Integer appTotalCards;

    public List<Company> getCompanies(){
        return  repository.findAll();
    }


    public  List<Company> getCompanies(Optional<String> owner,Optional<String> city){

        List<Company> companies = repository.findAll();

        if(owner.isPresent()){
            companies = companies.stream()
                    .filter(company -> company.getOwner().equals(owner.get())).collect(Collectors.toList());
        }
        if(city.isPresent()){
            companies = companies.stream()
                    .filter(company -> company.getCity().toUpperCase().trim().equals(city.get().toUpperCase().trim()))
                    .collect(Collectors.toList());
        }

        return  companies;
    }

    public Optional<Company> getCompany(Integer id){
        return repository.findById(id);
    }

    public Optional<CompanyDetail> getCompanyDetail(Integer id){

        Optional<CompanyDetail> companyDetailOp = Optional.empty();
        Optional<Company> company = repository.findById(id);
        List<Campaign> allCampaigns =campaignService.getCampaigns();

        List<Campaign> companyCampaigns = allCampaigns.stream()
                .filter(campaign -> campaign.getOwnerId().equals(id))
                .collect(Collectors.toList());

        Date today = new Date(System.currentTimeMillis());
        Integer acticveCampaings = Math.toIntExact(companyCampaigns.stream()
                .filter(campaign -> campaign.getExpireDate().getTime() > today.getTime())
                .count());

        Integer totalCardsCreated = Math.toIntExact(
                cardService.getCards().stream().filter(card -> card.getCompanyId().equals(id))
                .count());

        Integer totalCardsUsed= Math.toIntExact(
                cardService.getCards().stream()
                        .filter(card -> card.getCompanyId().equals(id))
                        .filter(card -> card.getUsedDate() != null)
                        .count());


        if(company.isPresent()){
            CompanyDetail detail = CompanyDetail.builder()
                    .companyName(company.get().getName())
                    .activeCampaigns(acticveCampaings)
                    .totalCampaigns(companyCampaigns.size())
                    .availableTotalCampaign(appTotalCampaings - companyCampaigns.size())
                    .totalCards(totalCardsCreated)
                    .availableTotalCard(appTotalCards - totalCardsCreated)
                    .totalUsedCards(totalCardsUsed)
                    .build();

            companyDetailOp = Optional.of(detail);
        }
        return companyDetailOp;
    }

}

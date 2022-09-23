package com.alper.couponear.historysystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryService {
    @Autowired
    private CouponearHistoryRepository repository;

    public List<CouponearHistory> getAll(){
        return  repository.findAll();
    }

    public CouponearHistory addContent(Object data){
        Date date = Date.from(LocalDateTime.now().
                toInstant( ZoneId.of("Europe/Berlin").getRules().getOffset(Instant.now())));

        CouponearHistory history = CouponearHistory.builder()
                .objectName(data.getClass().getName())
                .content(data.toString())
                .createDate(date)
                .build();

        repository.save(history);
        return  history;
    }
    @Scheduled(cron = "0 */1 * * * ?")
    public void deleteData(){
        Date date = Date.from(LocalDateTime.now().
                toInstant( ZoneId.of("Europe/Berlin").getRules().getOffset(Instant.now())));

        List<CouponearHistory> histories = repository.findAll();
        List<CouponearHistory> deletedHistories = histories.stream()
                .filter(couponearHistory -> couponearHistory.getCreateDate().equals(date))
                        .collect(Collectors.toList());

        repository.deleteAll(deletedHistories);
    }
}

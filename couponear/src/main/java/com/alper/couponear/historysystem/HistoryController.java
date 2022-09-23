package com.alper.couponear.historysystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/history")
public class HistoryController {
    @Autowired
    private HistoryService service;

    @GetMapping
    public List<CouponearHistory> getAll(){
        return service.getAll();
    }
}

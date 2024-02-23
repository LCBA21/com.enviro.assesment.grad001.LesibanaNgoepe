package com.example.investorassessment.controller;

import com.example.investorassessment.entity.WithdrawalNotice;
import com.example.investorassessment.service.WithdrawalNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/withdrawal-notices")
public class WithdrawalNoticeController {

    @Autowired
    private WithdrawalNoticeService noticeService;


    @PostMapping("/createNotice")
    public WithdrawalNotice notice(@RequestBody WithdrawalNotice notice){
        return noticeService.createNotice(notice);
    }

}

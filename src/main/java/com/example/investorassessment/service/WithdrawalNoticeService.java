package com.example.investorassessment.service;


import com.example.investorassessment.entity.Investor;
import com.example.investorassessment.entity.Product;
import com.example.investorassessment.entity.ProductType;
import com.example.investorassessment.entity.WithdrawalNotice;
import com.example.investorassessment.repository.WithdrawalNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WithdrawalNoticeService {

    @Autowired
    private WithdrawalNoticeRepository noticeRepository;

    public WithdrawalNotice createNotice(WithdrawalNotice notice){
        return noticeRepository.save(notice);
    }


//    public String createNotice(WithdrawalNotice notice , ProductType type, Integer Age){
//        String errorMessage="";
//
//        BigDecimal withdrawalAmount = notice.getWithdrawalAmount();
//        BigDecimal currentBalance = notice.getProduct().getCurrentBalance();
//
//
//        if(type.equals("RETIREMENT") && Age <=65){
//            errorMessage="Investor is below the age of 65 and cannot have Retirement type";
//            return  errorMessage;
//        } else if (withdrawalAmount.compareTo(currentBalance) >0 || withdrawalAmount.compareTo(currentBalance.multiply(BigDecimal.valueOf(0.9))) > 0) {
//            errorMessage="Withdrawal exceeds balance or Withdrawal is more than 90%";
//            return errorMessage;
//        }
//
//        noticeRepository.save(notice);
//
//        return "Notice Created";
//    }


}

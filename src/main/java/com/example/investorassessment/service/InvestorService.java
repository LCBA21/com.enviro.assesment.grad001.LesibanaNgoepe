package com.example.investorassessment.service;

import com.example.investorassessment.entity.Investor;
import com.example.investorassessment.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestorService {

    @Autowired
    InvestorRepository investorRepository;

    public Investor addInvestor( Investor investor){
        return investorRepository.save(investor);
    }

    public Investor Byid( Long investor_id){
        return investorRepository.findById(investor_id).get();
    }


    public List<Investor> getAll(){
      return  investorRepository.findAll();
    }
}

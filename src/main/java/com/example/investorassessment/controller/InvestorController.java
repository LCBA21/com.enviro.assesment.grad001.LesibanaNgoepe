package com.example.investorassessment.controller;

import com.example.investorassessment.entity.Investor;
import com.example.investorassessment.service.FileService;
import com.example.investorassessment.service.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/api/investors")
public class InvestorController {


    @Autowired
    private InvestorService investorService;

    @Autowired
    private FileService fileService;



    @PostMapping("/createInvestor")
    public Investor save(@RequestBody Investor investor){
       return investorService.addInvestor(investor);
    }


    @GetMapping("/downloadFile")
    public ResponseEntity<Resource> downloadFile(){

        String fileName="WithdrawalNotice.csv";
        ByteArrayInputStream fileData=fileService.load();
        InputStreamResource resource = new InputStreamResource(fileData);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename="+fileName)
                .contentType(MediaType.parseMediaType("application/csv")).body(resource);
    }

    @GetMapping("/allInvestor")
    public List<Investor> AllInvestors(){
        return  investorService.getAll();
    }


    @GetMapping("/{id}")
    public Investor investorById(@PathVariable Long id){

        return investorService.Byid(id);
    }

}

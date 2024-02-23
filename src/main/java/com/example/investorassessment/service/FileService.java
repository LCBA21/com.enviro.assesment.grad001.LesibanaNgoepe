package com.example.investorassessment.service;

import com.example.investorassessment.entity.Investor;
import com.example.investorassessment.entity.WithdrawalNotice;
import com.example.investorassessment.repository.InvestorRepository;
import com.example.investorassessment.repository.WithdrawalNoticeRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@Service
public class  FileService {

    @Autowired
    private InvestorRepository investorRepository;


    @Autowired
    private WithdrawalNoticeRepository noticeRepository;



    public ByteArrayInputStream load() {

            List<Investor> investors= investorRepository.findAll();
            List<WithdrawalNotice> notices=noticeRepository.findAll();
           ByteArrayInputStream stream=investorToCSV(notices);
           return stream;
    }

    private ByteArrayInputStream investorToCSV(List<WithdrawalNotice> notices) {
        CSVFormat csvFormat = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(outputStream), csvFormat)) {

            for (WithdrawalNotice notice : notices) {
                csvPrinter.printRecord(

                        notice.getWithdrawalAmount(),
                        notice.getBankingDetails(),
                        notice.getStartDate(),
                        notice.getEndDate()
                );
            }
            csvPrinter.flush(); // Flush the CSV data into the output stream
            return new ByteArrayInputStream(outputStream.toByteArray());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

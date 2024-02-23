package com.example.investorassessment.service;


import com.example.investorassessment.entity.Investor;
import com.example.investorassessment.entity.Product;
import com.example.investorassessment.repository.InvestorRepository;
import com.example.investorassessment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InvestorRepository investorRepository;
    public Investor investInProduct(Product product,Long inv_id){
        Investor investor = investorRepository.findById(inv_id).get();
        product.setInvestor(investor);
        productRepository.save(product);
        return investor;
    }
}

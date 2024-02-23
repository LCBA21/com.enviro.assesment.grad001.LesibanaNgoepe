package com.example.investorassessment.controller;


import com.example.investorassessment.entity.Investor;
import com.example.investorassessment.entity.Product;
import com.example.investorassessment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/investProduct/{investor_id}")
    private Investor Product(@RequestBody Product product, @PathVariable Long investor_id){
        return productService.investInProduct(product,investor_id);
    }


}

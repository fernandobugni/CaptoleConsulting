package com.example.CaptoleConsulting.Controllers;

import com.example.CaptoleConsulting.Entities.Brand;
import com.example.CaptoleConsulting.Entities.Price;
import com.example.CaptoleConsulting.Entities.Product;
import com.example.CaptoleConsulting.Services.BrandService;
import com.example.CaptoleConsulting.Services.PriceService;
import com.example.CaptoleConsulting.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PriceController {

    @Autowired
    BrandService brandService;

    @Autowired
    ProductService productService;

    @Autowired
    PriceService priceService;

    @GetMapping(value = "/getBrands")
    public Brand getBrands(){
        return brandService.list().get(0);
    }

    @GetMapping(value = "/getProducts")
    public Product getProducts(){
        return productService.list().get(0);
    }

    @GetMapping(value = "/getPrices")
    public List<Price> getPrices(){
        return priceService.list();
    }
}

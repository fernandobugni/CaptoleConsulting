package com.example.CaptoleConsulting.Controllers;

import com.example.CaptoleConsulting.Entities.Brands;
import com.example.CaptoleConsulting.Services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {

    @Autowired
    BrandService brandService;

    @GetMapping(value = "/getBrands")
    public Brands getBrands(){
        return brandService.list().get(0);
    }
}

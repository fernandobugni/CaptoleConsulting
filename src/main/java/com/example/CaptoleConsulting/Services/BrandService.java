package com.example.CaptoleConsulting.Services;

import com.example.CaptoleConsulting.Entities.Brands;
import com.example.CaptoleConsulting.Repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<Brands> list(){
        return brandRepository.findAll();
    }
}

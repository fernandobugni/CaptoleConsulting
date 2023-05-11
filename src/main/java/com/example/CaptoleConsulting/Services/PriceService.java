package com.example.CaptoleConsulting.Services;

import com.example.CaptoleConsulting.Entities.Price;
import com.example.CaptoleConsulting.Entities.Product;
import com.example.CaptoleConsulting.Repositories.PriceRepository;
import com.example.CaptoleConsulting.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public List<Price> list(){
        return priceRepository.findAll();
    }
}

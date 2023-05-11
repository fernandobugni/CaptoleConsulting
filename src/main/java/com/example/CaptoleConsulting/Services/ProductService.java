package com.example.CaptoleConsulting.Services;

import com.example.CaptoleConsulting.Entities.Product;
import com.example.CaptoleConsulting.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository ProductRepository;

    public List<Product> list(){
        return ProductRepository.findAll();
    }
}

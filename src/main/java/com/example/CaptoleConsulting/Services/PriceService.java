package com.example.CaptoleConsulting.Services;

import com.example.CaptoleConsulting.Entities.Brand;
import com.example.CaptoleConsulting.Entities.Price;
import com.example.CaptoleConsulting.Entities.Product;
import com.example.CaptoleConsulting.Repositories.BrandRepository;
import com.example.CaptoleConsulting.Repositories.PriceRepository;
import com.example.CaptoleConsulting.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductRepository productRepository;

    public Optional<Price> getPriceAtThisMoment(Integer brand_id, Integer product_id, LocalDateTime datetime){

        Brand brand = brandRepository.findById(brand_id).get();
        Product product = productRepository.findById(product_id).get();

        Optional<Price> price = priceRepository.findByBrandAndProduct(brand, product)
                .stream()
                .filter(p -> p.getStart_date().isBefore(datetime) && p.getEnd_date().isAfter(datetime))
                .max(Comparator.comparing(Price::getPriority));

        return price;
    }
}

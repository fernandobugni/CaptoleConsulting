package com.example.CaptoleConsulting.Repositories;

import com.example.CaptoleConsulting.Entities.Brand;
import com.example.CaptoleConsulting.Entities.Price;
import com.example.CaptoleConsulting.Entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends CrudRepository<Price, Integer> {

    List<Price> findByBrandAndProduct(Brand brand, Product product);
}


package com.example.CaptoleConsulting.Repositories;


import com.example.CaptoleConsulting.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}

package com.example.CaptoleConsulting.Repositories;

import com.example.CaptoleConsulting.Entities.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brands, Integer> {
}

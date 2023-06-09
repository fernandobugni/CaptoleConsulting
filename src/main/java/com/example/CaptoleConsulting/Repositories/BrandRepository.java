package com.example.CaptoleConsulting.Repositories;

import com.example.CaptoleConsulting.Entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
}

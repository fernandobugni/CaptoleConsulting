package com.example.CaptoleConsulting.Repositories;

import com.example.CaptoleConsulting.Entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {
}


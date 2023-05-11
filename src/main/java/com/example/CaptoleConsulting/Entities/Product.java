package com.example.CaptoleConsulting.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Products")
@Getter @Setter @NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;

    @Column(nullable = false)
    private String product_name;
}

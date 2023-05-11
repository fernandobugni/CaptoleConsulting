package com.example.CaptoleConsulting.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "Prices")
@Getter @Setter @NoArgsConstructor
public class Price {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    private Brand brand;

    @Column(nullable = false)
    private LocalDateTime start_date;

    @Column(nullable = false)
    private LocalDateTime end_date;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer price_list;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @Column(nullable = false)
    private Integer priority;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String curr;
}

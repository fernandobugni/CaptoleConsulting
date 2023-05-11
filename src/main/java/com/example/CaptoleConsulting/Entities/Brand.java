package com.example.CaptoleConsulting.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Brands")
@Getter @Setter @NoArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brand_id;

    @Column(nullable = false)
    private String brand_name;

}

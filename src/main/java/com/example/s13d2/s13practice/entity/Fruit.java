package com.example.s13d2.s13practice.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "fruit", schema = "fsweb")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    @Size(min=2,max=45,message = ("Name size must be between 2 and 45"))
    private String name;

    @Column(name="price")
    @DecimalMin("10")
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name="fruit_type")
    @NotNull
    private FruitType fruitType;
}

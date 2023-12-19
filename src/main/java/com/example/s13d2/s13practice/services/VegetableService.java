package com.example.s13d2.s13practice.services;


import com.example.s13d2.s13practice.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    List<Vegetable> getVegtByPriceDesc();

    List<Vegetable> getFruitByPriceAsc();

    Vegetable getById(Long id);

    Vegetable save(Vegetable vegetable);

    Vegetable delete(Long id);

    List<Vegetable> searchByName(String name);
}

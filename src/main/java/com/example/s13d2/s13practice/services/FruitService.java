package com.example.s13d2.s13practice.services;

import com.example.s13d2.s13practice.entity.Fruit;

import java.util.List;

public interface FruitService {
    List<Fruit> getFruitByPriceDesc();
    List<Fruit> getFruitByPriceAsc();
    Fruit getById(Long id);
    Fruit save(Fruit fruit);
    Fruit delete(Long id);
    List<Fruit> searchByName(String name);
}

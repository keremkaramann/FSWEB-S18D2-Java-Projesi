package com.example.s13d2.s13practice.controller;

import com.example.s13d2.s13practice.entity.Fruit;
import com.example.s13d2.s13practice.services.FruitService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class FruitController {

    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/")
    public List<Fruit> get() {
        return fruitService.getFruitByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Fruit> getByDesc() {
        return fruitService.getFruitByPriceDesc();
    }

    @PostMapping("")
    public Fruit save(@Validated @RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    @PostMapping("/{name}")
    public List<Fruit> searchByName(@Size(min = 2, max = 45) @PathVariable String name) {
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@Positive @PathVariable Long id) {
        return fruitService.delete(id);
    }


}

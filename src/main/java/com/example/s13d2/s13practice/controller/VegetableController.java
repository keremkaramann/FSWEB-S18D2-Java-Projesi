package com.example.s13d2.s13practice.controller;


import com.example.s13d2.s13practice.dto.VegetableResponse;
import com.example.s13d2.s13practice.entity.Vegetable;
import com.example.s13d2.s13practice.services.VegetableService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/fruit")
public class VegetableController {

    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping("/")
    public List<Vegetable> get() {
        return vegetableService.getFruitByPriceAsc();
    }

    @GetMapping("/{id}")
    public VegetableResponse get(@Positive @PathVariable Long id) {
        return new VegetableResponse("Success", vegetableService.getById(id));
    }

    @GetMapping("/asc")
    public List<Vegetable> getByPriceAsc() {
        return vegetableService.getFruitByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Vegetable> getByPriceDesc() {
        return vegetableService.getVegtByPriceDesc();
    }

    @PostMapping("/")
    public Vegetable save(Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @PostMapping("/name")
    public List<Vegetable> searchByName(@Size(min=2,max=45) @PathVariable String name){
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@Positive @PathVariable Long id){
        return vegetableService.delete(id);
    }

}

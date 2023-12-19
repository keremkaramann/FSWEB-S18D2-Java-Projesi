package com.example.s13d2.s13practice.services;

import com.example.s13d2.s13practice.dao.VegetableRepository;
import com.example.s13d2.s13practice.entity.Vegetable;
import com.example.s13d2.s13practice.exceptions.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public class VegetableServiceImpl implements VegetableService {

    private VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> getVegtByPriceDesc() {
        return vegetableRepository.getVegByPriceDesc();
    }

    @Override
    public List<Vegetable> getFruitByPriceAsc() {
        return vegetableRepository.getVegByPriceAsc();
    }

    @Override
    public Vegetable getById(Long id) {
        Optional<Vegetable> vegOptional = vegetableRepository.findById(id);
        if (vegOptional.isPresent()) {
            return vegOptional.get();
        }
        //TODO THROW NEW ERROR
        throw  new GeneralException("Given id is not exist:" + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable delete(Long id) {
        Vegetable veg = getById(id);
        vegetableRepository.delete(veg);
        return veg;
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.getVegByName(name);
    }
}

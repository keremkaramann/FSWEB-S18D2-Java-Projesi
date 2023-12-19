package com.example.s13d2.s13practice.services;

import com.example.s13d2.s13practice.dao.FruitRepository;
import com.example.s13d2.s13practice.entity.Fruit;
import com.example.s13d2.s13practice.exceptions.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {

    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<Fruit> getFruitByPriceDesc() {
        return fruitRepository.getFruitByPriceDesc();
    }

    @Override
    public List<Fruit> getFruitByPriceAsc() {
        return fruitRepository.getFruitByPriceAsc();
    }

    @Override
    public Fruit getById(Long id) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        if (fruitOptional.isPresent()) {
            return fruitOptional.get();
        }
        //TODO THROW NEW ERROR
       throw new GeneralException("Given id is no exist: " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(Long id) {
        Fruit fruit = getById(id);
        fruitRepository.delete(fruit);
        return fruit;
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.getFruitByName(name);
    }
}

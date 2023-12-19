package com.example.s13d2.s13practice.dao;

import com.example.s13d2.s13practice.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    @Query(value = "SELECT f.id,f.name,f.price,f.fruit_type FROM fsweb.fruit AS f " +
            "ORDER BY f.price DESC", nativeQuery = true)
    List<Fruit> getFruitByPriceDesc();

    @Query(value = "SELECT f.id,f.name,f.price FROM fsweb.fruit AS f " +
            "ORDER BY f.price ASC", nativeQuery = true)
    List<Fruit> getFruitByPriceAsc();

    @Query(value = "SELECT f FROM Fruit f where f.name ILIKE %:name%")
    List<Fruit> getFruitByName(String name);
}

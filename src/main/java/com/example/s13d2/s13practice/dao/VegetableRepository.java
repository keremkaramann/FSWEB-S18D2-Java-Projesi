package com.example.s13d2.s13practice.dao;


import com.example.s13d2.s13practice.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

    @Query(value = "SELECT v.id,v.name,v.price,v.is_grown_on_tree FROM fsweb.vegetable AS v" +
            "ORDER BY v.price DESC", nativeQuery = true)
    List<Vegetable> getVegByPriceAsc();

    @Query(value = "SELECT v.id,v.name,v.price FROM fsweb.vegetable AS v" +
            "ORDER BY v.price ASC", nativeQuery = true)
    List<Vegetable> getVegByPriceDesc();

    @Query(value = "SELECT v FROM Vegetable v WHERE v.name ILIKE %:name%")
    List<Vegetable> getVegByName(String name);
}

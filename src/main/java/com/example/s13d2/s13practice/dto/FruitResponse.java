package com.example.s13d2.s13practice.dto;

import com.example.s13d2.s13practice.entity.Fruit;

public record FruitResponse(String message, Fruit fruit) {
}

package com.riwi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "product")
    @Data /*Anotacion para generar getter y setter */
    @AllArgsConstructor/*Anotacion para crear constructor lleno */
    @NoArgsConstructor/*Anotacion para crear constructor vacio */

    public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private int quantity;
        private double price;
    }


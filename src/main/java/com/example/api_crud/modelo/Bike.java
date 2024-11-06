package com.example.api_crud.modelo;

import jakarta.persistence.*;

@Entity
@Table (name = "bikes")
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String brand;

    public Bike(int id, String model, String brand) {
        this.id = id;
        this.model = model;
        this.brand = brand;
    }

    // Constructor vacío
    public Bike() {}

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

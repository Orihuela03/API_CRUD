package com.example.api_crud.service;

import com.example.api_crud.modelo.Bike;
import com.example.api_crud.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> listarBikes() {
        return bikeRepository.findAll();
    }

    public Optional<Bike> obtenerBike(int id) {
        return bikeRepository.findById(id);
    }

    public Bike guardarBike(Bike bike) {
        return bikeRepository.save(bike);
    }

    public void eliminarBike(int id) {
        bikeRepository.deleteById(id);
    }

    public Bike actualizarBike(int id, Bike bike) {
        if (bikeRepository.findById(id).isPresent()) {
            Bike bikeActualizada = bikeRepository.getById(id);
            bikeActualizada.setBrand(bike.getBrand());
            bikeActualizada.setModel(bike.getModel());
            return bikeRepository.save(bikeActualizada);
        }
        else {
            return null;
        }
    }

}
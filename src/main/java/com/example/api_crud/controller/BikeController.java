package com.example.api_crud.controller;

import com.example.api_crud.modelo.Bike;
import com.example.api_crud.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bikes")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    // Endpoint para listar todas las bicicletas
    @GetMapping
    public List<Bike> listarBikes() {
        return bikeService.listarBikes();
    }

    // Endpoint para obtener una bicicleta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Bike> obtenerBike(@PathVariable int id) {
        Optional<Bike> bike = bikeService.obtenerBike(id);
        return bike.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear una nueva bicicleta
    @PostMapping
    public Bike guardarBike(@RequestBody Bike bike) {
        return bikeService.guardarBike(bike);
    }

    // Endpoint para actualizar una bicicleta
    @PutMapping("/{id}")
    public Bike actualizarBike(@PathVariable int id, @RequestBody Bike bikeActualizada) {
        bikeActualizada.setId(id);
        return bikeService.guardarBike(bikeActualizada);
    }

    // Endpoint para eliminar una bicicleta
    @DeleteMapping("/{id}")
    public void eliminarBike(@PathVariable int id) {
        bikeService.eliminarBike(id);
    }

}
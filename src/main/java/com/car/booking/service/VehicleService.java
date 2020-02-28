package com.car.booking.service;

import com.car.booking.entity.Vehicle;
import com.car.booking.repository.VehicleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(final VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        Assert.notNull(vehicle, "Vehicle must not be null");
        return vehicleRepository.saveAndFlush(vehicle);
    }

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> findById(Long id) {
        Assert.notNull(id, "Id must not be null");
        return vehicleRepository.findById(id);
    }

    public Optional<Vehicle> findByLicensePlate(String licensePlate) {
        Assert.hasLength(licensePlate, "License plate must not be empty");
        return vehicleRepository.findByLicensePlate(licensePlate);
    }
}

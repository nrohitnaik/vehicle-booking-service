package com.car.booking.controller;


import com.car.booking.domain.VehicleRequest;
import com.car.booking.entity.Vehicle;
import com.car.booking.mapper.VehicleMapper;
import com.car.booking.service.VehicleService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vehicles")
@Slf4j
@RequiredArgsConstructor
public class VehicleController {

  private final VehicleService vehicleService;
  private final VehicleMapper vehicleMapper;

  @GetMapping
  public List<Vehicle> getVehicles() {
    log.debug("Getting all vehicles");
    return vehicleService.findAll();
  }

  @PostMapping
  public ResponseEntity saveVehicle(@Valid @RequestBody VehicleRequest vehicleDto) {
    log.debug("Saving vehicle with license plate {}", vehicleDto.getLicensePlate());
    Vehicle savedVehicle = vehicleService.saveVehicle(
        vehicleMapper.vehicleDtoToVehicle(vehicleDto));
    return ResponseEntity.ok(vehicleMapper.vehicleToVehicleDto(savedVehicle));
  }
}

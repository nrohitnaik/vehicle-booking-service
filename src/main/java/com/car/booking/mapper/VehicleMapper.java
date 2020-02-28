package com.car.booking.mapper;

import com.car.booking.domain.VehicleRequest;
import com.car.booking.entity.Vehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

  Vehicle vehicleDtoToVehicle(VehicleRequest vehicleDto);

  VehicleRequest vehicleToVehicleDto(Vehicle vehicle);
}

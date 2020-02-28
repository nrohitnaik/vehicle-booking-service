package com.car.booking.controller.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {

  private Long id;
  private String licensePlate;
  private String vin;
  private String model;
  private Boolean active;
  private String color;
  private LocalDate validTill;
}

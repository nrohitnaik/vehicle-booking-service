package com.car.booking.domain;

import java.time.LocalDate;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRequest {

  private long id;

  @NotEmpty
  private String licensePlate;

  @NotEmpty
  private String vin;

  @NotEmpty
  private String model;

  @NotNull
  private Boolean active;

  @NotEmpty
  private String color;

  @Future
  @NotNull
  private LocalDate validTill;
}

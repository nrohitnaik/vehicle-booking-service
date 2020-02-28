package com.car.booking.domain;


import java.time.LocalDate;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {

  @FutureOrPresent
  private LocalDate startDate;
  @Future
  private LocalDate endDate;
  @NotEmpty
  private long userId;
  @NotEmpty
  private long vehicleId;
}

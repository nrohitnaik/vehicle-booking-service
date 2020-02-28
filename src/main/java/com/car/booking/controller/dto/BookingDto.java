package com.car.booking.controller.dto;

import com.car.booking.entity.BookingStatus;
import com.car.booking.entity.User;
import com.car.booking.entity.Vehicle;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {

  private long id;
  private BookingStatus bookingStatus;
  private LocalDate startDate;
  private LocalDate endDate;
  private User user;
  private Vehicle vehicle;
}

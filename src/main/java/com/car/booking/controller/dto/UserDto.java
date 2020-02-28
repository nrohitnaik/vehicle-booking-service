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
public class UserDto {

  private  long id;
  private String firstName;
  private String lastName;
  private String email;
  private LocalDate birthday;
}

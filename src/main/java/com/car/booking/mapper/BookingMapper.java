package com.car.booking.mapper;

import com.car.booking.controller.dto.BookingDto;
import com.car.booking.domain.BookingRequest;
import com.car.booking.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {

  @Mapping(target = "user.id", source = "bookingRequest.userId")
  @Mapping(target = "vehicle.id", source = "bookingRequest.vehicleId")
  @Mapping(target = "bookingStatus", ignore = true)
  Booking bookingRequestToBooking(BookingRequest bookingRequest);

  BookingDto bookingToBookingDto(Booking booking);
}

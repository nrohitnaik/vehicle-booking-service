package com.car.booking.controller;

import com.car.booking.domain.BookingRequest;
import com.car.booking.entity.BookingStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.car.booking.service.BookingService;

@RestController
@RequestMapping("/api/v1/bookings")
@Slf4j
@RequiredArgsConstructor
public class BookingController {

  private final BookingService bookingService;

  @GetMapping("/{id}")
  public ResponseEntity getBookingById(@PathVariable("id") long id) {
    log.debug("fetching booking details for id {}", id);
    return ResponseEntity.ok(bookingService.getBookingById(id));
  }

  @GetMapping
  public ResponseEntity getAllBookings() {
    log.debug("fetching all bookings");
    return ResponseEntity.ok(bookingService.getAllBookings());
  }

  @PostMapping
  public ResponseEntity saveBooking(@RequestBody BookingRequest bookingRequest) {
    log.debug("saving booking details {}", bookingRequest);
    return ResponseEntity.ok(bookingService.saveBooking(bookingRequest));
  }

  @PutMapping("/{id}")
  public ResponseEntity updateBooking(@PathVariable("id") long id,
      @RequestParam BookingStatus bookingStatus) {
    log.debug("updating booking status with booking id {} with status {}", id, bookingStatus);
    return ResponseEntity.ok(bookingService.updateBookingStatus(id, bookingStatus));
  }
}

package com.car.booking.service;

import com.car.booking.controller.dto.BookingDto;
import com.car.booking.domain.BookingRequest;
import com.car.booking.entity.Booking;
import com.car.booking.entity.BookingStatus;
import com.car.booking.exception.DataAlreadyExistException;
import com.car.booking.exception.UnprocessedException;
import com.car.booking.mapper.BookingMapper;
import com.car.booking.repository.BookingRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class BookingService {

  private final BookingRepository bookingRepository;
  private final BookingMapper bookingMapper;

  public BookingDto getBookingById(Long id) {
    Assert.notNull(id, "Booking id not be null");
    Optional<Booking> booking = bookingRepository.findById(id);
    if (booking.isPresent()) {
      return bookingMapper.bookingToBookingDto(booking.get());
    }
    throw new NoSuchElementException("No bookings available with id " + id);
  }

  public List<Booking> getAllBookings() {
    return bookingRepository.findAll();
  }

  public int updateBookingStatus(long bookingId, BookingStatus bookingStatus) {
    int databaseUpdate = bookingRepository.updateBookingStatus(bookingId, bookingStatus);
    if (databaseUpdate != 1) {
      throw new UnprocessedException(
          "Error occurred  while changing the state of the booking with booking id "
              + bookingId);
    }
    return databaseUpdate;
  }

  public BookingDto saveBooking(BookingRequest bookingRequest) {
    Assert.notNull(bookingRequest, "Booking must not be null");
    if (bookingRequest.getStartDate() == null) {
      bookingRequest.setStartDate(LocalDate.now());
    }
    if (bookingRequest.getEndDate() == null) {
      bookingRequest.setEndDate(LocalDate.now()
                                         .plusDays(1));
    }
    Booking booking = bookingMapper.bookingRequestToBooking(bookingRequest);
    if (checkIfBookingExists(booking)) {
      throw new DataAlreadyExistException(
          "Booking already Exists for vehicle " + booking.getVehicle()
                                                         .getId());
    }
    booking.setBookingStatus(BookingStatus.OPEN);
    return bookingMapper.bookingToBookingDto(bookingRepository.saveAndFlush(booking));
  }

  private boolean checkIfBookingExists(Booking booking) {
    return bookingRepository.findByVehicleAndBookingStatus(booking.getVehicle(),
        BookingStatus.ACTIVE)
                            .isPresent();
  }
}

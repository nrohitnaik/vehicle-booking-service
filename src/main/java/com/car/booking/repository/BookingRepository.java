package com.car.booking.repository;

import com.car.booking.entity.Booking;
import com.car.booking.entity.BookingStatus;
import com.car.booking.entity.Vehicle;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * For Spring Data JPA query methods see:
 * http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {

  @Modifying
  @Query("update Booking booking set booking.bookingStatus = :status where booking.id = :bookingId")
  @Transactional
  int updateBookingStatus(@Param("bookingId") long bookingId, @Param("status") BookingStatus status);

  Optional<Booking> findByVehicleAndBookingStatus(Vehicle vehicle, BookingStatus bookingStatus);
}

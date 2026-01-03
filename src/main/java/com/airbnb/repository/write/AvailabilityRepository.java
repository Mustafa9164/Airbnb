package com.airbnb.repository.write;

import com.airbnb.entity.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

    List<Availability> findByBookingId(Long bookingId);
    List<Availability> findByAirbnbId(Long airbnbId);
}
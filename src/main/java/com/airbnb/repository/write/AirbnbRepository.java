package com.airbnb.repository.write;

import com.airbnb.entity.Airbnb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirbnbRepository extends JpaRepository<Airbnb, Long> {
}
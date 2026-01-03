package com.airbnb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "availability")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "airbnb_id", nullable = false)
    private Long airbnbId;


    @Column(name = "date", nullable = false)
    private Date date;

    @Column
    private Long bookingId;//nullable if false


}

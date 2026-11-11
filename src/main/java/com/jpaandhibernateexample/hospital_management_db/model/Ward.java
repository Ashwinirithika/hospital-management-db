package com.jpaandhibernateexample.hospital_management_db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// Represents this class as a JPA entity
@Table(name = "ward_details")
// Creates a database table named ward_details
@Data
// Generates getters, setters, equals, hashCode and toString
@AllArgsConstructor
// Parameterized constructor
@NoArgsConstructor
// Default constructor
public class Ward  {


        @Id
        @Column(name = "id")
        private int id;

        @Column(name = "ward_name", nullable = false)
        private String wardName;

        @Column(name = "ward_type", nullable = false)
        private String wardType;

        @Column(name = "total_beds", nullable = false)
        private int totalBeds;

        @Column(name = "available_beds", nullable = false)
        private int availableBeds;

        @Column(name = "floor_number", nullable = false)
        private int floorNumber;

        @Column(name = "nurse_in_charge", nullable = false)
        private String nurseInCharge;

        @Column(name = "contact_number", nullable = false, unique = true)
        private String contactNumber;
    }



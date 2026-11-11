package com.jpaandhibernateexample.hospital_management_db.repository;

import com.jpaandhibernateexample.hospital_management_db.model.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WardRepository extends JpaRepository<Ward, Integer> {
}

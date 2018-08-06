package com.pramod.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pramod.ems.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>, EMSRepository<Doctor> {
}

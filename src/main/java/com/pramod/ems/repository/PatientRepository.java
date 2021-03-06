package com.pramod.ems.repository;

import com.pramod.ems.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long>, EMSRepository<Patient>{
}

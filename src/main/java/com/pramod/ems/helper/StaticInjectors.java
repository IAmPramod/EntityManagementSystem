package com.pramod.ems.helper;


import com.pramod.ems.builder.DoctorBuilder;
import com.pramod.ems.builder.PatientBuilder;
import com.pramod.ems.repository.DoctorRepository;
import com.pramod.ems.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class StaticInjectors {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @PostConstruct
    public void autowire() {
        PatientBuilder.setPatientRepository(patientRepository);
        DoctorBuilder.setDoctorRepository(doctorRepository);
    }
}

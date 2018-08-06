package com.pramod.ems.builder;

import com.pramod.ems.model.Doctor;
import com.pramod.ems.model.EMSEntity;
import com.pramod.ems.repository.DoctorRepository;
import com.pramod.ems.repository.EMSRepository;

public class DoctorBuilder implements EMSBuilder {

    private static DoctorRepository doctorRepository;
    private Doctor doctor = new Doctor();

    @Override
    public EMSEntity saveEntity(EMSEntity emsEntity) {
        Doctor existingDoctor = (Doctor)emsEntity;
        DoctorBuilder doctorBuilder = new DoctorBuilder().firstName(existingDoctor.getFirstName()).lastName(existingDoctor.getLastName()).uuid(existingDoctor.getUuid());
        return doctorRepository.save(doctorBuilder.doctor);
    }

    public DoctorBuilder firstName(String firstName){
        doctor.setFirstName(firstName);
        return this;
    }

    public DoctorBuilder lastName(String lastName){
        doctor.setLastName(lastName);
        return this;
    }

    public DoctorBuilder uuid(String uuid){
        doctor.setUuid(uuid);
        return this;
    }

    @Override
    public EMSRepository<?> getRepository(){
        return doctorRepository;
    }

    public static void setDoctorRepository(DoctorRepository doctorRepository) {
        DoctorBuilder.doctorRepository = doctorRepository;
    }
}

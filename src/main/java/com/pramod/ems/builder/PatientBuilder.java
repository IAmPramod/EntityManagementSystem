package com.pramod.ems.builder;

import com.pramod.ems.model.EMSEntity;
import com.pramod.ems.model.Patient;
import com.pramod.ems.repository.EMSRepository;
import com.pramod.ems.repository.PatientRepository;

public class PatientBuilder implements EMSBuilder {

    private static PatientRepository patientRepository;
    private Patient patient = new Patient();

    @Override
    public EMSEntity saveEntity(EMSEntity emsEntity) {
        Patient existingPatient = (Patient)emsEntity;
        PatientBuilder patientBuilder = new PatientBuilder().firstName(existingPatient.getFirstName()).lastName(existingPatient.getLastName()).uuid(existingPatient.getUuid()).doctorUuid(existingPatient.getDoctorUuid());
        return patientRepository.save(patientBuilder.patient);
    }

    public PatientBuilder firstName(String firstName){
        patient.setFirstName(firstName);
        return this;
    }

    public PatientBuilder lastName(String lastName){
        patient.setLastName(lastName);
        return this;
    }

    public PatientBuilder uuid(String uuid){
        patient.setUuid(uuid);
        return this;
    }

    public PatientBuilder doctorUuid(String doctorUuid){
        patient.setDoctorUuid(doctorUuid);
        return this;
    }

    @Override
    public EMSRepository<?> getRepository() {
        return patientRepository;
    }

    public static void setPatientRepository(PatientRepository patientRepository) {
        PatientBuilder.patientRepository = patientRepository;
    }
}

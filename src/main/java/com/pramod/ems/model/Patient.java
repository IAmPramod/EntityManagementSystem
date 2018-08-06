package com.pramod.ems.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name="PATIENT")
public class Patient implements EMSEntity {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="UUID")
    private String uuid;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="DOCTOR_UUID")
    private String doctorUuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDoctorUuid() {
        return doctorUuid;
    }

    public void setDoctorUuid(String doctorUuid) {
        this.doctorUuid = doctorUuid;
    }

    @JsonIgnore
    @ManyToOne(targetEntity = Doctor.class)
    @JoinColumn(name="DOCTOR_UUID", referencedColumnName = "UUID", insertable = false, updatable = false)
    private Doctor consultingDoctor;

    @PrePersist
    public void prePersist() {
        if (uuid == null) {
            uuid = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
        }
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", doctorUuid='" + doctorUuid + '\'' +
                '}';
    }
}

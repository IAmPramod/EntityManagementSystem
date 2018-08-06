package com.pramod.ems.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=Patient.class, name = "Patient"),
        @JsonSubTypes.Type(value=Doctor.class, name = "Doctor")
})
public interface EMSEntity extends Serializable {
}

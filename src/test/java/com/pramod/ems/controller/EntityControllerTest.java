package com.pramod.ems.controller;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.web.servlet.*;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.pramod.ems.model.Doctor;
import com.pramod.ems.model.EMSEntity;
import com.pramod.ems.model.Patient;
import com.pramod.ems.service.EntityService;

@RunWith(SpringRunner.class)
@WebMvcTest(EntityController.class)
public class EntityControllerTest {
	
	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private EntityService entityService;
	
	@Before
	public void mockEntities(){
		Doctor doctor = new Doctor();
		doctor.setFirstName("doctor_first_name");
		doctor.setLastName("doctor_last_name");
		doctor.setUuid("doctor_uuid");
		
		Mockito.doReturn((EMSEntity) doctor).when(entityService).getEntity("Doctor","doctor_uuid");
		
		Patient patient = new Patient();
		patient.setFirstName("patient_first_name");
		patient.setLastName("patient_last_name");
		patient.setUuid("patient_uuid");
		patient.setDoctorUuid(doctor.getUuid());
		
		Mockito.doReturn((EMSEntity) patient).when(entityService).getEntity("Patient","patient_uuid");
	}
	
	@Test
	public void getEntityTest_WithValidDoctor() throws Exception{
		mockmvc.perform(get("/entity/Doctor/doctor_uuid")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$.type", is("Doctor")))
				  .andExpect(jsonPath("$.firstName", is("doctor_first_name")))
				  .andExpect(jsonPath("$.lastName", is("doctor_last_name")))
				  .andExpect(jsonPath("$.uuid", is("doctor_uuid")));
	}
	
	@Test
	public void getEntityTest_WithValidPatient() throws Exception{
		mockmvc.perform(get("/entity/Patient/patient_uuid")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$.type", is("Patient")))
				  .andExpect(jsonPath("$.firstName", is("patient_first_name")))
				  .andExpect(jsonPath("$.lastName", is("patient_last_name")))
				  .andExpect(jsonPath("$.uuid", is("patient_uuid")));
	}
}

package com.takue.lab.common.handler;

import com.takue.lab.common.event.NewPatientRegisteredEvent;
import com.takue.lab.query.entity.Patient;
import com.takue.lab.query.repository.PatientRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class PatientEventHandler {

    private  final PatientRepository patientRepository;

    public PatientEventHandler(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @EventHandler
    public void onNewPatientRegistered(NewPatientRegisteredEvent event){
        Patient patient = new Patient();
        patient.setPatientId(event.getPatientId());
        patient.setPatientName(event.getPatientName());
        patient.setBirthDate(event.getBirthDate());
        patient.setGender(event.getGender().toString());
        patient.setFacilityId(event.getFacilityId());

        patientRepository.save(patient);


    }
}

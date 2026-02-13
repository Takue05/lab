package com.takue.lab.common.event;

import com.takue.lab.enums.Gender;
import lombok.Value;

import java.time.LocalDate;

@Value
public class NewPatientRegisteredEvent {
    String patientId;
    String  patientName;
    Gender gender;
    LocalDate birthDate;
    String facilityId;
}

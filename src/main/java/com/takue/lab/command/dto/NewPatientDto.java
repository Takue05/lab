package com.takue.lab.command.dto;

import com.takue.lab.enums.Gender;
import lombok.Value;

import java.time.LocalDate;

@Value
public class NewPatientDto {
    String  patientName;
    String gender;
    LocalDate birthDate;
    String facilityId;
}

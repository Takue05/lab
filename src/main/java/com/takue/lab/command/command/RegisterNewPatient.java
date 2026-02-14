package com.takue.lab.command.command;

import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class RegisterNewPatient {
    String patientId;
    String  patientName;
    String gender;
    LocalDate birthDate;
    String facilityId;
}

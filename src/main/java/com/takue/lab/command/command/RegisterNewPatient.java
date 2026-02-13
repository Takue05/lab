package com.takue.lab.command.command;

import com.takue.lab.enums.Gender;
import com.takue.lab.enums.Priority;
import com.takue.lab.enums.SampleStatus;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class RegisterNewPatient {
    String patientId;
    String  patientName;
    Gender gender;
    LocalDate birthDate;
    String facilityId;
}

package com.takue.lab.command.dto;

import com.takue.lab.enums.Gender;
import com.takue.lab.enums.Priority;
import com.takue.lab.enums.SampleStatus;
import lombok.Data;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class NewSampleDTO {
    String labRequestNumber;
    String patientId;
    LocalDate collectionDate;
    LocalDateTime receivedDateTime;
    String sampleType;
    String testCode;
    String sampleStatus;
    String rejectionReason;
    String priority;
}

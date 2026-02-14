package com.takue.lab.common.event;


import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class NewSampleRegisteredEvent {
    UUID sampleId;
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

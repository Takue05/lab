package com.takue.lab.command.command;

import com.takue.lab.enums.Gender;
import com.takue.lab.enums.Priority;
import com.takue.lab.enums.SampleStatus;
import lombok.Value;
import org.aspectj.weaver.ast.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class RegisterNewSample {
    UUID sampleId;
    String labRequestNumber;
    String patientId;
    LocalDate collectionDate;
    LocalDateTime receivedDateTime;
    String sampleType;
    String testCode;
    SampleStatus sampleStatus;
    String rejectionReason;
    Priority priority;
}

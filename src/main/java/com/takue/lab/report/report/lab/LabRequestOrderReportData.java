package com.takue.lab.report.report.lab;

import com.takue.lab.enums.Gender;
import com.takue.lab.enums.SampleStatus;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
public class LabRequestOrderReportData {

    String patientName;
    String laboratoryRequestOrder;
    Gender gender;
    LocalDate birthDate;
    String facilityId;
    LocalDate collectionDate;
    LocalDateTime receivedDateTime;
    String sampleType;
    String testCode;
    SampleStatus sampleStatus;

}

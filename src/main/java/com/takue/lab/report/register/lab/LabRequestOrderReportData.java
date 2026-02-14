package com.takue.lab.report.register.lab;

import com.takue.lab.enums.Gender;
import com.takue.lab.enums.SampleStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class LabRequestOrderReportData {

    String patientName;
    String laboratoryRequestOrder;
    String gender;
    LocalDate birthDate;
    String facilityId;
    LocalDate collectionDate;
    LocalDate receivedDateTime;
    String sampleType;
    String testCode;
    String sampleStatus;
    int total;

}

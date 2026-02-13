package com.takue.lab.query.entity;

import com.takue.lab.enums.Priority;
import com.takue.lab.enums.SampleStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(catalog = "consultation", schema="consultation" )
public class Sample {
    @Id
    private String sampleId;
    private String labRequestNumber;
    private String patientId;
    private LocalDate collectionDate;
    private LocalDate receivedDateTime;
    private  String sampleType;
    private  String testCode;

    @Enumerated(EnumType.STRING)
    private SampleStatus status;

    private String rejectionReason;

    @Enumerated(EnumType.STRING)
    private Priority priority;
}

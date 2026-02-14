package com.takue.lab.query.entity;

import com.takue.lab.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(catalog = "client", schema="client" )
public class Patient {
    @Id
    String patientId;
    String  patientName;
    String gender;
    String facilityId;
    LocalDate birthDate;

}

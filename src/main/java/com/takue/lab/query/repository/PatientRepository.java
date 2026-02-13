package com.takue.lab.query.repository;

import com.takue.lab.query.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository <Patient, String > {
}

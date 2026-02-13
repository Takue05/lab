package com.takue.lab.command.controller;


import com.takue.lab.command.dto.NewPatientDto;
import com.takue.lab.command.service.PatientCommandService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/patient")
public class PatientResource {
    private final PatientCommandService patientCommandService;

    public PatientResource(PatientCommandService patientCommandService) {
        this.patientCommandService = patientCommandService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String registerNewPatient(@RequestBody @Valid NewPatientDto dto){
        return patientCommandService.registerNewPatient(dto);
    }

}

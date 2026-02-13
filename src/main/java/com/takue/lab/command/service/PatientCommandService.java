package com.takue.lab.command.service;

import com.takue.lab.command.command.RegisterNewPatient;
import com.takue.lab.command.dto.NewPatientDto;
import com.takue.lab.enums.Gender;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class PatientCommandService {

    private final CommandGateway commandGateway;

    public PatientCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public String registerNewPatient(NewPatientDto dto) {
        return commandGateway.sendAndWait(new RegisterNewPatient(
                UUID.randomUUID().toString(),
                dto.getPatientName(),
                dto.getGender(),
                dto.getBirthDate(),
                dto.getFacilityId()
        ));
    }
}

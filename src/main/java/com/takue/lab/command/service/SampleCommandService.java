package com.takue.lab.command.service;

import com.takue.lab.command.command.RegisterNewSample;
import com.takue.lab.command.dto.NewSampleDTO;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.UUID;


@Service
public class SampleCommandService {
    private final CommandGateway commandGateway;

    public SampleCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public UUID registerNewSample(NewSampleDTO dto){
       return commandGateway.sendAndWait(new RegisterNewSample(
          UUID.randomUUID(),
               dto.getLabRequestNumber(),
               dto.getPatientId(),
               dto.getCollectionDate(),
               LocalDateTime.now(),
               dto.getSampleType(),
               dto.getTestCode(),
               dto.getSampleStatus(),
               dto.getRejectionReason(),
               dto.getPriority()

       ));
    }


}

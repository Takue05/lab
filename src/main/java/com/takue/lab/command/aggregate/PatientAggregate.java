package com.takue.lab.command.aggregate;

import com.takue.lab.command.command.RegisterNewPatient;
import com.takue.lab.common.event.NewPatientRegisteredEvent;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Slf4j
@Aggregate
@Getter
public class PatientAggregate {

    @AggregateIdentifier
    private String patientId;


    public PatientAggregate(){
    }

    @CommandHandler
    public PatientAggregate(RegisterNewPatient  command ){
        log.info("new patient registered {}", command.getPatientId());
        apply(new NewPatientRegisteredEvent(
                command.getPatientId(),
                command.getPatientName(),
                command.getGender(),
                command.getBirthDate(),
                command.getFacilityId()

        ));

    }

    @EventSourcingHandler
    public void on(NewPatientRegisteredEvent event){
        this.patientId = event.getPatientId();
    }
}

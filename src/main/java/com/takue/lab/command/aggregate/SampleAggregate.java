package com.takue.lab.command.aggregate;

import com.takue.lab.command.command.RegisterNewSample;
import com.takue.lab.common.event.NewSampleRegisteredEvent;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Slf4j
@Aggregate
@Getter
public class SampleAggregate {

    @AggregateIdentifier
    private UUID sampleId;


    public SampleAggregate(){
    }

    @CommandHandler
    public SampleAggregate(RegisterNewSample command) {
        log.info("RegisterNewSample command received for sampleId: {}", command.getSampleId().toString());

        apply(new NewSampleRegisteredEvent(
                command.getSampleId(),
        command.getLabRequestNumber(),
        command.getPatientId(),
        command.getCollectionDate(),
        command.getReceivedDateTime(),
        command.getSampleType(),
        command.getTestCode(),
        command.getSampleStatus(),
        command.getRejectionReason(),
        command.getPriority()
        ));

    }

    @EventSourcingHandler
    public void on(NewSampleRegisteredEvent event) {
        this.sampleId = event.getSampleId();

    }


}

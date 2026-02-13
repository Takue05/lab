package com.takue.lab.common.handler;
import com.takue.lab.common.event.NewSampleRegisteredEvent;
import com.takue.lab.query.entity.Sample;
import com.takue.lab.query.repository.SampleRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component

public class SampleEventHandler {

    private final SampleRepository sampleRepository;

    public SampleEventHandler(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @EventHandler
    public void onNewSampleRegistered(NewSampleRegisteredEvent event){
        Sample sample = new Sample();
        sample.setSampleId(event.getSampleId().toString());
        sample.setLabRequestNumber(event.getLabRequestNumber());
        sample.setPatientId(event.getPatientId());
        sample.setCollectionDate(event.getCollectionDate());
        sample.setSampleType(event.getSampleType());
        sample.setStatus(event.getSampleStatus());
        sample.setTestCode(event.getTestCode());
        sample.setRejectionReason(event.getRejectionReason());
        sample.setPriority(event.getPriority());
        sampleRepository.save(sample);

    }
}

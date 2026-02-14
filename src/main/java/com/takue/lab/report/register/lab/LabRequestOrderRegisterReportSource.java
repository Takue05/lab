package com.takue.lab.report.register.lab;

import com.takue.lab.query.entity.Patient;
import com.takue.lab.query.entity.Sample;
import com.takue.lab.query.repository.PatientRepository;
import com.takue.lab.query.repository.SampleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

import static com.takue.lab.report.report.helper.RegisterGenerator.generateReport;


@Component
@Slf4j
@AllArgsConstructor
public class LabRequestOrderRegisterReportSource {

    private PatientRepository patientRepository;

    private SampleRepository sampleRepository;


    public String toReport(String reportFormat, LocalDate from, LocalDate to) throws FileNotFoundException, JRException  {

        List<LabRequestOrderReportData> report = new ArrayList<>();
        List<Sample> samples = sampleRepository.findByCollectionDateBetween(from, to);
        System.out.println("=== DEBUG ===");
        System.out.println("Samples found: " + samples.size());
        System.out.println("From: " + from);
        System.out.println("To: " + to);


        if (samples.isEmpty()) {
            throw new RuntimeException("No samples found between " + from + " and " + to);
        }


        for (Sample sample : samples) {

            LabRequestOrderReportData data = new LabRequestOrderReportData();

            Patient patient = patientRepository.findByPatientId(sample.getPatientId());

            if (patient == null){
                log.info("No patient found for sample id :  {}", sample.getSampleId());
                continue;
            }

            data.setTotal(samples.size());
            data.setLaboratoryRequestOrder(sample.getLabRequestNumber());
            data.setPatientName(patient.getPatientName());
            data.setGender(patient.getGender());
            data.setBirthDate(patient.getBirthDate());
            data.setCollectionDate(sample.getCollectionDate());
            data.setReceivedDateTime(sample.getReceivedDateTime());
            data.setFacilityId(patient.getFacilityId());
            data.setSampleType(sample.getSampleType());
            data.setSampleStatus(sample.getStatus());
            data.setTestCode(sample.getTestCode());
            report.add(data);
        }

        return generateReport(reportFormat,report);
    }



}

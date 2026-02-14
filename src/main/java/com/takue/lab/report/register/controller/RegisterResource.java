package com.takue.lab.report.register.controller;

import com.takue.lab.report.register.lab.LabRequestOrderRegisterReportSource;
import jakarta.validation.Valid;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/register")
public class RegisterResource {


    private final LabRequestOrderRegisterReportSource labRequestOrderRegisterReportSource;

    public RegisterResource(LabRequestOrderRegisterReportSource labRequestOrderRegisterReportSource) {
        this.labRequestOrderRegisterReportSource = labRequestOrderRegisterReportSource;
    }

    @GetMapping("/laboratoryRequestRegister")
   public String generateRegister(@RequestParam String reportFormat,
                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) throws JRException, FileNotFoundException {
return labRequestOrderRegisterReportSource.toReport(reportFormat, from, to);
   }
}

package com.takue.lab.command.controller;


import com.takue.lab.command.dto.NewSampleDTO;
import com.takue.lab.command.service.SampleCommandService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/sample")
public class SampleResource {
    private final SampleCommandService sampleCommandService;

    public SampleResource(SampleCommandService sampleCommandService) {
        this.sampleCommandService = sampleCommandService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID registerNewSample(@RequestBody @Valid NewSampleDTO dto) {
        return sampleCommandService.registerNewSample(dto);

    }



}

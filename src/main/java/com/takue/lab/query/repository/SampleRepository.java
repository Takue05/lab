package com.takue.lab.query.repository;

import com.takue.lab.query.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SampleRepository extends JpaRepository <Sample,String>{

    List<Sample> findByCollectionDateBetween(LocalDate from, LocalDate to);
    Sample findTopByLabRequestNumber(String labRequestNumber);

}

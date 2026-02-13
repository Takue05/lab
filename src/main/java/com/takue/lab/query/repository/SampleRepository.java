package com.takue.lab.query.repository;

import com.takue.lab.query.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository <Sample,String>{
}

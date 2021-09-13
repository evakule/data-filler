package com.io.pipeline.modeling.fundamentals.repository;

import com.io.pipeline.modeling.fundamentals.model.SalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<SalaryEntity, Integer> {
}

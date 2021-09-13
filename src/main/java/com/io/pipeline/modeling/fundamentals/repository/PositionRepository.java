package com.io.pipeline.modeling.fundamentals.repository;

import com.io.pipeline.modeling.fundamentals.model.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<PositionEntity, Integer> {
}

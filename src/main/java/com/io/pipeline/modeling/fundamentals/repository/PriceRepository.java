package com.io.pipeline.modeling.fundamentals.repository;

import com.io.pipeline.modeling.fundamentals.model.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {
}

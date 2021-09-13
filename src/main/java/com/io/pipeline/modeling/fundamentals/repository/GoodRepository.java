package com.io.pipeline.modeling.fundamentals.repository;

import com.io.pipeline.modeling.fundamentals.model.GoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodRepository extends JpaRepository<GoodEntity, Integer> {
}

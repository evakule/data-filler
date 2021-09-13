package com.io.pipeline.modeling.fundamentals.repository;

import com.io.pipeline.modeling.fundamentals.model.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<StoreEntity, Integer> {
}

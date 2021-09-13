package com.io.pipeline.modeling.fundamentals.repository;

import com.io.pipeline.modeling.fundamentals.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}

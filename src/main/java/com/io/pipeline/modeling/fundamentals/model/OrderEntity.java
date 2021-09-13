package com.io.pipeline.modeling.fundamentals.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

  @Column(name = "order_type")
  private String orderType;

  @Column(name = "good_id")
  private Integer goodId;

  @Column(name = "price_id")
  private Integer priceId;

  @Column(name = "store_id")
  private Integer storeId;

  @Column(name = "supplier_id")
  private Integer supplierId;

  @Column(name = "employee_id")
  private Integer employeeId;
}

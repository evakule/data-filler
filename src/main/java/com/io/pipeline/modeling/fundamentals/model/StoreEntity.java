package com.io.pipeline.modeling.fundamentals.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "stores")
public class StoreEntity extends BaseEntity {

  @Column(name = "title")
  private String title;

  @Column(name = "square_meters")
  private BigDecimal squareMeters;

  @Column(name = "client_places_count")
  private Integer clientPlacesCount;

  @Column(name = "employees_count")
  private Integer employeesCount;
}

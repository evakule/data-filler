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
@Table(name = "goods")
public class GoodEntity extends BaseEntity {

  @Column(name = "title")
  private String title;

  @Column(name = "weight")
  private BigDecimal weight;

  @Column(name = "freshness")
  private String freshness;

  @Column(name = "is_food")
  private String isFood;

  @Column(name = "price_id")
  private Integer priceId;
}

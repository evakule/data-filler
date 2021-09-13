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
@Table(name = "suppliers")
public class SupplierEntity extends BaseEntity {

  @Column(name = "title")
  private String title;

  @Column(name = "address")
  private String address;

  @Column(name = "type")
  private String type;
}

package com.io.pipeline.modeling.fundamentals.random;

import com.io.pipeline.modeling.fundamentals.repository.SalaryRepository;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Randomizer {

  public BigDecimal generateSalary() {
    int salary = (int) Math.floor(Math.random() * (50 - 25 + 1) + 25) * 100;
    return new BigDecimal(0).add(BigDecimal.valueOf((salary)));
  }

  public BigDecimal generatePrice() {
    return new BigDecimal(0)
        .add(BigDecimal.valueOf(Math.random() * (100 - 5 + 1) + 5));
  }

  public BigDecimal generateSquareMeters() {
    return new BigDecimal(0)
        .add(BigDecimal.valueOf(Math.random() * (300 - 100 + 1) + 100));
  }

  public int generateEmployeesCount() {
    return (int) Math.floor(Math.random() * (8 - 2 + 1) + 2);
  }

  public String generateSupplierType() {
    return new Random().nextBoolean() ? "Large" : "Small";
  }

  public BigDecimal generateWeight() {
    return new BigDecimal(0)
        .add(BigDecimal.valueOf(Math.random() * (5 - 0.5 + 1) + 0.5));
  }

  public String generateFresh() {
    return new Random().nextBoolean() ? "fresh" : "dry";
  }

  public String generateIsGood() {
    return new Random().nextBoolean() ? "is-good" : "non-good";
  }

  public String getRandomFirstName() throws IOException {
    List<String> names = Files.readAllLines(
        new File("names.txt").toPath(), Charset.defaultCharset()
    );
    return names.get(new Random().nextInt(1000));
  }

  public String getRandomLastName() throws IOException {
    List<String> names = Files.readAllLines(
        new File("lastnames.txt").toPath(), Charset.defaultCharset()
    );
    String name = names.get(
        new Random().nextInt(1000)
    ).toLowerCase(Locale.ROOT);
    return name.substring(0, 1).toUpperCase(Locale.ROOT) + name.substring(1);
  }

  public Integer getRandomSalaryId(SalaryRepository salaryRepository) {
    return salaryRepository
        .getById(new Random().nextInt(50)).getId();
  }

  public String getOrderType() {
    return new Random().nextBoolean() ? "sale" : "delivery";
  }
}

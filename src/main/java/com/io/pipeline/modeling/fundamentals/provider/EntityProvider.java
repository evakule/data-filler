package com.io.pipeline.modeling.fundamentals.provider;

import com.io.pipeline.modeling.fundamentals.model.*;
import com.io.pipeline.modeling.fundamentals.repository.*;
import com.io.pipeline.modeling.fundamentals.random.Randomizer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Component
public class EntityProvider {

  private final Randomizer random = new Randomizer();

  public SalaryEntity getSalaryEntity() {
    return new SalaryEntity(
        random.generateSalary(), "USD"
    );
  }

  public List<PositionEntity> getPositionEntities() {
    List<PositionEntity> positions = new ArrayList<>();
    positions.add(new PositionEntity("Store-Manager"));
    positions.add(new PositionEntity("Cleaner"));
    positions.add(new PositionEntity("Mover"));
    positions.add(new PositionEntity("Sales-Manager"));
    return positions;
  }

  public PriceEntity getPriceEntity() {
    return new PriceEntity(
        random.generatePrice(), "UAH"
    );
  }

  public StoreEntity getStoreEntity(int counter) {
    int employeesCount = random.generateEmployeesCount();
    int clientPlacesCount = (int) Math.pow(employeesCount, 2);
    return new StoreEntity(
        "Store_" + counter,
        random.generateSquareMeters(),
        clientPlacesCount,
        employeesCount);
  }

  public SupplierEntity getSupplierEntity(int counter) {
    return new SupplierEntity(
        "Some_supplier_ " + counter,
        "supplier_address_" + counter,
        random.generateSupplierType()
    );
  }

  public GoodEntity getGoodEntity(int counter,
                                  PriceRepository priceRepository) {
    return new GoodEntity(
        "Some_good_" + counter,
        random.generateWeight(),
        random.generateFresh(),
        random.generateIsGood(),
        priceRepository.getById(
            new Random().nextInt(99) + 1
        ).getId()
    );
  }

  public EmployeeEntity getEmployeeEntity(int counter,
                                          int storeId,
                                          SalaryRepository salaryRepository) {
    EmployeeEntity employee = new EmployeeEntity();
    try {
      employee.setFirstName(random.getRandomFirstName());
      employee.setLastName(random.getRandomLastName());
      employee.setStoreId(storeId);
      employee.setPositionId(Math.min(counter, 4));
      employee.setFirstName(random.getRandomFirstName());
      employee.setSalaryId(random.getRandomSalaryId(salaryRepository));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return employee;
  }

  public OrderEntity getOrderEntity(GoodRepository goodRepository,
                                    PriceRepository priceRepository,
                                    StoreRepository storeRepository,
                                    SupplierRepository supplierRepository,
                                    EmployeeRepository employeeRepository) {

    return new OrderEntity(
        random.getOrderType(),
        new Random().nextInt(goodRepository.findAll().size()),
        new Random().nextInt(priceRepository.findAll().size()),
        new Random().nextInt(storeRepository.findAll().size()),
        new Random().nextInt(supplierRepository.findAll().size()),
        new Random().nextInt(employeeRepository.findAll().size())
    );
  }
}

package com.io.pipeline.modeling.fundamentals.service;

import com.io.pipeline.modeling.fundamentals.model.EmployeeEntity;
import com.io.pipeline.modeling.fundamentals.model.GoodEntity;
import com.io.pipeline.modeling.fundamentals.model.OrderEntity;
import com.io.pipeline.modeling.fundamentals.model.PriceEntity;
import com.io.pipeline.modeling.fundamentals.model.SalaryEntity;
import com.io.pipeline.modeling.fundamentals.model.StoreEntity;
import com.io.pipeline.modeling.fundamentals.model.SupplierEntity;
import com.io.pipeline.modeling.fundamentals.provider.EntityProvider;
import com.io.pipeline.modeling.fundamentals.repository.EmployeeRepository;
import com.io.pipeline.modeling.fundamentals.repository.GoodRepository;
import com.io.pipeline.modeling.fundamentals.repository.OrderRepository;
import com.io.pipeline.modeling.fundamentals.repository.PositionRepository;
import com.io.pipeline.modeling.fundamentals.repository.PriceRepository;
import com.io.pipeline.modeling.fundamentals.repository.SalaryRepository;
import com.io.pipeline.modeling.fundamentals.repository.StoreRepository;
import com.io.pipeline.modeling.fundamentals.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class ValueFiller {

  private final SalaryRepository salaryRepository;
  private final PositionRepository positionRepository;
  private final PriceRepository priceRepository;
  private final StoreRepository storeRepository;
  private final SupplierRepository supplierRepository;
  private final GoodRepository goodRepository;
  private final EmployeeRepository employeeRepository;
  private final OrderRepository orderRepository;

  private final EntityProvider entityProvider;

  public String fillAllTables() {
    try {
      this.fillSalaries();
      this.fillPositions();
      this.fillPrices();
      this.fillStores();
      this.fillSuppliers();
      this.fillGoods();
      this.fillEmployees();
      this.fillOrders();
    } catch (Exception e) {
      e.printStackTrace();
      return "Failed";
    }
    return "Done";
  }

  public void fillSalaries() {
    List<SalaryEntity> salaryEntities = new ArrayList<>();
    IntStream.range(1, 51).forEach(
        x -> salaryEntities.add(entityProvider.getSalaryEntity())
    );
    salaryRepository.saveAll(salaryEntities);
  }

  public void fillPositions() {
    positionRepository.saveAll(entityProvider.getPositionEntities());
  }

  public void fillPrices() {
    List<PriceEntity> prices = new ArrayList<>();
    IntStream.range(0, 100).forEach(
        x -> prices.add(entityProvider.getPriceEntity())
    );
    priceRepository.saveAll(prices);
  }

  public void fillStores() {
    List<StoreEntity> stores = new ArrayList<>();
    IntStream.range(1, 21).forEach(
        x -> stores.add(entityProvider.getStoreEntity(x))
    );
    storeRepository.saveAll(stores);
  }

  public void fillSuppliers() {
    List<SupplierEntity> suppliers = new ArrayList<>();
    IntStream.range(1, 51).forEach(
        x -> suppliers.add(entityProvider.getSupplierEntity(x))
    );
    supplierRepository.saveAll(suppliers);
  }

  public void fillGoods() {
    List<GoodEntity> goods = new ArrayList<>();
    IntStream.range(1, 101).forEach(
        x -> goods.add(entityProvider.getGoodEntity(x, priceRepository))
    );
    goodRepository.saveAll(goods);
  }

  public void fillEmployees() {
    List<EmployeeEntity> employees = new ArrayList<>();
    for (int i = 1; i <= storeRepository.findAll().size(); i++) {
      StoreEntity store = storeRepository.getById(i);

      IntStream.range(1, store.getEmployeesCount())
          .forEach(
              x -> employees.add(
                  entityProvider.getEmployeeEntity(x, store.getId(), salaryRepository)
              )
          );

      employeeRepository.saveAll(employees);
    }
  }

  public void fillOrders() {
    List<OrderEntity> orders = new ArrayList<>();
    IntStream.range(1, 200).forEach(
        x -> orders.add(entityProvider.getOrderEntity(
            goodRepository,
            priceRepository,
            storeRepository,
            supplierRepository,
            employeeRepository
            )
        )
    );
    orderRepository.saveAll(orders);
  }
}

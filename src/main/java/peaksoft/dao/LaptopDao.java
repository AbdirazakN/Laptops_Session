package peaksoft.dao;

import peaksoft.configuration.DBConnection;
import peaksoft.enums.OperationSystem;
import peaksoft.model.Laptop;

import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Map;

public interface LaptopDao {
    // save
    Laptop saveLaptop(Laptop newLaptop);

    // delete
    Laptop deleteById(Long id);

    // deleteAll
    void deleteAll();

    // findAll
    List<Laptop> findAll();

    // update
    Laptop update(Long id,Laptop laptop);

    // groupBy
    Map<OperationSystem,List<Laptop>> groupBy();

    // sortByDifferentColumn
    List<Laptop> sortByDifferentColumn(String column, String ascOrDesc);
}

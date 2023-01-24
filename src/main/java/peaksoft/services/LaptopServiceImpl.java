package peaksoft.services;

import peaksoft.dao.LaptopDao;
import peaksoft.dao.LaptopDaoImpl;
import peaksoft.enums.OperationSystem;
import peaksoft.model.Laptop;

import java.util.List;
import java.util.Map;

public class LaptopServiceImpl implements LaptopService{
    private LaptopDao laptop = new LaptopDaoImpl();

    @Override
    public Laptop saveLaptop(Laptop newLaptop) {
        return laptop.saveLaptop(newLaptop);
    }

    @Override
    public Laptop deleteById(Long id) {
        return laptop.deleteById(id);
    }

    @Override
    public void deleteAll() {
laptop.deleteAll();
    }

    @Override
    public List<Laptop> findAll() {
        return laptop.findAll();
    }

    @Override
    public Laptop update(Long id, Laptop laptop) {
        return laptop;
    }

    @Override
    public Map<OperationSystem, List<Laptop>> groupBy() {
        return laptop.groupBy();
    }

    @Override
    public List<Laptop> sortByDifferentColumn(String column, String ascOrDesc) {
        return laptop.sortByDifferentColumn(column,ascOrDesc);
    }
}

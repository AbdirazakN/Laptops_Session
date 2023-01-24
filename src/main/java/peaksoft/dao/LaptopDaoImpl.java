package peaksoft.dao;

import peaksoft.configuration.DBConnection;
import peaksoft.enums.OperationSystem;
import peaksoft.model.Laptop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class LaptopDaoImpl implements LaptopDao, AutoCloseable {
    private EntityManagerFactory entityManagerFactory = DBConnection.createEntityManagerFactory();

    //    @Override
//    public Laptop saveLaptop(Laptop newLaptop) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(newLaptop);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        return newLaptop;
//    }
    @Override
    public Laptop saveLaptop(Laptop laptop) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(laptop);
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptop;
    }

    @Override
    public Laptop deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Laptop id2 = entityManager.createQuery("select l from Laptop l where l.id = :id ", Laptop.class).setParameter("id", id).getSingleResult();
        entityManager.remove(id2);
        entityManager.getTransaction().commit();
        entityManager.close();
        return id2;
    }

    @Override
    public void deleteAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.clear();
//        List<Laptop> laptops = entityManager.createQuery("select l from Laptop l ",Laptop.class).getResultList();
//        for (Laptop laptop : laptops) {
//            entityManager.remove(laptop);
//        }
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Successfully deleted all laptops...");
    }

    @Override
    public List<Laptop> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Laptop> laptops = entityManager.createQuery("select l from Laptop l ", Laptop.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptops;
    }

    @Override
    public Laptop update(Long id, Laptop laptop) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Laptop lap = entityManager.getReference(Laptop.class, id);
        lap.setBrand(laptop.getBrand());
        lap.setPrice(laptop.getPrice());
        lap.setDateOfIssue(laptop.getDateOfIssue());
        lap.setOperationSystem(laptop.getOperationSystem());

        return lap;
    }

    @Override
    public Map<OperationSystem, List<Laptop>> groupBy() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Map<OperationSystem, List<Laptop>> group = entityManager.createQuery("select l from Laptop l", Laptop.class).getResultStream()
                .collect(Collectors.groupingBy(Laptop::getOperationSystem));
        entityManager.getTransaction().commit();
        entityManager.close();
        return group;
    }

    @Override
    public List<Laptop> sortByDifferentColumn(String column, String ascOrDesc) {
        List<Laptop> laptops = new ArrayList<>();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
//        List<Laptop> laptops = entityManager.createQuery("select p from p Laptop  order by ? ").getResultList();
        if (column.toLowerCase().equals("brand")) {
            if (ascOrDesc.equals("asc")) {
                laptops = entityManager.createQuery("select l from Laptop l order by brand", Laptop.class).getResultList();
            } else if (ascOrDesc.equals("desc")) {
                laptops = entityManager.createQuery("select l from Laptop l order by brand desc ", Laptop.class).getResultList();
            }
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptops;
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}

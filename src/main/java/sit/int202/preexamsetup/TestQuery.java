package sit.int202.preexamsetup;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.preexamsetup.entities.Employee;
import sit.int202.preexamsetup.entities.Office;
import sit.int202.preexamsetup.entities.Products;

import java.util.List;

public class TestQuery {
    public static void main(String[] args) {
        testNamedQuery();
    }

    public static void testNamedQuery() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("classic-models");
        EntityManager em = emf.createEntityManager();
        Office office = em.find(Office.class, "1");
//        System.out.println(office);

        List<Products> products = em
                .createNamedQuery("Products.findAll", Products.class)
                .getResultList();
//        products.forEach(System.out::println);
        List<Employee> employees = em.createNamedQuery("Employee.findAll", Employee.class)
                .getResultList();
        employees.forEach(System.out::println);

    }
}

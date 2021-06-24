package com.kvinod.programs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.kvinod.entity.Department;
import com.kvinod.entity.Employee;

public class AddNewEmployee {

    public static void main(String[] args) {
        Department admin = new Department();
        admin.setName("Administration");
        admin.setLocation("Bangalore");

        Employee ram = new Employee();
        ram.setName("Ram Kumar");
        ram.setSalary(35000.0);
        ram.setDepartment(admin);
        ram.setEmail("ramkumar@xmpl.com");

        Employee hari = new Employee();
        hari.setName("Harish Kumar");
        hari.setSalary(37000.0);
        hari.setEmail("harishkumar@xmpl.com");
        hari.setDepartment(admin);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TRAINING");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(ram);
        em.persist(hari);
        tx.commit();

        em.close();
    }
}

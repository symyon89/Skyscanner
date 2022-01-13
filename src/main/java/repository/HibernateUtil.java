package repository;

import lombok.Data;
import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import javax.persistence.EntityManager;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Data
public class HibernateUtil {
    private static final HibernateUtil hibernateUtil = new HibernateUtil();

    private final SessionFactory sessionFactory;
    private final EntityManager entityManager;

    private HibernateUtil() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Passenger.class)
                .addAnnotatedClass(Airport.class)
                .addAnnotatedClass(Aircraft.class)
                .addAnnotatedClass(Flight.class)
                .addAnnotatedClass(Ticket.class)
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(Address.class);

        sessionFactory = configuration.buildSessionFactory();
        entityManager =sessionFactory.createEntityManager();
    }
    public static HibernateUtil getInstance() {
        return hibernateUtil;
    }
    public Session openSession() {
        return sessionFactory.openSession();
    }
    // primeste un parametru si nu returneaza nimic - CONSUMA
    public void runWithTransaction(Consumer<EntityManager> lambda) {
        entityManager.getTransaction().begin();
        try {
            lambda.accept(entityManager);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }

    // doar scop educativ
    // nu primeste parametru insa returneaza un obiect de tipul genericului Supplier - FURNIZEAZA
    public void runWithSupplier(Supplier<EntityManager> lambda) {
        EntityManager returnedValue = lambda.get();
    }
    // doar scop educativ
    // este in acelasi timp si CONSUMATOR si FURNIZOR (Consumer si Supplier)
    public <T> void runWithFunction(Function<EntityManager, T> lambda) {
        T result = lambda.apply(entityManager);
        System.out.println(result);
    }

}

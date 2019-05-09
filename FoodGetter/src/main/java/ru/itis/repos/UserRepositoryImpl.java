package ru.itis.repos;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.itis.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    EntityManager entityManager;
    @Autowired
    public UserRepositoryImpl(@Qualifier(value = "entityManagerFactory")EntityManagerFactory entityManagerFactory) {
        entityManager = entityManagerFactory.createEntityManager();
    }
    @Override
    public List<User> findAll() {
        List<User> users = sessionFactory
                .openSession()
                .createQuery("SELECT first_name, last_name, email, address FROM system_user").list();
        return users;
    }

    @Override
    public User findById(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public List<User> findByStatus(Long status) {
        List<User> users = sessionFactory
                .openSession()
                .createQuery("SELECT first_name, last_name, email, address FROM system_useer WHERE status_id = ?").list();
        return users;
    }

    @Override
    public void addUser(User user) {
        entityManager.getTransaction();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateUser(User user) {
        entityManager.getTransaction();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteById(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.getTransaction();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }
}

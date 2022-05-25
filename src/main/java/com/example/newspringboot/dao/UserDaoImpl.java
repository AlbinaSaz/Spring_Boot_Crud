package com.example.newspringboot.dao;


import com.example.newspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void updateUser(User user, int id) {
        User user1 = entityManager.find(User.class, id);
        user1.setName(user.getName());
        user1.setAge(user.getAge());
        user1.setHobby(user.getHobby());
        entityManager.persist(user1);

    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        Query query = entityManager.createQuery("DELETE from User u WHERE u.id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    @Override
    public User findUser(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Transactional
    @Override
    public List<User> allUsers() {
        List<User> users;
        Query query = entityManager.createQuery("SELECT u FROM User u", User.class);
        users = query.getResultList();
        return users;
    }
}

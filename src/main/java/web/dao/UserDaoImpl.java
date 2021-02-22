package web.dao;

import org.springframework.stereotype.Repository;
import web.usermanager.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUpdateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(int id) {
        Query query = entityManager.createQuery("delete from User where id =:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> listUsers() {
        Query query = entityManager.createQuery("from User");
        return query.getResultList();
    }
}

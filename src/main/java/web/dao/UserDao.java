package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        entityManager.persist(user);
    }

    public void updateUser(int id, User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        User curUser = entityManager.find(User.class, id);
        if (curUser == null) {
            return;
        }

        curUser.setName(user.getName());
        curUser.setAge(user.getAge());
        curUser.setEmail(user.getEmail());
        entityManager.merge(curUser);
    }

    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        if(user != null) {
            entityManager.remove(user);
        }
    }
}

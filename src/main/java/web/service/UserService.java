package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;
import java.util.List;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getUsers(){
        return userDao.getUsers();
    }

    public User getUser(int id){
        return userDao.getUser(id);
    }

    @Transactional
    public void addUser(User user){
        userDao.addUser(user);
    }

    @Transactional
    public void updateUser(int id, User user){
        userDao.updateUser(id, user);
    }

    @Transactional
    public void deleteUser(int id){
        userDao.deleteUser(id);
    }
}

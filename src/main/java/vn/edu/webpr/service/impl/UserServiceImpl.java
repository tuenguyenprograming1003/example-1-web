package vn.edu.webpr.service.impl;

import vn.edu.webpr.dao.UserDao;
import vn.edu.webpr.dao.impl.UserDaoImpl;
import vn.edu.webpr.model.User;
import vn.edu.webpr.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        User u = userDao.get(username);
        // Demo: so sánh plain-text (production: dùng hash)
        if (u != null && password != null && password.equals(u.getPassWord())) {
            return u;
        }
        return null;
    }

    @Override
    public User get(String username) {
        return userDao.get(username);
    }
}

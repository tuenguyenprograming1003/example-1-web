package vn.edu.webpr.dao;

import vn.edu.webpr.model.User;

public interface UserDao {
    User get(String username);
}

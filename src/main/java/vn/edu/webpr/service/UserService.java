package vn.edu.webpr.service;

import vn.edu.webpr.model.User;

public interface UserService {
    User login(String username, String password);
    User get(String username);
}

package vn.edu.webpr.dao.impl;

import vn.edu.webpr.dao.UserDao;
import vn.edu.webpr.model.User;
import vn.edu.webpr.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {

    @Override
    public User get(String username) {
        String sql = "SELECT * FROM `User` WHERE username = ?";
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User u = new User();
                    u.setId(rs.getInt("id"));
                    u.setEmail(rs.getString("email"));
                    u.setUserName(rs.getString("username"));
                    u.setFullName(rs.getString("fullname"));
                    u.setPassWord(rs.getString("password"));
                    u.setAvatar(rs.getString("avatar"));
                    u.setRoleid(rs.getInt("roleid"));
                    u.setPhone(rs.getString("phone"));
                    u.setCreatedDate(rs.getDate("createdDate"));
                    return u;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

package vn.edu.webpr.controller;

import vn.edu.webpr.model.User;
import vn.edu.webpr.service.UserService;
import vn.edu.webpr.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginController extends jakarta.servlet.http.HttpServlet {
    private final UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        boolean isRemember = "on".equals(remember);

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            req.setAttribute("alert", "Tài khoản hoặc mật khẩu không được để trống");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            return;
        }

        User user = service.login(username, password);
        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);
            if (isRemember) {
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(7 * 24 * 60 * 60); // 1 tuần
                cookie.setPath(req.getContextPath());
                resp.addCookie(cookie);
            }
            resp.sendRedirect(req.getContextPath() + "/waiting");
        } else {
            req.setAttribute("alert", "Tài khoản hoặc mật khẩu không đúng");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }
}

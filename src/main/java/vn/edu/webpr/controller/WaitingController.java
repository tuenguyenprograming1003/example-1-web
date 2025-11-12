package vn.edu.webpr.controller;

import vn.edu.webpr.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/waiting")
public class WaitingController extends jakarta.servlet.http.HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        User u = session != null ? (User) session.getAttribute("account") : null;
        if (u == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        req.setAttribute("user", u);
        req.getRequestDispatcher("/views/waiting.jsp").forward(req, resp);
    }
}

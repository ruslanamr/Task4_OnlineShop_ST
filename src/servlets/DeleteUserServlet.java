package servlets;

import bd.DbConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;

@WebServlet("/deleteuser")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String pass = req.getParameter("pass");
        User user = DbConnect.getUserById(id);

        if (pass.equals(user.getPassword())) {
            DbConnect.deleteUser(id);
            resp.sendRedirect("users");
        } else {
            req.getRequestDispatcher("errdelete.jsp").forward(req, resp);
        }
    }
}

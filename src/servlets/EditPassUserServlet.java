package servlets;

import bd.DbConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;

@WebServlet("/editpassuser")
public class EditPassUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pass = req.getParameter("pass");
        String pass1 = req.getParameter("pass1");
        String pass2 = req.getParameter("pass2");
        Long id = Long.parseLong(req.getParameter("id"));

        User user = DbConnect.getUserById(id);
        if (pass.equals(user.getPassword()) && pass1.equals(pass2)){
            DbConnect.updateUserPass(pass1, id);
            resp.sendRedirect("/userdetail?id=" + id);
        } else {
            req.getRequestDispatcher("errdelete.jsp").forward(req,resp);
        }

    }
}

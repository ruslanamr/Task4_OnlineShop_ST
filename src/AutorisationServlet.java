import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;
import java.io.StringReader;

@WebServlet("/autorisation")
public class AutorisationServlet extends HttpServlet {
    String err = "err";
    String norm = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("err", norm);
        req.getRequestDispatcher("autorisation.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String email = req.getParameter("email");
       String pass = req.getParameter("pass");
       User user = DbConnect.autoBd(email, pass);


       if (user!=null){
       req.setAttribute("name", user);
       req.getRequestDispatcher("profile.jsp").forward(req, resp);
       } else {
        //   resp.sendRedirect("autorisation");

           req.setAttribute("err", err);
           req.getRequestDispatcher("autorisation.jsp").forward(req, resp);
       }

    }
}

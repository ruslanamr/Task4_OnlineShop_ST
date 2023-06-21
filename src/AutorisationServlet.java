import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.StringReader;

@WebServlet("/autorisation")
public class AutorisationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("autorisation.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String email = req.getParameter("email");
       String pass = req.getParameter("pass");
       String name = DbConnect.autoBd(email, pass);

       if (name!=null){
       req.setAttribute("name", name);
       req.getRequestDispatcher("profile.gsp").forward(req, resp);
       } else {

       }

    }
}

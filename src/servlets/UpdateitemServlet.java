package servlets;

import bd.DbConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/updateitem")
public class UpdateitemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String desc = req.getParameter("desc");
        Double price = Double.parseDouble(req.getParameter("price"));
        Long brand_id = Long.parseLong(req.getParameter("brand"));
        Long id = Long.parseLong(req.getParameter("id"));

        DbConnect.updateItem(name, desc, price, brand_id, id);
        resp.sendRedirect("/itemsdetail?id=" + id);
    }
}

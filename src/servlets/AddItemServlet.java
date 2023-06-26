package servlets;

import bd.DbConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addItem")
public class AddItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("brands", DbConnect.getBrands());
        req.setAttribute("items", DbConnect.getItems());
        req.setAttribute("countries", DbConnect.getCountries());
        req.getRequestDispatcher("addItem.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String desc = req.getParameter("desc");
        Double price = Double.parseDouble(req.getParameter("price"));
        Long brand_id = Long.parseLong(req.getParameter("brand"));

        DbConnect.addItem(name, desc, price, brand_id);
        resp.sendRedirect("/adminpanel");
    }
}

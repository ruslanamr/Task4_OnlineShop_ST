package servlets;

import bd.DbConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/adminpanel")
public class AdminpanelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("items", DbConnect.getItems());
        req.setAttribute("brands", DbConnect.getBrands());
        req.setAttribute("countries", DbConnect.getCountries());
        req.getRequestDispatcher("/adminpanel.jsp").forward(req, resp);
    }
}

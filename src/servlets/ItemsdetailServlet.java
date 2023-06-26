package servlets;

import bd.DbConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/itemsdetail")
public class ItemsdetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        req.setAttribute("item", DbConnect.getItemById(id));
        req.setAttribute("brands", DbConnect.getBrands());
        req.getRequestDispatcher("itemsdetail.jsp").forward(req, resp);

    }
}

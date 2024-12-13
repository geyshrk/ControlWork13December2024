package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/details")
public class Details extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("sportsService", req.getServletContext().getAttribute("sportsService"));
        req.getRequestDispatcher("/views/inventoryDetails.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("sportsService", req.getServletContext().getAttribute("sportsService"));
        req.getRequestDispatcher("/views/inventoryDetails.jsp").forward(req, res);
    }
}

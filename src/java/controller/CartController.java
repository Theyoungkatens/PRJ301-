/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DAO;
import dto.Cart;
import dto.Mobile;
import dto.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tony
 */
public class CartController extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User session = (User) req.getSession().getAttribute("user");
        if (session == null) {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        resp.setContentType("text/html;charset=UTF-8");

        
        String action = req.getParameter("action");
        if (action == null) {
            req.getRequestDispatcher("cart.jsp").forward(req, resp);
        }

        if ("search".equalsIgnoreCase(action)) {
            String minPrice = req.getParameter("minPrice");
            String maxPrice = req.getParameter("maxPrice");
            if (minPrice == null || maxPrice == null) {
                req.setAttribute("message", "Please provide min and max price.");
                req.getRequestDispatcher("cart.jsp").forward(req, resp);
            } else {
                List<Mobile> mobiles = new DAO().getAllMobilesWithCondition(Float.parseFloat(minPrice), Float.parseFloat(maxPrice));
                req.setAttribute("mobiles", mobiles);
                req.getRequestDispatcher("cart.jsp").forward(req, resp);    
            }
        }

        if ("viewCart".equalsIgnoreCase(action)) {
            List<Cart> carts = new ArrayList<>();
            carts = new DAO().getCart();
            if (carts != null) {
                req.setAttribute("carts", carts);
                req.getRequestDispatcher("cart.jsp").forward(req, resp);
            }
        }

        if ("removeFromCart".equalsIgnoreCase(action)) {
            DAO dao = new DAO();
            String cartId = req.getParameter("cartId");
            boolean response = dao.removeFromCart(Integer.parseInt(cartId));
            if (response == true) {
                req.setAttribute("message", "Delete mobile successfully.");
            } else {
                req.setAttribute("message", "Failed to delete mobile.");
            }
            req.getRequestDispatcher("cart.jsp").forward(req, resp);
        }

        if ("addToCart".equalsIgnoreCase(action)) {
            DAO dao = new DAO();
            String mobileId = req.getParameter("mobileId");
            boolean response = dao.addToCart(session.getUserId(), mobileId);
            if (response == true) {
                req.setAttribute("message", "Add to cart successfully.");
            } else {
                req.setAttribute("message", "Failed to add to cart.");
            }
            req.getRequestDispatcher("cart.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

}
package inm.or.common.processExample.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/hi")
public class CustomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println("CustomServlet: " + req.getRequestURI() + " " + req.getMethod() + " " + action);
        if ("forward".equals(action)) {
            req.getRequestDispatcher("/forwarded").forward(req, resp);
        } else if ("redirect".equals(action)) {
            resp.sendRedirect("/api/hello");
        } else {
            resp.getWriter().write("Hello, World!");
        }
    }
}

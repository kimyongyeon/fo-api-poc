package inm.od.common.sys.common.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@Log4j2
@WebServlet(name = "customServlet", urlPatterns = "/custom")
public class CustomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("CustomServlet doGet");

        String requestURI = req.getRequestURI();
        String method = req.getMethod();
        HttpSession session = req.getSession();
        String name = req.getParameter("name");

        log.info("requestURI: {}", requestURI);
        log.info("method: {}", method);
        log.info("session: {}", session);

//        Cookie cookie = new Cookie("Authorize", UUID.randomUUID().toString() + ":cookie");
//        resp.addCookie(cookie);
//        resp.addHeader("customHeader", UUID.randomUUID().toString() + ":header");




    }
}

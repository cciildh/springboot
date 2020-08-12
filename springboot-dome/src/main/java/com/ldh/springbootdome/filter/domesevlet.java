package com.ldh.springbootdome.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * domesevlet
 */
@WebServlet(name="domesevlet",urlPatterns="/sevlet")
public class domesevlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // resp.setContentType("text/html;charset=utf-8");
        // resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("李道华到此一游Filter");
      
    }
}
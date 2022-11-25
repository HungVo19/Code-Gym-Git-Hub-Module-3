package com.example.simple_login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "Login_servlet", value = "/Login_servlet")
public class Login_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals("hungvo")&&password.equals("hungvo")){
            request.setAttribute("loginTime",new Date());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminpage.jsp");
            requestDispatcher.forward(request,response);
        } else {
           response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        if(username.equals("hungvo")&&password.equals("hungvo")){
            writer.println("<h1>Welcome" + username + "to website</h1>" );
        } else {
            writer.println("<h1>Login_servlet error</h1>");
        }
        writer.println("</html>");
    }
}

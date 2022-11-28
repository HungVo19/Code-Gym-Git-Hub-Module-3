package Controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals("hungvo")&&password.equals("hungvo")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ProductServlet?action=reload");
            requestDispatcher.forward(request,response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals("hungvo")&&password.equals("hungvo")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ProductServlet?action=reload");
            requestDispatcher.forward(request,response);
        } else {
            response.sendRedirect("index.jsp");        }
    }
}


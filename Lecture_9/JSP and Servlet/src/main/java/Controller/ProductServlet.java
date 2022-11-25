package Controller;

import Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private final ArrayList<Product> products = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "add":
                String name = request.getParameter("name");
                Double price = Double.parseDouble(request.getParameter("price"));
                Integer quantity = Integer.parseInt(request.getParameter("quantity"));
                products.add(new Product(name, price, quantity));
                PrintWriter printWriter = response.getWriter();
                printWriter.println("");
                response.sendRedirect("index.jsp");
                break;
            case "view":
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewProduct.jsp");
                request.setAttribute("products", products);
                requestDispatcher.forward(request, response);
                break;
            case "update":
                int index = Integer.parseInt(request.getParameter("id"))-1;
                String productName = products.get(index).getName();
                Double productPrice = products.get(index).getPrice();
                Integer productQuantity = products.get(index).getQuantity();
                request.setAttribute("index",index);
                request.setAttribute("name",productName);
                request.setAttribute("price",productPrice);
                request.setAttribute("quantity",productQuantity);
                RequestDispatcher rd = request.getRequestDispatcher("updateProduct.jsp");
                rd.forward(request,response);
                break;
            case "updateX":
                int indexToUpdate = Integer.parseInt(request.getParameter("index"));
                String newName = request.getParameter("newName");
                products.get(indexToUpdate).setName(newName);

                Double newPrice = Double.parseDouble(request.getParameter("newPrice"));
                products.get(indexToUpdate).setPrice(newPrice);

                Integer newQuantity = Integer.parseInt(request.getParameter("newQuantity"));
                products.get(indexToUpdate).setQuantity(newQuantity);

                RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("viewProduct.jsp");
                request.setAttribute("products", products);
                requestDispatcher1.forward(request, response);
                break;
            case "delete":
                int indexToDel = Integer.parseInt(request.getParameter("id")) - 1;
                products.remove(indexToDel);

                RequestDispatcher requestDispatcher2 = request.getRequestDispatcher("viewProduct.jsp");
                request.setAttribute("products", products);
                requestDispatcher2.forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

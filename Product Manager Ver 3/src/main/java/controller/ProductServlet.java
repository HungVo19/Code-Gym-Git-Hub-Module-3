package controller;

import model.Category;
import model.Product;
import model.Validation;
import service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductServiceImpl productService;
    private Validation validation;


    @Override
    public void init() {
        productService = new ProductServiceImpl();
        validation = new Validation();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "viewProduct":
                viewProduct(request,response);
                break;
            default:
                displayProductsList(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "search":
                search(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
        }
    }

    private void displayProductsList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list-product.jsp");
        request.setAttribute("categories", productService.getCategoryService().findAll());
        request.setAttribute("products", productService.findAll());
        requestDispatcher.forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        PrintWriter printWriter = response.getWriter();
        if (validation.parseDouble(request.getParameter("price")) == null) {
            printWriter.println("<script type=\"text/javascript\">");
            printWriter.println("alert('Wrong input')");
            printWriter.println("window.location.href = \"addProduct.jsp\";");
            printWriter.println("</script>");
        }
        if (!validation.checkInteger(request.getParameter("quantity"))) {
            printWriter.println("<script type=\"text/javascript\">");
            printWriter.println("alert('Wrong input')");
            printWriter.println("window.location.href = \"addProduct.jsp\";");
            printWriter.println("</script>");
        }
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        Category category = productService.getCategoryService().findById(Long.valueOf(request.getParameter("category")));
        productService.save(new Product(name, price, quantity, category));
        response.sendRedirect("http://localhost:8080/products");
    }

    private void search(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameSearch");
        ArrayList<Product> searchedProducts = productService.findByNameContaining(name);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list-product.jsp");
        request.setAttribute("products",searchedProducts);
        request.setAttribute("categories", productService.getCategoryService().findAll());
        requestDispatcher.forward(request,response);
    }

    private void delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        productService.deleteById(id);
        response.sendRedirect("http://localhost:8080/products");
    }

    private void viewProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("idP"));
        Product product = productService.findById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list-product.jsp");
        request.setAttribute("viewedProduct",product);
        requestDispatcher.forward(request,response);
    }

}

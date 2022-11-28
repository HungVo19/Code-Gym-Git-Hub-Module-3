package Controller;

import Model.Product;
import Model.ProductManager;
import Model.Validation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet implements Serializable {
    ProductManager productManager = new ProductManager();
    private final Validation validation = new Validation();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = productManager.getProducts();
        String action = request.getParameter("action");
        PrintWriter printWriter = response.getWriter();
        switch (action) {
            case "add":
                String name = request.getParameter("name");
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
                products.add(new Product(name, price, quantity));
                productManager.getFile().writeToFile(products, productManager.getFilePath());
                break;
            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                int index = findIndexByID(id);
                String productName = products.get(index).getName();
                Double productPrice = products.get(index).getPrice();
                Integer productQuantity = products.get(index).getQuantity();
                request.setAttribute("id", id);
                request.setAttribute("index", index);
                request.setAttribute("name", productName);
                request.setAttribute("price", productPrice);
                request.setAttribute("quantity", productQuantity);
                RequestDispatcher rd = request.getRequestDispatcher("updateProduct.jsp");
                rd.forward(request, response);
                break;
            case "updateX":
                int idToUpdate = Integer.parseInt(request.getParameter("id"));
                int indexToUpdate = Integer.parseInt(request.getParameter("index"));
                String newName = new String();
                if (request.getParameter("newName").isEmpty()||request.getParameter("newName")==null) {
                    newName = products.get(indexToUpdate).getName();
                } else {
                    newName = request.getParameter("newName");
                }
                Double newPrice;
                if (validation.parseDouble(request.getParameter("newPrice")) == null || request.getParameter("newPrice").isEmpty()) {
                    newPrice = products.get(indexToUpdate).getPrice();
                } else {
                    newPrice = Double.parseDouble(request.getParameter("newPrice"));
                }

                Integer newQuantity;
                if (!validation.checkInteger(request.getParameter("newQuantity")) || request.getParameter("newQuantity").isEmpty()) {
                    newQuantity = products.get(indexToUpdate).getQuantity();
                } else {
                    newQuantity = Integer.parseInt(request.getParameter("newQuantity"));
                }
                products.get(indexToUpdate).setName(newName);

                products.get(indexToUpdate).setPrice(newPrice);

                products.get(indexToUpdate).setQuantity(newQuantity);
                productManager.getFile().writeToFile(products, productManager.getFilePath());
                break;
            case "delete":
                int idToDel = Integer.parseInt(request.getParameter("id"));
                int indexToDel = findIndexByID(idToDel);
                String nameToDel = products.get(indexToDel).getName();
                Double priceToDel = products.get(indexToDel).getPrice();
                Integer quantityToDel = products.get(indexToDel).getQuantity();
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("deleteConfirm.jsp");
                request.setAttribute("index", indexToDel);
                request.setAttribute("name", nameToDel);
                request.setAttribute("price", priceToDel);
                request.setAttribute("quantity", quantityToDel);
                requestDispatcher.forward(request, response);
                break;
            case "deleteX":
                int indexX = Integer.parseInt(request.getParameter("index"));
                products.remove(indexX);
                productManager.getFile().writeToFile(products, productManager.getFilePath());
                reload(request, response);
                break;
            case "reload":
                reload(request, response);
                break;
        }
        reload(request, response);
    }

    private void reload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = productManager.getProducts();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewProduct.jsp");
        request.setAttribute("products", products);
        requestDispatcher.forward(request, response);
    }

    public int findIndexByID(int id) {
        ArrayList<Product> products = productManager.getProducts();
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}

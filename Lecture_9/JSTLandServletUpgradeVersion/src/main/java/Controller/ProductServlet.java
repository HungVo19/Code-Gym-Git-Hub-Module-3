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
import java.util.ArrayList;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
//    private final ArrayList<Product> products = new ArrayList<>();
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
                break;
            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                int index = findIndexByID(id);
                String productName = products.get(index).getName();
                Double productPrice = products.get(index).getPrice();
                Integer productQuantity = products.get(index).getQuantity();
                request.setAttribute("index", index);
                request.setAttribute("name", productName);
                request.setAttribute("price", productPrice);
                request.setAttribute("quantity", productQuantity);
                RequestDispatcher rd = request.getRequestDispatcher("updateProduct.jsp");
                rd.forward(request, response);
                break;
            case "updateX":
                int indexToUpdate = Integer.parseInt(request.getParameter("index"));

                if (validation.parseDouble(request.getParameter("newPrice")) == null) {
                    printWriter.println("<script type=\"text/javascript\">");
                    printWriter.println("alert('Wrong input')");
                    printWriter.println("window.location.href = \"updateProduct.jsp\";");
                    printWriter.println("</script>");
                }
                if (!validation.checkInteger(request.getParameter("newQuantity"))) {
                    printWriter.println("<script type=\"text/javascript\">");
                    printWriter.println("alert('Wrong input')");
                    printWriter.println("window.location.href = \"updateProduct.jsp\";");
                    printWriter.println("</script>");
                }
                String newName = request.getParameter("newName");
                products.get(indexToUpdate).setName(newName);

                Double newPrice = Double.parseDouble(request.getParameter("newPrice"));
                products.get(indexToUpdate).setPrice(newPrice);

                Integer newQuantity = Integer.parseInt(request.getParameter("newQuantity"));
                products.get(indexToUpdate).setQuantity(newQuantity);
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
                reload(request,response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

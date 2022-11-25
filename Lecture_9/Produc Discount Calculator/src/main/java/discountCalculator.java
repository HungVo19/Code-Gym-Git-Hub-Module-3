import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "discountCalculator", value = "/discountCalculator")
public class discountCalculator extends HttpServlet {
   private Map<String,Float> list;

    @Override
    public void init() throws ServletException {
        list = new HashMap<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String product = request.getParameter("product");
        Float price = Float.parseFloat(request.getParameter("price"));
        float discount = Float.parseFloat(request.getParameter("discount"));
        list.put(product,price);
        PrintWriter printWriter = response.getWriter();
        for(Map.Entry<String, Float> entry: list.entrySet()){
            printWriter.println("Product: "+entry.getKey() + "; List Price: " + entry.getValue() + "; Sale price: " +(entry.getValue()*(100-discount)/100));
            printWriter.println("<br>");
        }
    }
}

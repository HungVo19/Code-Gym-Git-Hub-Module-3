import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "translation", value = "/translation")
public class translation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("hello","xin chào");
        dictionary.put("how","thế nào");
        dictionary.put("book","quyển sách");
        dictionary.put("computer","máy vi tính");
        dictionary.put("phone","điện thoại");

        String search = request.getParameter("txtSearch").toLowerCase();
        PrintWriter printWriter = response.getWriter();

        String result = dictionary.get(search);
        if(result != null){
            printWriter.println("Word: " + search);
            printWriter.println("Result: " + result);
        } else {
          printWriter.println("<script type=\"text/javascript\">");
            printWriter.println("alert('not found')");
           printWriter.println("window.location.href = \"index.jsp\";");
printWriter.println("</script>");
        }
        }
    }
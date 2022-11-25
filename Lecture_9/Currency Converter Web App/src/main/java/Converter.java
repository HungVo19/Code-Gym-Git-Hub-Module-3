import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(name = "Converter", value = "/Converter")
public class Converter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float rate = Float.parseFloat(request.getParameter("rate"));
        PrintWriter printWriter = response.getWriter();
        if (parseDouble(request.getParameter("usd")) == null) {
            printWriter.println("<script type=\"text/javascript\">");
            printWriter.println("alert('Wrong input')");
            printWriter.println("window.location.href = \"index.jsp\";");
            printWriter.println("</script>");
        } else {
            float usd = Float.parseFloat(request.getParameter("usd"));
            float vnd = usd * rate;
            request.setAttribute("result",vnd);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
        }
    }

    private Double parseDouble(String myString) {
        final String Digits = "(\\p{Digit}+)";
        final String HexDigits = "(\\p{XDigit}+)";

        final String Exp = "[eE][+-]?" + Digits;
        final String fpRegex = ("[\\x00-\\x20]*" +
                "[+-]?(" +
                "NaN|" +
                "Infinity|" +

                "(((" + Digits + "(\\.)?(" + Digits + "?)(" + Exp + ")?)|" +
                "(\\.(" + Digits + ")(" + Exp + ")?)|" +
                "((" +
                "(0[xX]" + HexDigits + "(\\.)?)|" +

                "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +
                ")[pP][+-]?" + Digits + "))" + "[fFdD]?))" + "[\\x00-\\x20]*");
        if (Pattern.matches(fpRegex, myString))
            return Double.valueOf(myString);
        else {
            return null;
        }
    }
}

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
        float rate = Float.parseFloat(request.getParameter("rate"));
        if (parseDouble(request.getParameter("usd")) == null) {
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<html>");
            printWriter.println("<h1>Wrong input type</h1>");
            printWriter.println("</html>");
        } else {
            float usd = Float.parseFloat(request.getParameter("usd"));
            float vnd = usd * rate;
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<html>");
            printWriter.println("<h1>" + usd + " USD = " + vnd + " VND");
            printWriter.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

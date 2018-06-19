import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.text.*;


public class RegPays extends HttpServlet {
    double principal; //first sum
    double intRate; //percent
    double numYears; //срок погашения ссуды в годах

    final  int payPerYear = 12; //could be modify

    NumberFormat nf;

    public void doGet (HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        String payStr = "";

        nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);

        String amountStr = request.getParameter("amount");
        String periodStr = request.getParameter("period");
        String rateStr = request.getParameter("rate");

        try {
            if (amountStr != null && periodStr != null &&
                    rateStr != null) {
                principal = Double.parseDouble(amountStr);
                numYears = Double.parseDouble(periodStr);
                intRate = Double.parseDouble(rateStr) / 100;
                payStr = nf.format(compute());
            } else {
                amountStr = " ";
                periodStr = " ";
                rateStr = " ";
            }
        } catch (NumberFormatException exc) {

        }
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.print("<center><html><style>" +
                "div {\n" +
                "    background: #fc3; /* Цвет фона */\n" +
                "    border: 2px solid black; /* Параметры рамки */\n" +
                "    padding: 20px; /* Поля вокруг текста */\n" +
                "    margin-top: 20%; /* Отступ сверху */\n" +
                "   }</style><body><div> <left>" + "<form name = \"Form1\"" +
                "action=\"http://localhost:8080/" +
                "/RegPays\">" +
                "<B>Vvedite summu deneg\n:</B>" +
                "<input type=textbox name=\"amount\"" +
                "size=14 value=\"");
        pw.print(amountStr + "\">");
        //years
        pw.print("<BR><B>Kolichestvo Lets:</B>" +
                "<input type=textbox name=\"period\"" +
                "size=20 value=\"");
        pw.println(periodStr + "\">");
        //percent
        pw.print("<BR><B>Vvedite procen po ssudet:</B>" +
                "<input type=textbox name=\"rate\"" +
                "size=10 value=\"");
        pw.print(rateStr + "\">");
        //Monthly pay
        pw.print("<BR><B>Ezhemesjachnyj platezh:</B>" +
                "<input READONLY type=textbox" +
                "name=\"payment\" size=12 value=\"");
        pw.print(payStr + "\">");
        //Send
        pw.print("<BR><P><input type=submit value=\"Submit\">");
        pw.println ("</form> </div> </body> </html>");

    }

    //Ssuda
    double compute() {
        double number;
        double denom;
        double b, e;

        number = intRate * principal / payPerYear;
        e = -(payPerYear * numYears);
        b = (intRate / payPerYear) + 1.0;

        denom = 1.0 - Math.pow(b,e);
        return number/denom;
    }
}
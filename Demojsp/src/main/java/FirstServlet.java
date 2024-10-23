import javax.servlet.annotation.WebServlet;
import

import java.io.PrintWriter;

@WebServlet("/primers")

public class FirstServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServlerRequest req, HttpServletResponse res) throws {
        PrintWriter writer = resp.getWriter();
        writer.println("Hola");

        writer.println("<table>");

        writer.println("<tr><td>2</td>");

        int nelem = 0;

        writer.println("Albaricoque");
        for(int i = 3; i < 1000; i++) {
            boolean esPrimer = true;
            for(int j = 2; j<i; j++){
                if(i % j == 0 && j != i){
                    esPrimer = false;
                }
            }
            if(esPrimer){
                nelem++;
                if(nelem == 25){
                    writer.print("</tr><tr>");
                    nelem = 0;
                }
                writer.print("<td>" + i + "</td>");
            }
        };

        writer.println("</tr>");
        writer.println("</table>");

    }
}

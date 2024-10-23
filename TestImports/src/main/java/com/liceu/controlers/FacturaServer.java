package com.liceu.controlers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/factura")
public class FacturaServer extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        List<LiniaFactura> lines = new ArrayList<>();
        lines.add(new LiniaFactura(4, 700, "Pomes"));
        lines.add(new LiniaFactura(10, 850, "Mandarines"));
        lines.add(new LiniaFactura(3, 500, "Peres"));
        lines.add(new LiniaFactura(21, 250, "Platanos"));
        lines.add(new LiniaFactura(41, 50, "Freses"));

        writer.println("<table border=1>");
        writer.println("<tr><th>Quantitat</th><th>Preu</th><th>Concepte</th><th>Total</th></tr>");
        productData(lines, writer);
        calcSubTotals(lines, writer);
        writer.println("<tr><th></th><th></th><th>IVA 21%</th><th></th></tr>");
        writer.println("</table>");


    }


    private static void calcSubTotals(List<LiniaFactura> lines, PrintWriter writer){
        int subTotal = 0;
        for(LiniaFactura linea : lines){
            subTotal += linea.total;
        }
        writer.println("<td></td><td></td><td>SubTotal</td><td>" + String.format("%.2f", (double)subTotal / 100) + " &euro;</td>");
    }

    private static void productData(List<LiniaFactura> lines, PrintWriter writer) {
        for(LiniaFactura linea : lines){
            writer.println("<tr>");
            writer.println("<td>" + linea.quantitat + "</td>");
            writer.println("<td>" + String.format("%.2f", (double)linea.preu / 100) + " &euro;</td>");
            writer.println("<td>" + linea.concepte + "</td>");
            writer.println("<td>" + String.format("%.2f", (double)linea.total / 100) + " &euro;</td>");
            writer.println("</tr>");
        }
    }
}




class LiniaFactura{
    int quantitat;
    int preu;
    String concepte;
    int total;

    public LiniaFactura(int quantitat, int preu, String concepte) {
        this.quantitat = quantitat;
        this.preu = preu;
        this.concepte = concepte;
        this.total =(preu*quantitat);
    }
}

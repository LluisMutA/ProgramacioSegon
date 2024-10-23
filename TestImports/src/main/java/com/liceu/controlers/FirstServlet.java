//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet("/primers")
//
//public class FirstServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        PrintWriter writer = resp.getWriter();
//        writer.println("Hola");
//
//        writer.println("<table>");
//
//        writer.println("<tr><td>2</td>");
//
//
//
//        private List<Integer> calcPrimers(int numPrimers){
//
//        List<Integer> primers = calcPrimers(100);
//        int nelem = 0;
//        List<Integer> res = new ArrayList<>();
//        for(int i = 3; i < 1000; i++) {
//            boolean esPrimer = true;
//            for(int j = 2; j<i; j++){
//                if(i % j == 0 && j != i){
//                    esPrimer = false;
//                }
//            }
//            if(esPrimer){
//                nelem++;
//                res.add(i);
//                if(nelem == numPrimers)return res;
//            }
//        };
//        writer.println("</tr>");
//        writer.println("</table>");
//    }}
//}

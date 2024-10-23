<html>
<body>
<h2>Hello!</h2>
<table>

<tr><td>2</td>
<%
    int nelem = 0;

    out.println("Albaricoque");
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
                out.print("</tr><tr>");
                nelem = 0;
            }
            out.print("<td>" + i + "</td>");
        }
    };

%>
</tr>

</table>


</body>
</html>

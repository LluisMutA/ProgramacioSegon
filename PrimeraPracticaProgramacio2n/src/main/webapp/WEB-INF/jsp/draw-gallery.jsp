<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>Draw Gallery</title>
    <link rel="stylesheet" href="./css/gallery.css"> 
  </head>
  <body>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Author</th>
          <th>Name</th>
          <th>Figure Number:</th>
          <th>Creation date</th>
          <th>Modification Date</th>
          <th>Actions</th>
        </tr>
      </thead>
      <body>
        <c:forEach items="${draws}" var="draw">
            <tr>
                <td>${draw.drawId}</td>
                <td>${draw.user.username}</td>
                <td>${draw.drawTitle}</td>
                <td>${draw.fig.size()}</td>
                <td>${draw.creationDate}</td>
                <td>${draw.modificationDate}</td>
                <td>
                    <a href="/view-canvas?name=${draw.drawTitle}">View</a>
                    <c:if test="${draw.user.username == username}">
                       <form action="/delete-draw" method="POST" style="display:inline;" onsubmit="return confirm('¿Estás seguro de que deseas eliminar este dibujo?');">
                           <input type="hidden" name="draw" value="${draw.drawId}">
                           <button type="submit">Delete</button>
                       </form>
                         <form action="/edit-canvas" method="POST" style="display:inline;">
                            <input type="hidden" name="draw" value="${draw.drawId}">
                            <button type="submit">Edit</button>
                         </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
      </body>
    </table>
    <form action="/delete-draw" method="POST" style="display:inline;" onsubmit="return confirmDelete();">
        <input type="hidden" name="draw" value="${draw.drawId}">
        <button type="submit">Delete</button>
    </form>
  <button onclick="location.href='/owned-gallery'">
      Mis dibujos:
  </button>
  <button onclick="location.href='/private'">
      Volver al canvas:
  </button>
  </body>
  <script>
      function confirmDelete() {
          return confirm("¿Estás seguro de que deseas eliminar este dibujo?");
      }
  </script>

</html>


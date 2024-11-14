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
          <th>Author</th>
          <th>Name</th>
          <th>Figure Number:</th>
          <th>Creation date</th>
          <th>Modification Date</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${draws}" var="draw">
            <tr>
                <td>${draw.user.username}</td>
                <td>${draw.drawTitle}</td>
                <td>${draw.fig.size()}</td>
                <td>${draw.creationDate}</td>
                <td>${draw.modificationDate}</td>
                <td>
                    <a href="/view-canvas?name=${draw.drawTitle}">View</a>
                    <c:if test="${draw.user.username == username}">
                      <a href="/delete-draw?name=${draw.drawTitle}">Delete</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
      </tbody>
    </table>
  <button onclick="location.href='/owned-gallery'">
      Mis dibujos:
  </button>
  <button onclick="location.href='/private'">
      Volver al canvas:
  </button>
  </body>
</html>


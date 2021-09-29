 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vinyl List</title>
</head>
<body>
<form method="post" action ="navigationServlet">
<table>
<c:forEach items="${requestScope.allVinyl}" var="currentvinyl">
<tr>
<td><input type="radio" name="id" value="${currentvinyl.id}"></td>
<td>${currentvinyl.artist}</td>
<td>${currentvinyl.album}</td>
<td>${currentvinyl.color}</td>
</tr>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToVinyl">
<input type="submit" value="delete" name="doThisToVinyl">
<input type="submit" value="add" name="doThisToVinyl">
</form>
</body>
</html>
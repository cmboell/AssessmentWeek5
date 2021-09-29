<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="editVinylServlet" method="post">
Artist: <input type="text" name="artist" value="${vinylToEdit.artist}">
Album: <input type="text" name="album" value="${vinylToEdit.album}">
Color: <input type="text" name="color" value="${vinylToEdit.color}">
<input type="hidden" name="id" value="${vinylToEdit.id}">
<input type="submit" value="Save Edited Vinyl">
</form>
</body>
</html>
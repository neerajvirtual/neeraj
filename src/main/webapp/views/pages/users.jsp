<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>users page</h1>
<h2>${msg}</h2>

<form action="addStudent" method="post" modelAttribute="Student">
 <fieldset>
  <legend>TestForm:</legend>
  Name: <input name="studentName" type="text"><br>
  Address: <input name="studentAddress.street" type="text"><br>
  <input type="submit" value="submit">
 </fieldset>
</form>

</body>
</html>
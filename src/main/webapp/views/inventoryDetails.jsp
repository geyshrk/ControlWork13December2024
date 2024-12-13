<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="service.SportsService" %>
<%@ page import="model.SportsEquipment" %>

<%
  SportsService service = (SportsService) request.getAttribute("sportsService");
  String id = request.getParameter("id");
  SportsEquipment sportsEquipment = service.getById(Integer.parseInt(id));
%>

<!DOCTYPE html>
<html>
<head>
  <title>Детали инвентаря</title>
</head>
<body>
<h1>Информация о <%= sportsEquipment.getName() %></h1>
<p><strong>Возраст:</strong> <%= sportsEquipment.getAge() %></p>
<p><strong>Параметры:</strong> <%= sportsEquipment.getParameters() %></p>
<p><strong>Условия хранения:</strong> <%= sportsEquipment.getStorageConditions() %></p>
<a href="/start">Назад к списку</a>
</body>
</html>

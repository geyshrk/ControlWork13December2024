<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.SportsEquipment" %>
<%@ page import="service.SportsService" %>

<!DOCTYPE html>
<html>
<head>
  <title>Список спортивных предметов</title>
</head>
<body>
<h1>Список спортивных предметов</h1>
<ul>
  <%
    SportsService service = (SportsService) request.getAttribute("sportsService");
    if (service != null) {
      List<SportsEquipment> list = service.getListSportsEquipment();
      if (list != null && !list.isEmpty()) {
        for (SportsEquipment sportsEquipment : list) {
          String name = sportsEquipment.getName();
          int age = sportsEquipment.getAge();
          int id = sportsEquipment.getId();
  %>
  <li>
    <a href="/details?id=<%= id %>"><%= name %> (Возраст: <%= age %> месяцев)</a>
  </li>
  <%
    }
  } else {
  %>
  <li>Нет доступных спортивных предметов.</li>
  <%
    }
  } else {
  %>
  <li>Сервис недоступен.</li>
  <%
    }
  %>
</ul>
</body>
</html>

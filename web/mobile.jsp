<%-- 
    Document   : mobile
    Created on : Dec 3, 2023, 4:22:00 PM
    Author     : Tony
--%>

<%@page import="dto.Mobile"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mobile Page</title>
    </head>
    <body>
        <h1>Hello staff: <%= request.getSession().getAttribute("userId") %></h1>
        <p style="background-color:red;color:white;display:inline-block">${message}</p>
        <form action="MobileController">
            <input type="text" name="query" />
            <input type="submit" value="search" name="action" /> 
        </form>
        <form action="mobile.jsp">
            <input type="submit" value="Add" name="action" /> 
        </form>
        <%
            String action = request.getParameter("action");
            if (action != null && action.equalsIgnoreCase("Add")) {
        %>
        <form action="MobileController" method="POST">

            Mobile ID: <input type="text" name="mobileId" required />
            Mobile Name: <input type="text" name="mobileName" required />
            Description: <input type="text" name="description" required />
            Price: <input type="number" name="price" required min="0" max="9999" />
            Year of production:<input type="number" name="yearOfProduction" min="2000" max="2050" required />
            Quantity: <input type="number" name="quantity" min="0" max="100" required />
            Not sale? <input type="checkbox" name="notSale" value="true">
            <input type="submit" name="action" value="add" />
        </form>
        <% } %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Mobile ID</th> 
                    <th>Mobile name</th> 
                    <th>Description</th> 
                    <th>Price</th>
                    <th>Year of production</th>
                    <th>Quantity</th>
                    <th>Not sale</th> 
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    List<Mobile> list = (List) request.getAttribute("mobileList");
                    if (list != null) {
                        for (Mobile i : list) {
                            count++;
                %>
            <form action="MobileController" method="POST">
                <tr>
                    <td><%= count %></td>
                    <td><%= i.getMobileId() %></td>
                    <td><%= i.getMobileName() %></td>
                    <td><input type="text" name="description" value="<%= i.getDescription()%>"></td>
                    <td><input type="text" min="0" max="9999" name="price" value="<%= i.getPrice()%>"></td>
                    <td><%= i.getYearOfProduction() %></td>
                    <td><input type="text" name="quantity" min="0" max="100" value="<%= i.getQuantity()%>"></td>
                    <td><input type="text" name="notSale" value="<%= i.getNotSale()%>"></td>
                    <td>
                        <input type="hidden" name="mobileId" value="<%= i.getMobileId()%>">
                        <a href="MobileController?action=delete&mobileId=<%= i.getMobileId()%>">Delete</a>
                    </td>
                    <td>
                        <input type="submit" name="action" value="update">
                    </td>
                </tr>
            </form>
            <%
                    }
                }
            %>
        </tbody>
    </table>
</body>
</html>

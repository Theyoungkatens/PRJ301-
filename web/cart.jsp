<%-- 
    Document   : cart
    Created on : Dec 6, 2023, 4:35:03 PM
    Author     : Tony
--%>

<%@page import="dto.Mobile"%>
<%@page import="dto.Cart"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
    <body>
        <h1>Hello user: <%= request.getSession().getAttribute("userId")%></h1>
        <p style="background-color:red;color:white;display:inline-block">${message}</p>
        <form action="CartController">
            Min price: <input type="number" min="0" max="100" name="minPrice" required />
            Max price: <input type="number" min="0" max="100" name="maxPrice" required />
            <input type="submit" value="search" name="action" /> 
        </form>
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
                    List<Mobile> list = (List) request.getAttribute("mobiles");
                    if (list != null) {
                        for (Mobile i : list) {
                            count++;
                %>
            <form action="CartController" method="POST">
                <tr>
                    <td><%= count%></td>
                    <td><%= i.getMobileId()%></td>
                    <td><%= i.getMobileName()%></td>
                    <td><%= i.getDescription()%></td>
                    <td><%= i.getPrice()%></td>
                    <td><%= i.getYearOfProduction()%></td>
                    <td><%= i.getQuantity()%></td>
                    <td><%= i.getNotSale()%></td>
                    <td>
                        <input type="hidden" name="mobileId" value="<%= i.getMobileId()%>">
                        <input type="submit" name="action" value="addToCart">
                    </td>
                </tr>
            </form>
            <%
                    }
                }
            %>
        </tbody>
    </table>
    <br>
    <h3>Cart</h3>
    <form action="CartController">
        <input type="submit" value="ViewCart" name="action" /> 
    </form>
    <table border="1">
        <thead>
            <tr>
                <th>No</th>
                <th>Mobile ID</th> 
            </tr>
        </thead>
        <tbody>
            <%
                int cartCount = 0;
                List<Cart> carts = (List) request.getAttribute("carts");
                if (carts != null) {
                    for (Cart i : carts) {
                        cartCount++;
            %>
        <form action="MobileController" method="POST">
            <tr>
                <td><%= cartCount%></td>
                <td><%= i.getMobileId()%></td>
                <td>
                    <a href="CartController?action=removeFromCart&cartId=<%= i.getCartId()%>">Delete</a>
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

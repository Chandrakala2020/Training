<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Product List</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Product Bid List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Bidder Name</th>
          <th>Email Id</th>
          <th>Phone Number</th>
          <th>Postal Address</th>
          <th>Product Code</th>
          <th>Bidder Price</th>
          <th>Status</th>
       </tr>
       <c:forEach items="${productBidList}" var="productBid" >
          <tr>
             <td>${productBid.name}</td>
             <td>${productBid.emailId}</td>
             <td>${productBid.phoneNumber}</td>
             <td>${productBid.postalAddress}</td>
             <td>${productBid.productCode}</td>
             <td>${productBid.bidderPrice}</td>
             <td>${productBid.status}</td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="createProduct" >Create Product</a>
    
    <a href="getProductCode">Close Bid</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>
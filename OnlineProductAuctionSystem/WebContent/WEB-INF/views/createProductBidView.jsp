<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Create Product</title>
   </head>
   <body>
    
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
       
      <h3>Create Product Bid</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/createProductBid">
         <table border="0">
            <tr>
               <td>Name</td>
               <td><input type="text" name="name" value="${productBid.name}" /></td>
            </tr>
            <tr>
               <td>Email Id</td>
               <td><input type="text" name="emailId" value="${productBid.emailId}" /></td>
            </tr>
            <tr>
               <td>Phone</td>
               <td><input type="text" name="phoneNumber" value="${productBid.phoneNumber}" /></td>
            </tr>
            <tr>
               <td>PostalAddress</td>
               <td><input type="text" name="postalAddress" value="${productBid.postalAddress}" /></td>
            </tr>
            <tr>
               <td>Product Code</td>
               <td><input type="text" name="productCode" value="${productBid.productCode}" /></td>
            </tr>
            <tr>
               <td>Bid Amount</td>
               <td><input type="text" name="bidderPrice" value="${productBid.bidderPrice}" /></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="productBidList">View Bids</a>
               </td>
            </tr>
         </table>
      </form>
       
      <jsp:include page="_footer.jsp"></jsp:include>
       
   </body>
</html>
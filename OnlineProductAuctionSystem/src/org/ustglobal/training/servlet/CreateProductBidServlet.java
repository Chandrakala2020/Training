package org.ustglobal.training.servlet;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ustglobal.training.beans.Product;
import org.ustglobal.training.beans.ProductBid;
import org.ustglobal.training.utils.DBUtils;
import org.ustglobal.training.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/createProductBid" })
public class CreateProductBidServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public CreateProductBidServlet() {
        super();
    }
 
    // Show product creation page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createProductBidView.jsp");
        dispatcher.forward(request, response);
    }
 
    // When the user enters the product information, and click Submit.
    // This method will be called.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String name = (String) request.getParameter("name");
        String emailId = (String) request.getParameter("emailId");
        String postalAddress = (String) request.getParameter("postalAddress");
        String productCode = (String) request.getParameter("productCode");
        String bidderPrice = (String) request.getParameter("bidderPrice");
        String phoneNumber = (String) request.getParameter("phoneNumber");
        System.out.println(name);
        System.out.println(emailId);
        System.out.println(postalAddress);
        System.out.println(productCode);
        System.out.println(bidderPrice);
//        
        float price = 0;
        try {
            price = Float.parseFloat(bidderPrice);
        } catch (Exception e) {
        }
        ProductBid productBid = new ProductBid(name,emailId,phoneNumber,postalAddress,productCode,
        		price);
 
        String errorString = null;
 
        // Product ID is the string literal [a-zA-Z_0-9]
        // with at least 1 character
//        String regex = "\\w+";
// 
//        if (code == null || !code.matches(regex)) {
//            errorString = "Product Code invalid!";
//        }
 
        if (errorString == null) {
            try {
                DBUtils.insertProductBid(conn, productBid);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", productBid);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/productListView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/Bidder");
        }
    }
 
}
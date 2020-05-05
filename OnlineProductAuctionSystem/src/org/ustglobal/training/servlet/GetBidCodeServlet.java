package org.ustglobal.training.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

@WebServlet(urlPatterns = { "/getProductCode" })
public class GetBidCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetBidCodeServlet() {
		super();
	}

	// Show product edit page.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Forward to /WEB-INF/views/productListView.jsp
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/getProductCodeView.jsp");
		dispatcher.forward(request, response);

	}

	// After the user modifies the product information, and click Submit.
	// This method will be executed.
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		Connection conn = MyUtils.getStoredConnection(request);
//
//		String code = (String) request.getParameter("code");
//		String name = (String) request.getParameter("name");
//		String priceStr = (String) request.getParameter("price");
//		float price = 0;
//		try {
//			price = Float.parseFloat(priceStr);
//		} catch (Exception e) {
//		}
//		Product product = new Product(code, name, price);
//
//		String errorString = null;
//
//		try {
//			DBUtils.updateProduct(conn, product);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			errorString = e.getMessage();
//		}
//		// Store infomation to request attribute, before forward to views.
//		request.setAttribute("errorString", errorString);
//		request.setAttribute("product", product);
//
//		response.sendRedirect(request.getContextPath() + "/productList");
//	}

}
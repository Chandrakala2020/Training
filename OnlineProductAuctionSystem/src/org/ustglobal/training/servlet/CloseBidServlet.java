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

@WebServlet(urlPatterns = { "/closeBid" })
public class CloseBidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CloseBidServlet() {
		super();
	}

	// Show product edit page.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);

		String code = (String) request.getParameter("code");

		List<ProductBid> bidList = null;

		String errorString = null;

		try {
			bidList = DBUtils.getBids(conn, code);
			sortBidList(bidList, conn, code);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// If no error.
		// The product does not exist to edit.
		// Redirect to productList page.
		if (errorString != null && bidList == null) {
			response.sendRedirect(request.getServletPath() + "/productBidList");
			return;
		}

		// Store errorString in request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("productBidList", bidList);

		// Forward to /WEB-INF/views/productListView.jsp
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/productBidListView.jsp");
		dispatcher.forward(request, response);

	}

	private void sortBidList(List<ProductBid> bidList, Connection conn, String code) throws SQLException {
		Collections.sort(bidList, new BidComparter());
		for (int i = 0; i < bidList.size(); i++) {
			if (i == 0) {
				bidList.get(i).setStatus("Accepted");

			} else {
				bidList.get(i).setStatus("Rejected");
			}
			DBUtils.updateProductBid(conn, bidList.get(i));
			DBUtils.updateBidderInProduct(conn, code, bidList.get(i).getName());
		}
	}

	class BidComparter implements Comparator<ProductBid> {
		@Override
		public int compare(ProductBid o1, ProductBid o2) {
			if (o1.getBidderPrice() == o2.getBidderPrice()) {
				return 0;
			} else if (o2.getBidderPrice() > o1.getBidderPrice()) {
				return 1;
			}
			return -1;
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);

		String code = (String) request.getParameter("code");

		List<ProductBid> bidList = null;

		String errorString = null;

		try {
			bidList = DBUtils.getBids(conn, code);
			sortBidList(bidList, conn,code);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// If no error.
		// The product does not exist to edit.
		// Redirect to productList page.
		if (errorString != null && bidList == null) {
			response.sendRedirect(request.getServletPath() + "/productBidList");
			return;
		}

		// Store errorString in request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("productBidList", bidList);

		// Forward to /WEB-INF/views/productListView.jsp
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/productBidListView.jsp");
		dispatcher.forward(request, response);
	}

}
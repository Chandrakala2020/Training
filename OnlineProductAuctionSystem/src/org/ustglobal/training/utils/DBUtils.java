package org.ustglobal.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.ustglobal.training.beans.Product;
import org.ustglobal.training.beans.ProductBid;
import org.ustglobal.training.beans.UserAccount;

public class DBUtils {

	public static UserAccount findUser(Connection conn, //
			String userName, String password) throws SQLException {

		String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a " //
				+ " where a.User_Name = ? and a.password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}

	public static UserAccount findUser(Connection conn, String userName) throws SQLException {

		String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a "//
				+ " where a.User_Name = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("Password");
			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}

	public static List<Product> queryProduct(Connection conn) throws SQLException {
		String sql = "Select a.Code, a.Name, a.Price, a.BidderName from Product a ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			String code = rs.getString("Code");
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			String bidder = rs.getString("BidderName");
			Product product = new Product();
			product.setCode(code);
			product.setName(name);
			product.setPrice(price);
			product.setBidder(bidder);
			if(bidder == null) {
				list.add(product);
			}
		}
		return list;
	}

	public static List<ProductBid> queryProductBids(Connection conn) throws SQLException {
		String sql = "Select a.PRODUCTCODE, a.NAME,a.PRICE,a.MAILID,a.PHONENUMBER,a.POSTALADDRESS,a.STATUS from ProductBid a ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<ProductBid> list = new ArrayList<ProductBid>();
		while (rs.next()) {
			ProductBid productBid = new ProductBid();
			productBid.setBidderPrice(rs.getFloat("PRICE"));
			productBid.setEmailId(rs.getString("MAILID"));
			productBid.setName(rs.getString("NAME"));
			productBid.setPhoneNumber(rs.getString("PHONENUMBER"));
			productBid.setPostalAddress("POSTALADDRESS");
			productBid.setProductCode(rs.getString("PRODUCTCODE"));
			if(rs.getString("STATUS") == null) {
				productBid.setStatus("Open");
			}
			else {
				productBid.setStatus(rs.getString("STATUS"));
			}
			list.add(productBid);
		}
		return list;
	}

	public static Product findProduct(Connection conn, String code) throws SQLException {
		String sql = "Select a.Code, a.Name, a.Price from Product a where a.Code=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, code);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			Product product = new Product(code, name, price);
			return product;
		}
		return null;
	}

	public static List<ProductBid> getBids(Connection conn,String code) throws SQLException {
		String sql = "Select a.PRODUCTCODE, a.NAME,a.PRICE,a.MAILID,a.PHONENUMBER,a.POSTALADDRESS from ProductBid a where a.PRODUCTCODE=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, code);

		ResultSet rs = pstm.executeQuery();
		
		List<ProductBid> list = new ArrayList<ProductBid>();
		while (rs.next()) {
			ProductBid productBid = new ProductBid();
			productBid.setBidderPrice(rs.getFloat("PRICE"));
			productBid.setEmailId(rs.getString("MAILID"));
			productBid.setName(rs.getString("NAME"));
			productBid.setPhoneNumber(rs.getString("PHONENUMBER"));
			productBid.setPostalAddress("POSTALADDRESS");
			productBid.setProductCode(rs.getString("PRODUCTCODE"));
			list.add(productBid);
		}
		return list;
	}
	
	
	public static void updateProduct(Connection conn, Product product) throws SQLException {
		String sql = "Update Product set Name =?, Price=? where Code=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getName());
		pstm.setFloat(2, product.getPrice());
		pstm.setString(3, product.getCode());
		pstm.executeUpdate();
	}

	public static void insertProduct(Connection conn, Product product) throws SQLException {
		String sql = "Insert into Product(Code, Name,Price) values (?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getCode());
		pstm.setString(2, product.getName());
		pstm.setFloat(3, product.getPrice());

		pstm.executeUpdate();
	}

	public static void insertProductBid(Connection conn, ProductBid bid) throws SQLException {
		String sql = "Insert into PRODUCTBID(PRODUCTCODE, NAME,PRICE,MAILID,PHONENUMBER,POSTALADDRESS,STATUS) values (?,?,?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, bid.getProductCode());
		pstm.setString(2, bid.getName());
		pstm.setFloat(3, bid.getBidderPrice());
		pstm.setString(4, bid.getEmailId());
		pstm.setString(5, bid.getPhoneNumber());
		pstm.setString(6, bid.getPostalAddress());
		if (bid.getStatus() == null) {
			pstm.setString(7, "Open");
		} else {
			pstm.setString(7, bid.getStatus());
		}
		pstm.executeUpdate();
	}
	
	public static void updateProductBid(Connection conn, ProductBid bid) throws SQLException {
		String sql = "Update PRODUCTBID set Status=? where PRODUCTCODE=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, bid.getStatus());
		pstm.setString(2, bid.getProductCode());
		pstm.executeUpdate();
	}


	public static void updateBidderInProduct(Connection conn, String code, String bidderName) throws SQLException {
		String sql = "Update Product set BidderName =? where code = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, bidderName);
		pstm.setString(2, code);
		pstm.executeUpdate();
	}

}
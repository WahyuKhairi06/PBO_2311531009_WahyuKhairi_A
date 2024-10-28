package DAO;

import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import Model.OrderDetail;
import config.Database;

public class OrderDetailRepo implements OrderDetailDAO{
	private Connection connection;
	final String insert = "INSERT INTO orderdetail (jenis, quantity, total) VALUES (?,?,?);";
	final String select = "SELECT * FROM orderdetail;";
	final String delete = "DELETE FROM orderdetail WHERE id=?;";
	final String update = "UPDATE orderdetail SET jenis=?, quantity=?, total=? WHERE id=?;";
	
	public OrderDetailRepo() {
		connection = Database.koneksi();
	}
	
	@Override
	public void save(OrderDetail odf) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(insert);
			st.setString(1, odf.getJenis());
			st.setString(2, odf.getQuantity());
			st.setString(3, odf.getTotal());
			st.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public List<OrderDetail> show(){
		List<OrderDetail> ls = null;
		try {
			ls = new ArrayList<OrderDetail>();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(select);
			while(rs.next()) {
				OrderDetail odf = new OrderDetail();
				odf.setId(rs.getString("Id"));
				odf.setJenis(rs.getString("Jenis"));
				odf.setQuantity(rs.getString("Quantity"));
				odf.setTotal(rs.getString("Total"));
				ls.add(odf);
			}
		}catch(SQLException e) {
			Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return ls;
	}

	
	public void update (OrderDetail odf) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(update);
			st.setString(1,  odf.getJenis());;
			st.setString(2,  odf.getQuantity());;
			st.setString(3,  odf.getTotal());;
			st.setString(4,  odf.getId());;
			st.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void delete(String id) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(delete);
					st.setString(1,id);
			st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

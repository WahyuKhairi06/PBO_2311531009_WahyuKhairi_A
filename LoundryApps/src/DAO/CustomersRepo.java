package DAO;

import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import Model.Customers;
import config.DatabaseHelper;
import Model.CustomerBuilder;

public class CustomersRepo implements CustomersDAO{
	private Connection connection;
	final String insert = "INSERT INTO Customers (nama, alamat, hp, email) VALUES (?,?,?,?);";
	final String select = "SELECT * FROM Customers;";
	final String delete = "DELETE FROM Customers WHERE id=?;";
	final String update = "UPDATE Customers SET nama=?, alamat=?, hp=?,email=? WHERE id=?;";
	
	public CustomersRepo() {
		connection = DatabaseHelper.getConnection();
	}
	
	@Override
	public void save(Customers customers) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(insert);
			st.setString(1, customers.getNama());
			st.setString(2, customers.getEmail());
			st.setString(3, customers.getAlamat());
			st.setString(4, customers.getHp());
			st.executeUpdate();
			
		}catch (SQLException e) {
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
	public List<Customers> show() {
	    // TODO Auto-generated method stub
	    List<Customers> ls = null;
	    try {
	        ls = new ArrayList<Customers>();
	        Statement st = connection.createStatement();
	        ResultSet rs = st.executeQuery(select);
	        while (rs.next()) {
	            Customers cs = new CustomerBuilder()
	                    .setId(rs.getString("id"))
	                    .setNama(rs.getString("nama"))
	                    .setEmail(rs.getString("email"))
	                    .setAlamat(rs.getString("alamat"))
	                    .setHp(rs.getString("hp"))
	                    .build();
	            		ls.add(cs);
	        }
	    } catch (SQLException e) {
	        // TODO: handle exception
	        Logger.getLogger(CustomersDAO.class.getName()).log(Level.SEVERE, null, e);
	    }
	    return ls;
	}

	
	public void update (Customers customers) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(update);
			st.setString(1, customers.getNama());  
			st.setString(2, customers.getAlamat()); 
			st.setString(3, customers.getHp());  
			st.setString(4, customers.getEmail());
			st.setString(5, customers.getId());     
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

package DAO;

import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import Model.Service;
import config.Database;

public class ServiceRepo implements ServiceDAO{
	private Connection connection;
	final String insert = "INSERT INTO Service (jenis, harga, satuan, status) VALUES (?,?,?);";
	final String select = "SELECT * FROM Service;";
	final String delete = "DELETE FROM Service WHERE id=?;";
	final String update = "UPDATE Service SET jenis=?, harga=?, status=?, WHERE id=?;";
	
	public ServiceRepo() {
		connection = Database.koneksi();
	}
	
	@Override
	public void save(Service service) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(insert);
			st.setString(1, service.getId());
			st.setString(2, service.getJenis());
			st.setString(3, service.getHarga());
			st.setString(4, service.getStatus());
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
	public List<Service> show(){
		List<Service> ls = null;
		try {
			ls = new ArrayList<Service>();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(select);
			while(rs.next()) {
				Service service = new Service();
				service.setId(rs.getString("Id"));
				service.setHarga(rs.getString("Harga"));
				service.setJenis(rs.getString("Jenis"));
				service.setStatus(rs.getString("Status"));
				ls.add(service);
			}
		}catch(SQLException e) {
			Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return ls;
	}

	public void update (Service service) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(update);
			st.setString(1,  service.getJenis());;
			st.setString(2,  service.getHarga());;
			st.setString(3,  service.getId());;
			st.setString(4,  service.getId());;
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


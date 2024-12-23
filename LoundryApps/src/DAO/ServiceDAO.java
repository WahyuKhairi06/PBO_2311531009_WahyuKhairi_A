package DAO;

import java.util.List;

import Model.Service;

public interface ServiceDAO {
	void save(Service service);
	public List<Service> show();
	public void delete(String id);
	public void update(Service service);
}
package DAO;

import java.util.List;

import Model.Order;

public interface OrderDAO {
	void save(Order cs);
	public List<Order> show();
	public void delete(String id);
	public void update(Order cs);
}
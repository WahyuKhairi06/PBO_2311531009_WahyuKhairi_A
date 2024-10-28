package DAO;

import java.util.List;

import Model.OrderDetail;

public interface OrderDetailDAO {
	void save(OrderDetail odf);
	public List<OrderDetail> show();
	public void delete(String id);
	public void update(OrderDetail odf);
}
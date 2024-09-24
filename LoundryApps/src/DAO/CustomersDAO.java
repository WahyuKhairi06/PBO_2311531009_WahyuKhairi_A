package DAO;

import java.util.List;

import Model.Customers;

public interface CustomersDAO {
	void save(Customers customers);

	public List<Customers> show();

	public void delete(String id);

	public void update(Customers customers);
}
package Table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Model.Customers;

public class TableCustomers extends AbstractTableModel {
	List<Customers> ls;
	private String[] columnNames = {"Id", "Name", "Alamat", "Hp"};
	public TableCustomers(List<Customers> ls) {
		this.ls = ls;
	}
	
	public int getRowCount() {
		return ls.size();
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0:
			return ls.get(rowIndex).getId();
		case 1:
			return ls.get(rowIndex).getNama();
		case 2:
			return ls.get(rowIndex).getAlamat();
		case 3:
			return ls.get(rowIndex).getHp();
		default:
			return null;
		}
	}
}
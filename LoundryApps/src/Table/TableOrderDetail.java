package Table;

import java.util.*;
import javax.swing.table.AbstractTableModel;
import Model.OrderDetail;

public class TableOrderDetail extends AbstractTableModel {
	
	List<OrderDetail> ls_1;
	
	private String[] columnNames = {"ID", "Jenis", "Quantity", "Total"};
	public TableOrderDetail(List<OrderDetail> ls_1) {
		this.ls_1 = ls_1;
	}
	
	public int getRowCount() {
		return ls_1.size();
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
			return ls_1.get(rowIndex).getId();
		case 1:
			return ls_1.get(rowIndex).getJenis();
		case 2:
			return ls_1.get(rowIndex).getQuantity();
		case 3:
			return ls_1.get(rowIndex).getTotal();
		default:
			return null;
		}
	}
}
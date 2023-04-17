package GUI.QLChamCong;

import DTO.ChamCong;

import javax.swing.table.*;

import java.util.ArrayList;

public class ChamCongTableModel extends AbstractTableModel {
    private ArrayList<ChamCong> data;
    private String[] columnNames = {"Mã NV","Họ tên", "Giờ vào", "Giờ ra", "Giờ công", "Xác nhận công"};

    public ChamCongTableModel(ArrayList<ChamCong> data) {
        this.data = data;
    }

    public int getRowCount() {
        return data.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public Object getValueAt(int row, int column) {
        ChamCong chamCong = data.get(row);
        switch (column) {
            case 0:
                return chamCong.getMaNV();
            case 1:
                return chamCong.getHoTen();
            case 2:
                return chamCong.getGioVao();
            case 3:
                return chamCong.getGioRa();
            case 4:
                return chamCong.getGioCong();
            case 5:
                return chamCong.getXacNhanCong();
            default:
                return null;
        }
    }

    public void setValueAt(Object value, int row, int column) {
        ChamCong chamCong = data.get(row);
        switch (column) {
            case 2:
                chamCong.setGioVao((String) value);
                break;
            case 3:
                chamCong.setGioRa((String) value);
                chamCong.calculateGioCong();
                break;
        }
        fireTableCellUpdated(row, column);
    }

    public boolean isCellEditable(int row, int column) {
        if (column == 2)
            return true;
        if  (column == 3 && !getValueAt(row, column-1).equals("")) {
            return true;
        }
        return false;
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    public Class getColumnClass(int column) {
        switch (column) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return String.class;
            default:
                return null;
        }
    }

    public void addRow(ChamCong chamCong) {
        data.add(chamCong);
        int rowIndex = data.size() - 1;
        fireTableRowsInserted(rowIndex, rowIndex);
    }

    public void removeRow(int rowIndex) {
        data.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    public void updateRow(int rowIndex, ChamCong chamCong) {
        data.set(rowIndex, chamCong);
        fireTableRowsUpdated(rowIndex, rowIndex);
    }
}

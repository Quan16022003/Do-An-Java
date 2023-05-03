package GUI.QLLuong;

import DTO.Luong;

import javax.swing.table.AbstractTableModel;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class LuongTableModel extends AbstractTableModel {
//    private final String[] columnNames = {"Mã NV", "Tên NV", "Đơn vị", "Chức vụ", "Lương CB(kVND)", "Hs lương", "Ngày công QĐ", "Ngày công TT",
//                                            "Lương hưởng(kVND)", "Hs chức vụ", "Tỷ lệ PC(%)", "Mức PC(kVND)", "Đóng BH(kVND)", "Thực lĩnh(kVND)"};
    private final String[] columnNames = {"Mã NV", "Tên NV", "Ngày công QĐ", "Ngày công TT", "Hs Lương", "Lương hưởng","Mức PC", "Mức đóng BH", "Thực lĩnh"};
    private List<Luong> data;

    LuongTableModel(List<Luong> data) {
        this.data = data;
    }
    public int getRowCount() {
        return data.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (data.size() == 0) {
            return "No data available";
        }
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        Luong luong = data.get(rowIndex);
        switch (columnIndex) {
            case 0: return luong.getMaNV();
            case 1: return luong.getTenNV();
            case 2: return luong.getNgayCongQD();
            case 3: return luong.getNgayCongTT();
            case 4: return luong.getHsLuong();
            case 5: return formatter.format(luong.getLuongHuong());
            case 6: return formatter.format(luong.getMucPC());
            case 7: return formatter.format(luong.getMucBH());
            case 8: return formatter.format(luong.getThucLinh());
            default: return null;
        }
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    public Class getColumnClass(int column) {
        return super.getColumnClass(column);
    }
}

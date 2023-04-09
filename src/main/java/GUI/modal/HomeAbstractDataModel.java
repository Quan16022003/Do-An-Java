/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GUI.modal;

import DTO.GiaoVien;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author apple
 */
public class HomeAbstractDataModel extends AbstractTableModel{
    
    private String[] cols = {"Mã giáo viên ", "Tên giáo viên ", "Ngày sinh", "Môn học giảng"};

    private ArrayList<Object[]> rows = new ArrayList<>();

    public ArrayList<Object[]> getRows() {
        return rows;
    }
    
    public void add(List<GiaoVien> giaoviens) {
        rows.clear();
        for (GiaoVien giaovien : giaoviens) {
            
            rows.add(new Object[]{
                
               giaovien.getMaGV(), giaovien.getHoTen(), giaovien.getNgaySinh(), giaovien.getMonHoc(),
               giaovien.getGioiTinh(), giaovien.getNoiSinh(), giaovien.getQueQuan(), giaovien.getDiaChi(),
               giaovien.getNoiO(), giaovien.getCCCD(), giaovien.getSoDienThoai(),
               giaovien.getEmail(), giaovien.getToChuyenMon()
            
            });
        }
        fireTableDataChanged();
    }
    

    public void setRows(ArrayList<Object[]> rows) {
        this.rows = rows;
    }
    
    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }
    


    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex)[columnIndex];
    }
    
}
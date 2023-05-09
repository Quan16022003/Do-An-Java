/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GUI.Model;

import DTO.HopDong;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author apple
 */
public class HomeAbstractDataModel_for_Hop_Dong extends AbstractTableModel{
    
    private String[] cols = {"Mã giáo viên ", "Tên giáo viên ", "Ngày sinh", "Môn học giảng"};

    private ArrayList<Object[]> rows = new ArrayList<>();

    public ArrayList<Object[]> getRows() {
        return rows;
    }
    
    public void add(List<HopDong> hopdongs) {
        rows.clear();
        for (HopDong hd : hopdongs) {
            
            rows.add(new Object[]{
                
               hd.getMaHD(),hd.getMaLoaiHD(),hd.getMaNV(),hd.getTenHD(), 
                hd.getNgayKy(), hd.getHanHD(), hd.getHocVi(), hd.getHang(),
                hd.getBac(),hd.getMaSoThue(),hd.getCucThue(),hd.getSTK(),
                hd.getNganHang(), hd.getSoTietGiangDay()
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
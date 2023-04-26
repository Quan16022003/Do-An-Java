/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GUI.modal;

import DTO.Nhan_Vien;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author apple
 */
public class HomeAbstractDataModel_for_Nhan_Vien extends AbstractTableModel{
    
    private String[] cols = {"Mã nhân viên", "Mã đơn vị", "Mã Chức Vụ", "Số điện thoại"};

    private ArrayList<Object[]> rows = new ArrayList<>();

    public ArrayList<Object[]> getRows() {
        return rows;
    }
    
    public void add(List<Nhan_Vien> nhanviens) {
        rows.clear();
        for (Nhan_Vien nv : nhanviens) {
            
            rows.add(new Object[]{
                
               nv.getMaNV(),nv.getMaDV(),nv.getMaLoaiNV(),nv.getMaChucVu(),
                nv.getTen(),nv.getGioiTinh(),nv.getNgSinh(),nv.getSDT(),nv.getSoNha(),nv.getDuong(),
                nv.getPhuong_Xa(),nv.getPhuong_Xa(),nv.getQuan_Huyen(),nv.getTP_Tinh(),nv.getCCCD(),
                nv.getNgCap(),nv.getNoiCap(),nv.getNgVaoLam()            
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

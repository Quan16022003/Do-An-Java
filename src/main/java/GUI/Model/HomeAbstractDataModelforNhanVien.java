/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GUI.Model;

import DTO.NhanVien;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author apple
 */
public class HomeAbstractDataModelforNhanVien extends AbstractTableModel{

    private String[] cols = {"Mã nhân viên", "Mã đơn vị", "Mã Chức Vụ", "Số điện thoại"};

    private List<Object[]> rows = new ArrayList<>();

    public List<Object[]> getRows() {
        return rows;
    }

    public void add(ArrayList<NhanVien> nhanviens) {
        rows.clear();
        for (NhanVien nv : nhanviens) {

            rows.add(new Object[]{

                    nv.getMaNV(),nv.getMaDV(),nv.getMaChucVu(),nv.getSDT()
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

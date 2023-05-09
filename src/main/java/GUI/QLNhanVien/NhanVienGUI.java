/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.QLNhanVien;

import BLL.Report_Excel.InDanhSachPDF;
import DAL.NhanVienDAO;
import BLL.Report_Excel.WriteExcelNhanVien;
import DTO.NhanVien;
import GUI.Model.Content;
import GUI.Model.HomeAbstractDataModelforNhanVien;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;

/**
 *
 * @author apple
 */
public class NhanVienGUI extends Content {
    
    private List<NhanVien> NhanViens;
    private HomeAbstractDataModelforNhanVien tblModel;
    private int selectedIndex;
    private JTable table;
    private NhanVienDAO Dao;
    
    public NhanVienGUI() {
        initComponents();
//        this.setLocationRelativeTo(null);
        NhanViens = new ArrayList<>();   
        table = new JTable(tblModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 //       this.setTitle("Trang chủ");
 //       loadDataFromFile("SV.txt");
        showData();
    }
    
     private void showData() {
//        tblModel.setRowCount(0); // reset nd trong bang ve 0
        Dao = new NhanVienDAO();
        NhanViens = Dao.selectAll();
        tblModel.add((ArrayList<NhanVien>) NhanViens);
    }
    
    public void addNhanVienlist(NhanVien s) {
        NhanViens.add(s); //them moi sv vao danh sach
        showData();
    }
    
    public void removeNhanVienlist(NhanVien s) {
        NhanViens.remove(s); //them moi sv vao danh sach
        showData();
    }
    
    private void initComponents() {
        BorderLayout layout = new BorderLayout();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        tblResult.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExportE = new javax.swing.JButton();
        btnExportP = new javax.swing.JButton();
        table = new JTable(tblModel);
        tblResult.setPreferredSize(new Dimension(400,400));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("DANH SÁCH NHÂN VIÊN");
        jLabel1.setFont(new Font("Segoe UI", 0, 25));
        
         tblModel = new HomeAbstractDataModelforNhanVien();
        tblResult.setModel(tblModel);
        jScrollPane1.setViewportView(tblResult);

        btnAdd.setText("Thêm mới");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNhanVienlistActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        
        btnDelete.setText("Xoá");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        btnExportE.setText("Xuất Excel");
        btnExportE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportEActionPerformed(evt);
            }
        });
        btnExportP.setText("Xuất PDF");
        btnExportP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportPActionPerformed(evt);
            }
        });
        
        setLayout(layout);
            JPanel titlePanel = new JPanel();
            titlePanel.add(jLabel1);
            
//            JPanel tablePanel = new JPanel();
//            tablePanel.setBackground(Color.red);
//            tablePanel.add(jScrollPane1);
            
            JPanel ButtonPanel = new JPanel();
            ButtonPanel.add(btnAdd);
            ButtonPanel.add(btnEdit);
            ButtonPanel.add(btnDelete);
            ButtonPanel.add(btnExportE);
            ButtonPanel.add(btnExportP);
            JPanel gapPanel1 = new JPanel();
            gapPanel1.setPreferredSize(new Dimension(10,0));
            JPanel gapPanel2 = new JPanel();
            gapPanel2.setPreferredSize(new Dimension(10,0));
            
            this.add(titlePanel,BorderLayout.PAGE_START);
            this.add(gapPanel1,BorderLayout.EAST);
            this.add(jScrollPane1,BorderLayout.CENTER);
            this.add(gapPanel2,BorderLayout.WEST);
            this.add(ButtonPanel,BorderLayout.PAGE_END);
            }
    
    
    
    
    
    
    
    private void btnAddNhanVienlistActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        InputNhanVien inputnv = new InputNhanVien(this);
        inputnv.setVisible(true);
        
    } 
    
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {                                        
        selectedIndex = tblResult.getSelectedRow();
        if(NhanViens.size() == 0) {
            JOptionPane.showMessageDialog( null,
                    "Hãy nhập thêm nhân viên rồi sửa!");
        } else if(selectedIndex == -1) {
            JOptionPane.showMessageDialog(null, 
                    "Hãy chọn dòng có nhân viên cần sửa rồi ấn Sửa!");
        } else { // chon dong can sua va nhan nut
            EditNhanVien edit = new EditNhanVien(this);
            edit.setEditData(NhanViens.get(selectedIndex));
            edit.setVisible(true);
        }
    }
      private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                        
        selectedIndex = tblResult.getSelectedRow();
        if(NhanViens.size() == 0) {
            JOptionPane.showMessageDialog( null,
                    "Hãy nhập thêm nhân viên rồi xoá!");
        } else if(selectedIndex == -1) {
            JOptionPane.showMessageDialog(null, 
                    "Hãy chọn dòng có giáo viên cần sửa rồi ấn Xoá!");
        } else  
        { // chon dong can sua va nhan nut
            int key = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá nhân viên này?","Màng hình xoá",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (key == JOptionPane.YES_OPTION){
                    NhanViens.remove(selectedIndex);
                    //EditNhanVien edit = new EditNhanVien(this);
                }
        }
        showData();
    }
      private void btnExportEActionPerformed(java.awt.event.ActionEvent evt){
          WriteExcelNhanVien demo = new WriteExcelNhanVien();
          demo.export();
      }
      private void btnExportPActionPerformed(java.awt.event.ActionEvent evt){
          InDanhSachPDF pdf = new InDanhSachPDF();
          pdf.renderPDF(NhanViens);
      }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVienGUI().setVisible(true);
            }
        });
    }
    
    
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExportE;
    private javax.swing.JButton btnExportP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResult;
    // End of variables declaration                   

    public void updateNhanVienlist(NhanVien s) {
        NhanViens.remove(selectedIndex);
        this.addNhanVienlist(s);
    }
}

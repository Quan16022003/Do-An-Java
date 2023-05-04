/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DAL.HopDongDAO;
import DAL.WriteExcelHopDong;
import DTO.HopDong;
import GUI.modal.Content;
import GUI.modal.HomeAbstractDataModel_for_Hop_Dong;
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
public class HopDongGUI extends Content {
    
    private List<HopDong> HopDongs;
    private HomeAbstractDataModel_for_Hop_Dong tblModel;
    private int selectedIndex;
    private JTable table;
    private HopDongDAO Dao;
    
    public HopDongGUI() {
        initComponents();
//        this.setLocationRelativeTo(null);
        HopDongs = new ArrayList<>();           
        table = new JTable(tblModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 //       this.setTitle("Trang chủ");
 //       loadDataFromFile("SV.txt");
    }
    
     private void showData() {
//        tblModel.setRowCount(0); // reset nd trong bang ve 0
        tblModel.add(HopDongs);
    }
    
    public void addNhanVienlist(HopDong s) {
        HopDongs.add(s); //them moi sv vao danh sach
        showData();
    }
    
    public void removeNhanVienlist(HopDong s) {
        HopDongs.remove(s); //them moi sv vao danh sach
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
        table = new JTable(tblModel);
        tblResult.setPreferredSize(new Dimension(400,400));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("DANH SÁCH HỢP ĐỒNG");
        jLabel1.setFont(new Font("Segoe UI", 0, 25));
         tblModel = new HomeAbstractDataModel_for_Hop_Dong();
        tblResult.setModel(tblModel);
        jScrollPane1.setViewportView(tblResult);

        btnAdd.setText("Thêm mới");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHopDonglistActionPerformed(evt);
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
    
    
    
    
    
    
    
    private void btnAddHopDonglistActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        InputHopDong inputnv = new InputHopDong(this);
        inputnv.setVisible(true);
        
    } 
    
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {                                        
        selectedIndex = tblResult.getSelectedRow();
        if(HopDongs.size() == 0) {
            JOptionPane.showMessageDialog( null,
                    "Hãy nhập thêm giáo viên rồi sửa!");
        } else if(selectedIndex == -1) {
            JOptionPane.showMessageDialog(null, 
                    "Hãy chọn dòng có giáo viên cần sửa rồi ấn Sửa!");
        } else { // chon dong can sua va nhan nut
            EditHopDong edit = new EditHopDong(this);
            edit.setEditData(HopDongs.get(selectedIndex));
            edit.setVisible(true);
        }
    }
      private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                        
        selectedIndex = tblResult.getSelectedRow();
        if(HopDongs.size() == 0) {
            JOptionPane.showMessageDialog( null,
                    "Woah woah! Something went very wrong with you !");
        } else if(selectedIndex == -1) {
            JOptionPane.showMessageDialog(null, 
                    "Hãy chọn dòng có giáo viên cần sửa rồi ấn Xoá !");
        } else  
        { // chon dong can sua va nhan nut
            int key = JOptionPane.showConfirmDialog(null, "You about to do something","Are you sure?",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (key == JOptionPane.YES_OPTION){
                    HopDongs.remove(selectedIndex);
                    //EditNhanVien edit = new EditNhanVien(this);
                }
        }
        showData();
    }
      private void btnExportActionPerformed(java.awt.event.ActionEvent evt){
          WriteExcelHopDong demo = new WriteExcelHopDong();
          demo.export();
      }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HopDongGUI().setVisible(true);
            }
        });
    }
    
    
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResult;
    // End of variables declaration                   

    public void updateNhanVienlist(HopDong s) {
        HopDongs.remove(selectedIndex);
        this.addNhanVienlist(s);
    }
}

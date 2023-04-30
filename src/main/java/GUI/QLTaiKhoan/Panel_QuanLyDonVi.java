/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.QLTaiKhoan;

import BLL.DVbus;
import BLL.NVDVbus;
import DAL.NVdao_updateNVDV_Pass;
import DTO.DonViDTO;
import DTO.NhanVienDTO_u_nvdv_pass;
import DTO.NhanVienDonViDTO;
import GUI.Model.Content;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ADMIN
 */
public class Panel_QuanLyDonVi extends Content {

    /**
     * Creates new form Panel_QuanLyDonVi
     */
    private JOptionPane opdv;
    private JButton bt_dsdv_xem = new JButton("-");
    private JButton bt_nvdv_capnhatdsnv = new JButton("Cập nhật nhân viên mới");
    private JLabel lbdanhsach = new JLabel("Danh sách");
    private JFrame ChuyenDonVi = new JFrame("Chuyển đơn vị");

    private DVbus dvbus = new DVbus();
    private NVDVbus nvdvbus = new NVDVbus();
    private String[] headerdv = new String[]{
        "Mã đơn vị", "Tên đơn vị"
    };
    private DefaultTableModel modeldv = new DefaultTableModel(headerdv, 0);

    private String[] headernvdv = new String[]{
        "Mã nhân viên", "Tên nhân viên", "Mã đơn vị", "Tên đơn vị"
    };
    private DefaultTableModel modelnvdv = new DefaultTableModel(headernvdv, 0);

    public Panel_QuanLyDonVi() {
        initComponents();
        initC2();
    }

    public NhanVienDonViDTO getSelectedRowData_NVDV(JTable table, TableModel model) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            NhanVienDonViDTO te = new NhanVienDonViDTO();
            te.setmanv((String) model.getValueAt(selectedRow, 0));
            te.setten((String) model.getValueAt(selectedRow, 1));
            te.setmadonvi((String) model.getValueAt(selectedRow, 2));
            te.settendonvi((String) model.getValueAt(selectedRow, 3));
            return te;
        } else {
            return null;
        }
    }

    public DonViDTO getSelectedRowData_DV(JTable table, TableModel model) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            DonViDTO te = new DonViDTO();
            te.setmadv((String) model.getValueAt(selectedRow, 0));
            te.setten((String) model.getValueAt(selectedRow, 1));
            return te;
        } else {
            return null;
        }
    }

    public void fthemdvmoi() {
        JFrame frthemDV = new JFrame("Thêm đơn vị mới");
        frthemDV.setLayout(new GridLayout(1, 1));
        frthemDV.setBounds(100, 140, 600, 480);

        add_cbr1.setSelected(false);
        add_cbr2.setSelected(false);
        add_cbr3.setSelected(false);
        add_cbr4.setSelected(false);
        add_cbr5.setSelected(false);
        add_cbr1.setVisible(true);
        add_cbr2.setVisible(true);
        add_cbr3.setVisible(true);
        add_cbr4.setVisible(true);
        add_cbr5.setVisible(true);

        //
        ActionListener[] listenersz = bt_thuchienthemdv.getActionListeners();
        for (ActionListener listener1 : listenersz) {
            bt_thuchienthemdv.removeActionListener(listener1);
        }

        bt_thuchienthemdv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click thuc hien them don vi moi");
                String newname = tf_them_tendvmoi.getText();
                newname = newname.trim();
                if (check_Val.isNNameDV(newname)) {
                    dvbus = new DVbus();
                    // kiểm tra có trùng tên mới không
                    boolean cname = true;
                    for (DonViDTO ex1 : dvbus.getList()) {
                        if (check_Val.ss2DV(ex1.getten(), newname)) {
                            cname = false;
                            break;
                        }
                    }

                    if (cname == false) {
                        JOptionPane tb = new JOptionPane();
                        tb.showMessageDialog(pn_uthemDVmoi, "Tên đơn vị mới đã tồn tại, mời nhập lại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        tf_them_tendvmoi.setText("");
                    } else if (newname.length() > 24) {
                        JOptionPane tb = new JOptionPane();
                        tb.showMessageDialog(pn_uthemDVmoi, "Tên đơn vị không được dài quá 24 kí tự, mời nhập lại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        tf_them_tendvmoi.setText("");

                    } else {

                        dvbus = new DVbus();

                        String a_role = check_Val.toRole(add_cbr1.isSelected(), add_cbr2.isSelected(), add_cbr3.isSelected(), add_cbr4.isSelected(), add_cbr5.isSelected());
                        System.out.println("Role Them dv moi : " + a_role + "|ten dv moi : " + newname);
                        dvbus.add(new DonViDTO("0", newname, a_role));

                        JOptionPane tb = new JOptionPane();
                        tb.showMessageDialog(pn_themdvmoi, "Đã thêm của đơn vị mới", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        tf_tendonvimoi_them.setText("");
                        pn_uthemDVmoi.setVisible(false);
                        frthemDV.dispose();
                        updateDV();

                    }

                } else {
                    JOptionPane tb = new JOptionPane();
                    tb.showMessageDialog(pn_uthemDVmoi, "Tên đơn vị mới không hợp lệ, mời nhập lại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    tf_them_tendvmoi.setText("");
                }
                tb_dv.clearSelection();
            }
        });

        //
        ActionListener[] l6 = bt_themdvmoi_huythaotac.getActionListeners();
        for (ActionListener listener1 : l6) {
            bt_themdvmoi_huythaotac.removeActionListener(listener1);
        }
        //

        bt_themdvmoi_huythaotac.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click thoat bang them don vi moi");
                pn_uthemDVmoi.setVisible(false);
                frthemDV.dispose();
                updateDV();
            }
        });

        tf_them_tendvmoi.setText("");

        frthemDV.add(pn_uthemDVmoi);
        pn_uthemDVmoi.setVisible(true);
        frthemDV.setVisible(true);

    }

    public void fdoitendv(DonViDTO idv) {
        JFrame frdoitenDV = new JFrame("Đổi tên đơn vị, thay đổi quyền đơn vị");
        frdoitenDV.setLayout(new GridLayout(1, 1));
        frdoitenDV.setBounds(100, 140, 640, 560);

        //
        String oo = idv.getten();
        lb_change_showdv.setText(oo);
        tf_change_tenmoi.setText("");

        //
        cb_r1.setSelected(false);
        cb_r2.setSelected(false);
        cb_r3.setSelected(false);
        cb_r4.setSelected(false);
        cb_r5.setSelected(false);

        dvbus = new DVbus();
        for (DonViDTO j2 : dvbus.getList()) {
            if (j2.getmadv().equals(idv.getmadv())) {
                String grole = "";
                grole = j2.gettrole();
                cb_r1.setSelected(check_Val.isR1(grole));
                cb_r2.setSelected(check_Val.isR2(grole));
                cb_r3.setSelected(check_Val.isR3(grole));
                cb_r4.setSelected(check_Val.isR4(grole));
                cb_r5.setSelected(check_Val.isR5(grole));
                break;
            }
        }

        cb_r1.setVisible(true);
        cb_r2.setVisible(true);
        cb_r3.setVisible(true);
        cb_r4.setVisible(true);
        cb_r5.setVisible(true);

        ActionListener[] listeners = bt_doitendv.getActionListeners();
        for (ActionListener listener : listeners) {
            bt_doitendv.removeActionListener(listener);
        }
        //
        bt_doitendv.addActionListener((ActionEvent e) -> {

            System.out.println("Click button thuc hien doi ten don vi");
            String newname = tf_change_tenmoi.getText();
            newname = newname.trim();
            if (check_Val.isNNameDV(newname)) {

                // kiểm tra có trùng tên không
                boolean cname = true;
                for (DonViDTO ex1 : dvbus.getList()) {
                    if (check_Val.ss2DV(ex1.getten(), newname)) {
                        cname = false;
                        break;
                    }
                }

                if (cname == false) {
                    JOptionPane tb = new JOptionPane();
                    tb.showMessageDialog(pn_doitendv, "Tên đơn vị mới đã tồn tại, mời nhập lại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    tf_change_tenmoi.setText("");
                } else if (newname.length() > 24) {
                    JOptionPane tb = new JOptionPane();
                    tb.showMessageDialog(pn_doitendv, "Tên đơn vị mới không được quá 24 kí tự, mời nhập lại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    tf_change_tenmoi.setText("");

                } else {
                    nvdvbus = new NVDVbus();
                    for (NhanVienDonViDTO ex2 : nvdvbus.getList()) {
                        if (ex2.getmadonvi().equals(idv.getmadv())) {
                            NhanVienDonViDTO cv = ex2;
                            cv.settendonvi(newname);
                            // cap nhat ten dv cua nhan vien
                            nvdvbus.set(cv);
                        }
                    }// cap nhat lai ten don vi moi cua nhan vien thuoc don vi cu

                    dvbus = new DVbus();
                    idv.setten(newname);
                    // chỗ này lấy thông tin role để cập nhật lại
                    String a_role = check_Val.toRole(cb_r1.isSelected(), cb_r2.isSelected(), cb_r3.isSelected(), cb_r4.isSelected(), cb_r5.isSelected());
                    System.out.println("Role add : " + a_role);
                    idv.setrole(a_role);

                    dvbus.set(idv);

                    JOptionPane tb = new JOptionPane();
                    tb.showMessageDialog(pn_doitendv, "Đã thay đổi thông tin của đơn vị", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    tf_change_tenmoi.setText("");

                    pn_doitendv.setVisible(false);
                    frdoitenDV.dispose();
                    updateDV();
                }

            } else if (newname.isEmpty() == true) {
                String a_role = check_Val.toRole(cb_r1.isSelected(), cb_r2.isSelected(), cb_r3.isSelected(), cb_r4.isSelected(), cb_r5.isSelected());
                idv.setrole(a_role);
                dvbus.set(idv);
                JOptionPane zz = new JOptionPane();
                zz.showMessageDialog(pn_doitendv, "Đã thay đổi thông tin quyền của đơn vị", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                tf_change_tenmoi.setText("");

                pn_doitendv.setVisible(false);
                frdoitenDV.dispose();
                updateDV();
            } else {
                System.out.println("New name don vi thay doi - " + newname);

                JOptionPane tb = new JOptionPane();
                tb.showMessageDialog(pn_doitendv, "Tên đơn vị mới không hợp lệ, mời nhập lại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                tf_change_tenmoi.setText("");

            }

        });
        //
        ActionListener[] listeners1 = bt_doitendv_huythaotac.getActionListeners();
        for (ActionListener listener1 : listeners) {
            bt_doitendv_huythaotac.removeActionListener(listener1);
        }
        // huy thao tac doi ten don vi
        bt_doitendv_huythaotac.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click vao button huy thao tac doi ten don vi!");
                pn_doitendv.setVisible(false);
                frdoitenDV.dispose();
            }
        });

        //
        frdoitenDV.add(pn_doitendv);
        pn_doitendv.setVisible(true);
        frdoitenDV.setVisible(true);

    }

    public static boolean isTString(String input) {
        return input != null && input.matches("^[\\p{L}0-9\\s]*[\\p{L}0-9][\\p{L}0-9\\s]*$");
    }

    public void updateNVDV() {
        if (cbb_dsdv.getSelectedIndex() == 0) {
            modelnvdv.setRowCount(0);
            Vector data;

            for (NhanVienDonViDTO j : nvdvbus.getList()) {

                if (!"0".equals(j.gettendonvi()) && !"0".equals(j.getmadonvi())) {
                    data = new Vector();
                    data.add(j.getmanv());
                    data.add(j.getten());
                    data.add(j.getmadonvi());
                    data.add(j.gettendonvi());
                    modelnvdv.addRow(data);
                }

            }

            tb_nvtdv = new JTable(modelnvdv) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            tb_nvtdv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            tb_nvtdv
                    .setDefaultRenderer(Object.class,
                            centerRenderer);

            sp_nvtdv.add(tb_nvtdv);
            sp_nvtdv.setViewportView(tb_nvtdv);

            C2_c1pncenter_bot.add(sp_nvtdv, BorderLayout.CENTER);
            sp_nvtdv.setVisible(true);
            lb_soluongp.setText("Số lượng nhân viên: " + tb_nvtdv.getRowCount());

            C2_c1pncenter_bot.revalidate();
            C2_c1pncenter_bot.repaint();

        } else if (cbb_dsdv.getSelectedIndex() == 1) {
            modelnvdv.setRowCount(0);
            Vector data;

            for (NhanVienDonViDTO j : nvdvbus.getList()) {

                if ("0".equals(j.gettendonvi()) && "0".equals(j.getmadonvi())) {
                    data = new Vector();
                    data.add(j.getmanv());
                    data.add(j.getten());
                    data.add(j.getmadonvi());
                    data.add(j.gettendonvi());
                    modelnvdv.addRow(data);
                }

            }

            tb_nvtdv = new JTable(modelnvdv) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            tb_nvtdv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            tb_nvtdv
                    .setDefaultRenderer(Object.class,
                            centerRenderer);

            sp_nvtdv.add(tb_nvtdv);
            sp_nvtdv.setViewportView(tb_nvtdv);

            C2_c1pncenter_bot.add(sp_nvtdv, BorderLayout.CENTER);
            sp_nvtdv.setVisible(true);
            lb_soluongp.setText("Số lượng nhân viên: " + tb_nvtdv.getRowCount());

            C2_c1pncenter_bot.revalidate();
            C2_c1pncenter_bot.repaint();

        } else {
            modelnvdv.setRowCount(0);
            Vector data;
            String iString = (String) cbb_dsdv.getSelectedItem();
            String rsSring = iString.substring(0, 0) + iString.substring(0 + 17);

            for (NhanVienDonViDTO j : nvdvbus.getList()) {

                if (j.gettendonvi().equals(rsSring)) {
                    data = new Vector();
                    data.add(j.getmanv());
                    data.add(j.getten());
                    data.add(j.getmadonvi());
                    data.add(j.gettendonvi());
                    modelnvdv.addRow(data);
                }

            }

            tb_nvtdv = new JTable(modelnvdv) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            tb_nvtdv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            tb_nvtdv
                    .setDefaultRenderer(Object.class,
                            centerRenderer);

            sp_nvtdv.add(tb_nvtdv);
            sp_nvtdv.setViewportView(tb_nvtdv);

            C2_c1pncenter_bot.add(sp_nvtdv, BorderLayout.CENTER);
            sp_nvtdv.setVisible(true);
            lb_soluongp.setText("Số lượng nhân viên: " + tb_nvtdv.getRowCount());

            C2_c1pncenter_bot.revalidate();
            C2_c1pncenter_bot.repaint();

        }
        tb_nvtdv.clearSelection();
        System.out.println("---");
        System.out.println("Cap nhat lai bang nhan vien don vi va xoa lua chon");
        System.out.println("---");
    }

    public void updateDV() {
        listdv();// lay data de tao model
        tb_dv = new JTable(modeldv) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tb_dv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tb_dv
                .setDefaultRenderer(Object.class,
                        centerRenderer);

        sp_dv.add(tb_dv);
        sp_dv.setViewportView(tb_dv);

        C2_c1pncenter_bot.add(sp_dv, BorderLayout.CENTER);
        sp_dv.setVisible(true);
        lb_soluongp.setText("Số lượng đơn vị: " + tb_dv.getRowCount());
        C2_c1pncenter_bot.revalidate();
        C2_c1pncenter_bot.repaint();
        tb_dv.clearSelection();
    }

    public void initC2() {

        //xu ly click them don vi
        bt_dv_them.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click vao button mo bang them don vi moi");
                if (!pn_themdvmoi.isShowing()) {
                    fthemdvmoi();
                }

            }
        });

        //
        // ------
        //xu ly click cap nhat ten moi_quyen cho don vi
        bt_dv_capnhat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click vao button mo bang doi ten don vi");
                if (getSelectedRowData_DV(tb_dv, modeldv) != null) {
                    System.out.println("Don vi dang chon: " + getSelectedRowData_DV(tb_dv, modeldv).toString());
                    DonViDTO dvdoiten = getSelectedRowData_DV(tb_dv, modeldv);
                    if (!pn_doitendv.isShowing()) {
                        if ("admin".equals(dvdoiten.getten())) {
                            JOptionPane tb = new JOptionPane();
                            tb.showMessageDialog(pn_doitendv, "Không thể đổi thông tin đơn vị quản trị hệ thống!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            fdoitendv(dvdoiten);
                        }

                    }

                    updateDV();
                } else {
                    if (tb_dv.getRowCount() > 0 && (!pn_doitendv.isShowing())) {
                        JOptionPane tb = new JOptionPane();
                        tb.showMessageDialog(pn_content, "Vui lòng chọn đơn vị muốn thay đổi tên, quyền ở bảng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }
        });

        //
        // ------
        //xu ly click xoa don vi dang chon
        bt_dv_xoa.addActionListener(e -> {
            System.out.println("Click button xoa don vi");
            if (getSelectedRowData_DV(tb_dv, modeldv) != null) {
                System.out.println("Don vi dang chon: " + getSelectedRowData_DV(tb_dv, modeldv).toString());
                DonViDTO tempa = getSelectedRowData_DV(tb_dv, modeldv);
                if ("admin".equals(tempa.getten())) {
                    JOptionPane tb = new JOptionPane();
                    tb.showMessageDialog(this, "Không cho phép xóa đơn vị quản trị hệ thống.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    updateDV();
                } else {
                    nvdvbus = new NVDVbus();
                    for (NhanVienDonViDTO t : nvdvbus.getList()) {
                        if (t.getmadonvi().equals(tempa.getmadv())) {

                            NhanVienDonViDTO p = new NhanVienDonViDTO(t.getmanv(), t.getten(), "0", "0");
                            nvdvbus.set(p);
                        }
                    }
                    dvbus = new DVbus();
                    dvbus.delete(tempa.getmadv());
                    JOptionPane tb = new JOptionPane();
                    tb.showMessageDialog(this, "Xóa thành công đơn vị " + tempa.getten(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    updateDV();
                }
            } else {
                if (tb_dv.getRowCount() > 0) {
                    JOptionPane tb = new JOptionPane();
                    tb.showMessageDialog(this, "Vui lòng chọn đơn vị muốn giải tán ở bảng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });
        //

        // ------
        //xu ly click cap nhat danh sach nhan vien
        bt_nvdv_capnhatdsnv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click cap nhat danh sach nhan vien");
                nvdvbus = new NVDVbus();
                ArrayList<NhanVienDonViDTO> t1 = nvdvbus.getList();

                ArrayList<NhanVienDTO_u_nvdv_pass> t2 = new ArrayList();// ds nhan vien hien tai

                for (NhanVienDonViDTO ir : t1) {
                    NhanVienDTO_u_nvdv_pass temp6 = new NhanVienDTO_u_nvdv_pass(ir.getmanv(), ir.getten());
                    t2.add(temp6);
                }

                //     
                NVdao_updateNVDV_Pass nvdaou = new NVdao_updateNVDV_Pass();
                ArrayList<NhanVienDTO_u_nvdv_pass> t2_check = nvdaou.list();

                for (NhanVienDTO_u_nvdv_pass ir1 : t2_check) {
                    NhanVienDTO_u_nvdv_pass k = ir1;
                    if (!(t2.contains(k))) {
                        System.out.println("!       !");
                        System.out.println(t2.contains(ir1));
                        System.out.println("!       !");
                        t2.add(ir1);
                        NhanVienDonViDTO temp8 = new NhanVienDonViDTO(ir1.getmanv(), ir1.gettennv(), "0", "0");
                        nvdvbus.add(temp8);

                    }
                }
                updateNVDV();
                if (true) {
                    JOptionPane tb = new JOptionPane();

                    tb.showMessageDialog(pn_content, "Cập nhật xong danh sách nhân viên!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        //
        // xu ly click chuyen don vi
        bt_dsdv_chuyendv.addActionListener((ActionEvent e) -> {
            System.out.println("Click chuyen don vi");

            if (dvbus.getList().size() < 1) {
                JOptionPane tb = new JOptionPane();
                tb.showMessageDialog(this, "Danh sách đơn vị trống, mời thêm đơn vị ở thông tin đơn vị và thực hiện lại thao tác !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {

                if (getSelectedRowData_NVDV(tb_nvtdv, modelnvdv) != null) {
                    System.out.println("Dong Click co gia tri " + getSelectedRowData_NVDV(tb_nvtdv, modelnvdv).toString());
                    NhanVienDonViDTO xylyNV = getSelectedRowData_NVDV(tb_nvtdv, modelnvdv);

                    if (ChuyenDonVi.isShowing() == false) {

                        ChuyenDonVi.setBounds(100, 140, 600, 480);
                        ChuyenDonVi.setLayout(new GridLayout(1, 1));
                        String temp1 = xylyNV.toString();

                        //
                        lb_chuyendonvi_thongtinselect.setText(temp1);
                        //
                        cbb_dsdvden.removeAllItems();
                        ArrayList<DonViDTO> a = dvbus.getList();

                        cbb_dsdvden.addItem("Danh sách đơn vị");

                        for (DonViDTO z : a) {
                            cbb_dsdvden.addItem(z.getten());
                        }

                        ChuyenDonVi.add(pn_chuyendonvi);

                        pn_chuyendonvi.setVisible(true);
                        ChuyenDonVi.setVisible(true);
                        for (ActionListener listener : bt_chuyendonvi.getActionListeners()) {
                            bt_chuyendonvi.removeActionListener(listener);
                        }
                        bt_chuyendonvi.addActionListener((ActionEvent e1) -> {
                            System.out.println("Click vao button chuyen don vi");

                            if (cbb_dsdvden.getSelectedIndex() != 0) {
                                NhanVienDonViDTO kk = getSelectedRowData_NVDV(tb_nvtdv, modelnvdv);
                                String v1 = kk.getmanv();
                                String v2 = kk.getten();
                                String v3 = null, v4 = null;
                                ArrayList<DonViDTO> bb = dvbus.getList();

                                for (DonViDTO tempdv : bb) {
                                    if (tempdv.getten().equals((String) cbb_dsdvden.getSelectedItem())) {
                                        v3 = tempdv.getmadv();
                                        v4 = tempdv.getten();
                                        break;
                                    }
                                }

                                NhanVienDonViDTO temp5 = new NhanVienDonViDTO(v1, v2, v3, v4);
                                System.out.println("1 lan temp begin");
                                System.out.println("temp - " + temp5.toString());
                                System.out.println("1 lan temp end");
                                nvdvbus.set(temp5);
//                            updateNVDV();
                                ChuyenDonVi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                ChuyenDonVi.dispose();
                                updateNVDV();

                            }

                        });

                        //bt huy thao tac
                        for (ActionListener listener : bt_huythaotac.getActionListeners()) {
                            bt_huythaotac.removeActionListener(listener);
                        }
                        bt_huythaotac.addActionListener((ActionEvent e1) -> {
                            System.out.println("Click vao button huy thao tac chuyen don vi");
                            ChuyenDonVi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            ChuyenDonVi.dispose();
                            tb_nvtdv.clearSelection();
                        });
                        //
                    }
                } else {
                    if (tb_nvtdv.getRowCount() > 0) {
                        JOptionPane tb = new JOptionPane();
                        tb.showMessageDialog(this, "Vui lòng chọn nhân viên muốn chuyển ở bảng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }

        });

        // xy ly loai bo don vi cua nhan vien
        bt_dsdv_loaibo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean fc = false;
                System.out.println("Click loai bo don vi");
                if (getSelectedRowData_NVDV(tb_nvtdv, modelnvdv) != null) {
                    System.out.println("Dong Click co gia tri " + getSelectedRowData_NVDV(tb_nvtdv, modelnvdv).toString());
                    NhanVienDonViDTO tv = getSelectedRowData_NVDV(tb_nvtdv, modelnvdv);
                    fc = false;

                    if (!"0".equals(tv.gettendonvi()) && !"0".equals(tv.gettendonvi())) {
                        if ("adminaaa".equals(tv.getmanv())) {
                            JOptionPane tb = new JOptionPane();
                            tb.showMessageDialog(pn_content, "Tài khoản không được cấp quyền này.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            tv.setmadonvi("0");
                            tv.settendonvi("0");
                            nvdvbus.set(tv);
                            fc = true;
                            JOptionPane tb = new JOptionPane();
                            tb.showMessageDialog(pn_content, "Nhân viên mã: " + tv.getmanv() + ", Tên: " + tv.getten() + "đã được loại khỏi đơn vị hiện tại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                } else {
                    if (tb_nvtdv.getRowCount() > 0) {
                        JOptionPane tb = new JOptionPane();
                        tb.showMessageDialog(pn_content, "Vui lòng chọn dòng nhân viên muốn loại khỏi đơn vị hiện tại ở bảng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                // tai day
                if (fc == true) {
                    if (cbb_dsdv.getSelectedIndex() == 0) {
                        modelnvdv.setRowCount(0);
                        Vector data;

                        for (NhanVienDonViDTO j : nvdvbus.getList()) {

                            if (!"0".equals(j.gettendonvi()) && !"0".equals(j.getmadonvi())) {
                                data = new Vector();
                                data.add(j.getmanv());
                                data.add(j.getten());
                                data.add(j.getmadonvi());
                                data.add(j.gettendonvi());
                                modelnvdv.addRow(data);
                            }

                        }

                        tb_nvtdv = new JTable(modelnvdv) {
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        tb_nvtdv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                        tb_nvtdv
                                .setDefaultRenderer(Object.class,
                                        centerRenderer);

                        sp_nvtdv.add(tb_nvtdv);
                        sp_nvtdv.setViewportView(tb_nvtdv);

                        C2_c1pncenter_bot.add(sp_nvtdv, BorderLayout.CENTER);
                        sp_nvtdv.setVisible(true);
                        lb_soluongp.setText("Số lượng nhân viên: " + tb_nvtdv.getRowCount());

                        C2_c1pncenter_bot.revalidate();
                        C2_c1pncenter_bot.repaint();

                    } else if (cbb_dsdv.getSelectedIndex() == 1) {
                        modelnvdv.setRowCount(0);
                        Vector data;

                        for (NhanVienDonViDTO j : nvdvbus.getList()) {

                            if ("0".equals(j.gettendonvi()) && "0".equals(j.getmadonvi())) {
                                data = new Vector();
                                data.add(j.getmanv());
                                data.add(j.getten());
                                data.add(j.getmadonvi());
                                data.add(j.gettendonvi());
                                modelnvdv.addRow(data);
                            }

                        }

                        tb_nvtdv = new JTable(modelnvdv) {
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        tb_nvtdv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                        tb_nvtdv
                                .setDefaultRenderer(Object.class,
                                        centerRenderer);

                        sp_nvtdv.add(tb_nvtdv);
                        sp_nvtdv.setViewportView(tb_nvtdv);

                        C2_c1pncenter_bot.add(sp_nvtdv, BorderLayout.CENTER);
                        sp_nvtdv.setVisible(true);
                        lb_soluongp.setText("Số lượng nhân viên: " + tb_nvtdv.getRowCount());

                        C2_c1pncenter_bot.revalidate();
                        C2_c1pncenter_bot.repaint();

                    } else {
                        modelnvdv.setRowCount(0);
                        Vector data;
                        String iString = (String) cbb_dsdv.getSelectedItem();
                        String rsSring = iString.substring(0, 0) + iString.substring(0 + 17);

                        for (NhanVienDonViDTO j : nvdvbus.getList()) {

                            if (j.gettendonvi().equals(rsSring)) {
                                data = new Vector();
                                data.add(j.getmanv());
                                data.add(j.getten());
                                data.add(j.getmadonvi());
                                data.add(j.gettendonvi());
                                modelnvdv.addRow(data);
                            }

                        }

                        tb_nvtdv = new JTable(modelnvdv) {
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        tb_nvtdv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                        tb_nvtdv
                                .setDefaultRenderer(Object.class,
                                        centerRenderer);

                        sp_nvtdv.add(tb_nvtdv);
                        sp_nvtdv.setViewportView(tb_nvtdv);

                        C2_c1pncenter_bot.add(sp_nvtdv, BorderLayout.CENTER);
                        sp_nvtdv.setVisible(true);
                        lb_soluongp.setText("Số lượng nhân viên: " + tb_nvtdv.getRowCount());

                        C2_c1pncenter_bot.revalidate();
                        C2_c1pncenter_bot.repaint();

                    }

                }
            }
        });

        //    
        cbb_dsdv.addItemListener(new ItemListener() {
            // xu ly thay doi cbb
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    if (cbb_dsdv.getSelectedIndex() == 0) {
                        modelnvdv.setRowCount(0);
                        Vector data;

                        for (NhanVienDonViDTO j : nvdvbus.getList()) {

                            if (!"0".equals(j.gettendonvi()) && !"0".equals(j.getmadonvi())) {
                                data = new Vector();
                                data.add(j.getmanv());
                                data.add(j.getten());
                                data.add(j.getmadonvi());
                                data.add(j.gettendonvi());
                                modelnvdv.addRow(data);
                            }

                        }

                        tb_nvtdv = new JTable(modelnvdv) {
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        tb_nvtdv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                        tb_nvtdv
                                .setDefaultRenderer(Object.class,
                                        centerRenderer);

                        sp_nvtdv.add(tb_nvtdv);
                        sp_nvtdv.setViewportView(tb_nvtdv);

                        C2_c1pncenter_bot.add(sp_nvtdv, BorderLayout.CENTER);
                        sp_nvtdv.setVisible(true);
                        lb_soluongp.setText("Số lượng nhân viên: " + tb_nvtdv.getRowCount());

                        C2_c1pncenter_bot.revalidate();
                        C2_c1pncenter_bot.repaint();

                    } else if (cbb_dsdv.getSelectedIndex() == 1) {
                        modelnvdv.setRowCount(0);
                        Vector data;

                        for (NhanVienDonViDTO j : nvdvbus.getList()) {

                            if ("0".equals(j.gettendonvi()) && "0".equals(j.getmadonvi())) {
                                data = new Vector();
                                data.add(j.getmanv());
                                data.add(j.getten());
                                data.add(j.getmadonvi());
                                data.add(j.gettendonvi());
                                modelnvdv.addRow(data);
                            }

                        }

                        tb_nvtdv = new JTable(modelnvdv) {
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        tb_nvtdv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                        tb_nvtdv
                                .setDefaultRenderer(Object.class,
                                        centerRenderer);

                        sp_nvtdv.add(tb_nvtdv);
                        sp_nvtdv.setViewportView(tb_nvtdv);

                        C2_c1pncenter_bot.add(sp_nvtdv, BorderLayout.CENTER);
                        sp_nvtdv.setVisible(true);
                        lb_soluongp.setText("Số lượng nhân viên: " + tb_nvtdv.getRowCount());

                        C2_c1pncenter_bot.revalidate();
                        C2_c1pncenter_bot.repaint();

                    } else {
                        modelnvdv.setRowCount(0);
                        Vector data;
                        String iString = (String) cbb_dsdv.getSelectedItem();
                        String rsSring = iString.substring(0, 0) + iString.substring(0 + 17);

                        for (NhanVienDonViDTO j : nvdvbus.getList()) {

                            if (j.gettendonvi().equals(rsSring)) {
                                data = new Vector();
                                data.add(j.getmanv());
                                data.add(j.getten());
                                data.add(j.getmadonvi());
                                data.add(j.gettendonvi());
                                modelnvdv.addRow(data);
                            }

                        }

                        tb_nvtdv = new JTable(modelnvdv) {
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        tb_nvtdv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                        tb_nvtdv
                                .setDefaultRenderer(Object.class,
                                        centerRenderer);

                        sp_nvtdv.add(tb_nvtdv);
                        sp_nvtdv.setViewportView(tb_nvtdv);

                        C2_c1pncenter_bot.add(sp_nvtdv, BorderLayout.CENTER);
                        sp_nvtdv.setVisible(true);
                        lb_soluongp.setText("Số lượng nhân viên: " + tb_nvtdv.getRowCount());

                        C2_c1pncenter_bot.revalidate();
                        C2_c1pncenter_bot.repaint();

                    }
                }//
            }
        });
        //

    }// end initC2

    public void outModeldv(DefaultTableModel model, ArrayList<DonViDTO> dv) // B2
    {
        Vector data;
        model.setRowCount(0);
        for (DonViDTO d : dv) {
            data = new Vector();
            data.add(d.getmadv());
            data.add(d.getten());
            model.addRow(data);
        }
        tb_dv.setModel(model);
    }

    public void listdv() // B1
    {
        if (dvbus.getList() == null) {
            dvbus.list();
        }
        ArrayList<DonViDTO> dv = dvbus.getList();
        modeldv.setRowCount(0);
        outModeldv(modeldv, dv);
    }

    //Phan nhan vien don vi
    public void outModelnvdv(DefaultTableModel model, ArrayList<NhanVienDonViDTO> nvdv) // B2
    {
        Vector data;
        model.setRowCount(0);
        for (NhanVienDonViDTO d : nvdv) {
            data = new Vector();
            data.add(d.getmanv());
            data.add(d.getten());
            data.add(d.getmadonvi());
            data.add(d.gettendonvi());
            model.addRow(data);
        }
        tb_nvtdv.setModel(model);
    }

    public void listnvdv() // B1
    {
        if (nvdvbus.getList() == null) {
            nvdvbus.list();
        }
        ArrayList<NhanVienDonViDTO> nv = nvdvbus.getList();
        modelnvdv.setRowCount(0);
        outModelnvdv(modelnvdv, nv);
    }
    //Phan nhan vien don vi

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btg_Thongtin = new javax.swing.ButtonGroup();
        sp_nvtdv = new javax.swing.JScrollPane();
        tb_nvtdv = new javax.swing.JTable();
        sp_dv = new javax.swing.JScrollPane();
        tb_dv = new javax.swing.JTable();
        cbb_dsdv = new javax.swing.JComboBox<>();
        bt_dsdv_chuyendv = new javax.swing.JButton();
        bt_dsdv_loaibo = new javax.swing.JButton();
        dv_txtdv = new javax.swing.JTextField();
        lb_tendv = new javax.swing.JLabel();
        bt_dv_them = new javax.swing.JButton();
        bt_dv_capnhat = new javax.swing.JButton();
        bt_dv_xoa = new javax.swing.JButton();
        lb_soluongp = new javax.swing.JLabel();
        pn_chuyendonvi = new javax.swing.JPanel();
        pn_content = new javax.swing.JPanel();
        pn_thongtinselect = new javax.swing.JPanel();
        lb_chuyendonvi_thongtinselect = new javax.swing.JLabel();
        pn_dvto = new javax.swing.JPanel();
        lb_chondvden = new javax.swing.JLabel();
        cbb_dsdvden = new javax.swing.JComboBox<>();
        pn_ttchuyendonvi = new javax.swing.JPanel();
        lb_bangchuyendonvi = new javax.swing.JLabel();
        pn_control_chuyendv = new javax.swing.JPanel();
        bt_chuyendonvi = new javax.swing.JButton();
        bt_huythaotac = new javax.swing.JButton();
        pn_doitendv = new javax.swing.JPanel();
        pn_doitendv_top = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        cb_r1 = new javax.swing.JCheckBox();
        jPanel25 = new javax.swing.JPanel();
        cb_r2 = new javax.swing.JCheckBox();
        jPanel26 = new javax.swing.JPanel();
        cb_r3 = new javax.swing.JCheckBox();
        jPanel27 = new javax.swing.JPanel();
        cb_r4 = new javax.swing.JCheckBox();
        jPanel28 = new javax.swing.JPanel();
        cb_r5 = new javax.swing.JCheckBox();
        pn_doitendv_center = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lb_tt_dvdangchon = new javax.swing.JLabel();
        lb_change_showdv = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lb_nhaptenmoidv = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        tf_change_tenmoi = new javax.swing.JTextField();
        pn_doitendv_bot = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        bt_doitendv = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        bt_doitendv_huythaotac = new javax.swing.JButton();
        pn_themdvmoi = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_tendonvimoi_them = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        bt_themdvmoi_thuchien = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        bt_huythemdvmoi = new javax.swing.JButton();
        pn_uthemDVmoi = new javax.swing.JPanel();
        pn_dsdsa = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jp22d2 = new javax.swing.JPanel();
        add_cbr1 = new javax.swing.JCheckBox();
        u_cb_r2 = new javax.swing.JPanel();
        add_cbr2 = new javax.swing.JCheckBox();
        jPanel38 = new javax.swing.JPanel();
        add_cbr3 = new javax.swing.JCheckBox();
        jPanel39 = new javax.swing.JPanel();
        add_cbr4 = new javax.swing.JCheckBox();
        jPanel40 = new javax.swing.JPanel();
        add_cbr5 = new javax.swing.JCheckBox();
        pn_12edd = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        lb_tieude = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        lb_nhaptenmoidv1 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        tf_them_tendvmoi = new javax.swing.JTextField();
        pn_asdhas = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        bt_thuchienthemdv = new javax.swing.JButton();
        jPanel42 = new javax.swing.JPanel();
        bt_themdvmoi_huythaotac = new javax.swing.JButton();
        lb_ttpn = new javax.swing.JLabel();
        C1_pncenter = new javax.swing.JPanel();
        C2_c1pncenter_top = new javax.swing.JPanel();
        lb_thongtin = new javax.swing.JLabel();
        cb_nvtdv = new javax.swing.JCheckBox();
        cb_dv = new javax.swing.JCheckBox();
        C2_c1pncenter_bot = new javax.swing.JPanel();
        lb_mcttddc = new javax.swing.JLabel();
        C1_pnbot = new javax.swing.JPanel();

        tb_nvtdv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Họ và tên", "Tên đơn vị"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        sp_nvtdv.setViewportView(tb_nvtdv);

        tb_dv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Đơn Vị", "Tên Đơn Vị"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        sp_dv.setViewportView(tb_dv);

        cbb_dsdv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Danh sách đơn vị" }));

        bt_dsdv_chuyendv.setText("jButton1");

        bt_dsdv_loaibo.setText("jButton1");

        dv_txtdv.setText("jTextField1");

        lb_tendv.setText("jLabel1");

        bt_dv_them.setText("jButton1");

        bt_dv_capnhat.setText("jButton2");

        bt_dv_xoa.setText("jButton3");

        lb_soluongp.setText("jLabel2");

        pn_chuyendonvi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pn_chuyendonvi.setPreferredSize(new java.awt.Dimension(340, 400));
        pn_chuyendonvi.setLayout(new java.awt.BorderLayout());

        pn_content.setLayout(new java.awt.GridLayout(2, 1));

        pn_thongtinselect.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pn_thongtinselect.setLayout(new java.awt.GridLayout(1, 1));

        lb_chuyendonvi_thongtinselect.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lb_chuyendonvi_thongtinselect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_chuyendonvi_thongtinselect.setText("------");
        pn_thongtinselect.add(lb_chuyendonvi_thongtinselect);

        pn_content.add(pn_thongtinselect);

        pn_dvto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pn_dvto.setPreferredSize(new java.awt.Dimension(555, 100));
        pn_dvto.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 40));

        lb_chondvden.setText("Chọn đơn vị đến");
        lb_chondvden.setPreferredSize(new java.awt.Dimension(140, 44));
        pn_dvto.add(lb_chondvden);

        cbb_dsdvden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Danh sách đơn vị" }));
        cbb_dsdvden.setPreferredSize(new java.awt.Dimension(240, 44));
        pn_dvto.add(cbb_dsdvden);

        pn_content.add(pn_dvto);

        pn_chuyendonvi.add(pn_content, java.awt.BorderLayout.CENTER);

        pn_ttchuyendonvi.setPreferredSize(new java.awt.Dimension(555, 60));
        pn_ttchuyendonvi.setLayout(new java.awt.GridLayout(1, 1));

        lb_bangchuyendonvi.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lb_bangchuyendonvi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_bangchuyendonvi.setText("Bảng chuyển đơn vị");
        pn_ttchuyendonvi.add(lb_bangchuyendonvi);

        pn_chuyendonvi.add(pn_ttchuyendonvi, java.awt.BorderLayout.PAGE_START);

        pn_control_chuyendv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pn_control_chuyendv.setPreferredSize(new java.awt.Dimension(555, 80));
        pn_control_chuyendv.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 36, 18));

        bt_chuyendonvi.setText("Chuyển đơn vị");
        bt_chuyendonvi.setPreferredSize(new java.awt.Dimension(120, 44));
        pn_control_chuyendv.add(bt_chuyendonvi);

        bt_huythaotac.setText("Hủy thao tác");
        bt_huythaotac.setPreferredSize(new java.awt.Dimension(120, 44));
        pn_control_chuyendv.add(bt_huythaotac);

        pn_chuyendonvi.add(pn_control_chuyendv, java.awt.BorderLayout.PAGE_END);

        pn_doitendv.setLayout(new java.awt.BorderLayout());

        pn_doitendv_top.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204)));
        pn_doitendv_top.setPreferredSize(new java.awt.Dimension(100, 60));
        pn_doitendv_top.setLayout(new java.awt.GridLayout(1, 2));

        jPanel13.setLayout(new java.awt.GridLayout(5, 1));

        jPanel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel31.setLayout(new java.awt.GridLayout(1, 0));

        jLabel6.setText(" - Quyền quản lí tài khoản ");
        jPanel31.add(jLabel6);

        jPanel13.add(jPanel31);

        jPanel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel30.setLayout(new java.awt.GridLayout(1, 0));

        jLabel5.setText(" - Quyền quản lí lương nhân viên ");
        jPanel30.add(jLabel5);

        jPanel13.add(jPanel30);

        jPanel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel29.setLayout(new java.awt.GridLayout(1, 0));

        jLabel4.setText(" - Quyền quản lí chấm công nhân viên ");
        jPanel29.add(jLabel4);

        jPanel13.add(jPanel29);

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel15.setLayout(new java.awt.GridLayout(1, 0));

        jLabel3.setText(" - Quyền quản lí thông tin nhân viên, hợp đồng");
        jPanel15.add(jLabel3);

        jPanel13.add(jPanel15);

        jPanel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel32.setLayout(new java.awt.GridLayout(1, 0));

        jLabel7.setText(" - Quyền đơn vị, quản lí nhân viên đơn vị, đơn vị");
        jPanel32.add(jLabel7);

        jPanel13.add(jPanel32);

        pn_doitendv_top.add(jPanel13);

        jPanel14.setLayout(new java.awt.GridLayout(5, 1));

        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel20.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 8));

        cb_r1.setText("Có");
        cb_r1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cb_r1.setPreferredSize(new java.awt.Dimension(68, 32));
        jPanel20.add(cb_r1);

        jPanel14.add(jPanel20);

        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel25.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 8));

        cb_r2.setText("Có");
        cb_r2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cb_r2.setPreferredSize(new java.awt.Dimension(68, 32));
        jPanel25.add(cb_r2);

        jPanel14.add(jPanel25);

        jPanel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel26.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 8));

        cb_r3.setText("Có");
        cb_r3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cb_r3.setPreferredSize(new java.awt.Dimension(68, 32));
        jPanel26.add(cb_r3);

        jPanel14.add(jPanel26);

        jPanel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel27.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 8));

        cb_r4.setText("Có");
        cb_r4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cb_r4.setPreferredSize(new java.awt.Dimension(68, 32));
        jPanel27.add(cb_r4);

        jPanel14.add(jPanel27);

        jPanel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel28.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 8));

        cb_r5.setText("Có");
        cb_r5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cb_r5.setPreferredSize(new java.awt.Dimension(68, 32));
        jPanel28.add(cb_r5);

        jPanel14.add(jPanel28);

        pn_doitendv_top.add(jPanel14);

        pn_doitendv.add(pn_doitendv_top, java.awt.BorderLayout.CENTER);

        pn_doitendv_center.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204)));
        pn_doitendv_center.setLayout(new java.awt.GridLayout(2, 1));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        lb_tt_dvdangchon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_tt_dvdangchon.setText("Thay đổi tên, quyền của đơn vị:");
        jPanel4.add(lb_tt_dvdangchon);

        lb_change_showdv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_change_showdv.setText("Đơn vị");
        jPanel4.add(lb_change_showdv);

        pn_doitendv_center.add(jPanel4);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setLayout(new java.awt.GridLayout(1, 1));

        lb_nhaptenmoidv.setBackground(new java.awt.Color(0, 51, 51));
        lb_nhaptenmoidv.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        lb_nhaptenmoidv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_nhaptenmoidv.setText("Nhập tên mới của đơn vị");
        lb_nhaptenmoidv.setPreferredSize(new java.awt.Dimension(131, 24));
        jPanel5.add(lb_nhaptenmoidv);

        jPanel3.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 16));

        tf_change_tenmoi.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_change_tenmoi.setPreferredSize(new java.awt.Dimension(140, 24));
        jPanel6.add(tf_change_tenmoi);

        jPanel3.add(jPanel6);

        pn_doitendv_center.add(jPanel3);

        pn_doitendv.add(pn_doitendv_center, java.awt.BorderLayout.PAGE_START);

        pn_doitendv_bot.setLayout(new java.awt.GridLayout(1, 2));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 32));

        bt_doitendv.setBackground(new java.awt.Color(204, 204, 255));
        bt_doitendv.setText("Thay đổi");
        bt_doitendv.setPreferredSize(new java.awt.Dimension(90, 38));
        jPanel1.add(bt_doitendv);

        pn_doitendv_bot.add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 32));

        bt_doitendv_huythaotac.setBackground(new java.awt.Color(204, 204, 255));
        bt_doitendv_huythaotac.setText("Hủy thao tác");
        bt_doitendv_huythaotac.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_doitendv_huythaotac.setPreferredSize(new java.awt.Dimension(120, 38));
        jPanel2.add(bt_doitendv_huythaotac);

        pn_doitendv_bot.add(jPanel2);

        pn_doitendv.add(pn_doitendv_bot, java.awt.BorderLayout.PAGE_END);

        pn_themdvmoi.setPreferredSize(new java.awt.Dimension(400, 360));
        pn_themdvmoi.setLayout(new java.awt.GridLayout(2, 1));

        jPanel7.setLayout(new java.awt.GridLayout(2, 1));

        jPanel11.setBackground(new java.awt.Color(204, 204, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204)));
        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 28, 36));

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel2.setText("Tên đơn vị mới");
        jPanel11.add(jLabel2);

        tf_tendonvimoi_them.setPreferredSize(new java.awt.Dimension(120, 22));
        jPanel11.add(tf_tendonvimoi_them);

        jPanel7.add(jPanel11);

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 255), 2));
        jPanel12.setLayout(new java.awt.GridLayout(1, 1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mời nhập tên đơn vị mới ");
        jPanel12.add(jLabel1);

        jPanel7.add(jPanel12);

        pn_themdvmoi.add(jPanel7);

        jPanel8.setPreferredSize(new java.awt.Dimension(400, 140));
        jPanel8.setLayout(new java.awt.GridLayout(1, 2));

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 204)));
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 68));

        bt_themdvmoi_thuchien.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        bt_themdvmoi_thuchien.setText("Thêm mới");
        bt_themdvmoi_thuchien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_themdvmoi_thuchien.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel9.add(bt_themdvmoi_thuchien);

        jPanel8.add(jPanel9);

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 204)));
        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 68));

        bt_huythemdvmoi.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        bt_huythemdvmoi.setText("Hủy thao tác");
        bt_huythemdvmoi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_huythemdvmoi.setPreferredSize(new java.awt.Dimension(124, 40));
        jPanel10.add(bt_huythemdvmoi);

        jPanel8.add(jPanel10);

        pn_themdvmoi.add(jPanel8);

        pn_uthemDVmoi.setLayout(new java.awt.BorderLayout());

        pn_dsdsa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204)));
        pn_dsdsa.setPreferredSize(new java.awt.Dimension(100, 60));
        pn_dsdsa.setLayout(new java.awt.GridLayout(1, 2));

        jPanel16.setLayout(new java.awt.GridLayout(5, 1));

        jPanel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel33.setLayout(new java.awt.GridLayout(1, 0));

        jLabel8.setText(" - Quyền quản lí tài khoản ");
        jPanel33.add(jLabel8);

        jPanel16.add(jPanel33);

        jPanel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel34.setLayout(new java.awt.GridLayout(1, 0));

        jLabel9.setText(" - Quyền quản lí lương nhân viên ");
        jPanel34.add(jLabel9);

        jPanel16.add(jPanel34);

        jPanel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel35.setLayout(new java.awt.GridLayout(1, 0));

        jLabel10.setText(" - Quyền quản lí chấm công nhân viên ");
        jPanel35.add(jLabel10);

        jPanel16.add(jPanel35);

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel17.setLayout(new java.awt.GridLayout(1, 0));

        jLabel11.setText(" - Quyền quản lí thông tin nhân viên, hợp đồng");
        jPanel17.add(jLabel11);

        jPanel16.add(jPanel17);

        jPanel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel36.setLayout(new java.awt.GridLayout(1, 0));

        jLabel12.setText(" - Quyền đơn vị, quản lí nhân viên đơn vị, đơn vị");
        jPanel36.add(jLabel12);

        jPanel16.add(jPanel36);

        pn_dsdsa.add(jPanel16);

        jPanel18.setLayout(new java.awt.GridLayout(5, 1));

        jp22d2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jp22d2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 8));

        add_cbr1.setText("Có");
        add_cbr1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        add_cbr1.setPreferredSize(new java.awt.Dimension(68, 32));
        jp22d2.add(add_cbr1);

        jPanel18.add(jp22d2);

        u_cb_r2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        u_cb_r2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 8));

        add_cbr2.setText("Có");
        add_cbr2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        add_cbr2.setPreferredSize(new java.awt.Dimension(68, 32));
        u_cb_r2.add(add_cbr2);

        jPanel18.add(u_cb_r2);

        jPanel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel38.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 8));

        add_cbr3.setText("Có");
        add_cbr3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        add_cbr3.setPreferredSize(new java.awt.Dimension(68, 32));
        jPanel38.add(add_cbr3);

        jPanel18.add(jPanel38);

        jPanel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel39.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 8));

        add_cbr4.setText("Có");
        add_cbr4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        add_cbr4.setPreferredSize(new java.awt.Dimension(68, 32));
        jPanel39.add(add_cbr4);

        jPanel18.add(jPanel39);

        jPanel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel40.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 8));

        add_cbr5.setText("Có");
        add_cbr5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        add_cbr5.setPreferredSize(new java.awt.Dimension(68, 32));
        jPanel40.add(add_cbr5);

        jPanel18.add(jPanel40);

        pn_dsdsa.add(jPanel18);

        pn_uthemDVmoi.add(pn_dsdsa, java.awt.BorderLayout.CENTER);

        pn_12edd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204)));
        pn_12edd.setLayout(new java.awt.GridLayout(2, 1));

        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel19.setLayout(new java.awt.GridLayout(1, 1));

        lb_tieude.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_tieude.setText("Thêm đơn vị mới");
        jPanel19.add(lb_tieude);

        pn_12edd.add(jPanel19);

        jPanel22.setLayout(new java.awt.GridLayout(1, 0));

        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel23.setLayout(new java.awt.GridLayout(1, 1));

        lb_nhaptenmoidv1.setBackground(new java.awt.Color(0, 51, 51));
        lb_nhaptenmoidv1.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        lb_nhaptenmoidv1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_nhaptenmoidv1.setText("Nhập tên mới của đơn vị");
        lb_nhaptenmoidv1.setPreferredSize(new java.awt.Dimension(131, 24));
        jPanel23.add(lb_nhaptenmoidv1);

        jPanel22.add(jPanel23);

        jPanel24.setBackground(new java.awt.Color(204, 204, 255));
        jPanel24.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 16));

        tf_them_tendvmoi.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_them_tendvmoi.setPreferredSize(new java.awt.Dimension(140, 24));
        jPanel24.add(tf_them_tendvmoi);

        jPanel22.add(jPanel24);

        pn_12edd.add(jPanel22);

        pn_uthemDVmoi.add(pn_12edd, java.awt.BorderLayout.PAGE_START);

        pn_asdhas.setLayout(new java.awt.GridLayout(1, 2));

        jPanel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel41.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 32));

        bt_thuchienthemdv.setBackground(new java.awt.Color(204, 204, 255));
        bt_thuchienthemdv.setText("Thêm");
        bt_thuchienthemdv.setPreferredSize(new java.awt.Dimension(90, 38));
        bt_thuchienthemdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_thuchienthemdvActionPerformed(evt);
            }
        });
        jPanel41.add(bt_thuchienthemdv);

        pn_asdhas.add(jPanel41);

        jPanel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel42.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 32));

        bt_themdvmoi_huythaotac.setBackground(new java.awt.Color(204, 204, 255));
        bt_themdvmoi_huythaotac.setText("Hủy thao tác");
        bt_themdvmoi_huythaotac.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_themdvmoi_huythaotac.setPreferredSize(new java.awt.Dimension(120, 38));
        jPanel42.add(bt_themdvmoi_huythaotac);

        pn_asdhas.add(jPanel42);

        pn_uthemDVmoi.add(pn_asdhas, java.awt.BorderLayout.PAGE_END);

        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.BorderLayout());

        lb_ttpn.setBackground(new java.awt.Color(255, 204, 204));
        lb_ttpn.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lb_ttpn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_ttpn.setText("Điều chỉnh Đơn Vị");
        lb_ttpn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lb_ttpn.setPreferredSize(new java.awt.Dimension(37, 36));
        add(lb_ttpn, java.awt.BorderLayout.PAGE_START);

        C1_pncenter.setLayout(new java.awt.BorderLayout());

        C2_c1pncenter_top.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 255, 255)));
        C2_c1pncenter_top.setPreferredSize(new java.awt.Dimension(736, 80));
        C2_c1pncenter_top.setLayout(new java.awt.GridLayout(1, 3, 8, 0));

        lb_thongtin.setBackground(new java.awt.Color(204, 204, 255));
        lb_thongtin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_thongtin.setText("Thông tin");
        lb_thongtin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 255)));
        C2_c1pncenter_top.add(lb_thongtin);

        cb_nvtdv.setBackground(new java.awt.Color(255, 255, 255));
        btg_Thongtin.add(cb_nvtdv);
        cb_nvtdv.setText("Nhân viên thuộc đơn vị");
        cb_nvtdv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cb_nvtdv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cb_nvtdv.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_nvtdvItemStateChanged(evt);
            }
        });
        cb_nvtdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_nvtdvActionPerformed(evt);
            }
        });
        C2_c1pncenter_top.add(cb_nvtdv);

        cb_dv.setBackground(new java.awt.Color(255, 255, 255));
        btg_Thongtin.add(cb_dv);
        cb_dv.setText("Đơn vị");
        cb_dv.setBorder(new javax.swing.border.MatteBorder(null));
        cb_dv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cb_dv.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_dvItemStateChanged(evt);
            }
        });
        C2_c1pncenter_top.add(cb_dv);

        C1_pncenter.add(C2_c1pncenter_top, java.awt.BorderLayout.PAGE_START);

        C2_c1pncenter_bot.setLayout(new java.awt.BorderLayout());

        lb_mcttddc.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lb_mcttddc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_mcttddc.setText("Mời chọn thông tin để điều chỉnh.");
        C2_c1pncenter_bot.add(lb_mcttddc, java.awt.BorderLayout.CENTER);

        C1_pncenter.add(C2_c1pncenter_bot, java.awt.BorderLayout.CENTER);

        add(C1_pncenter, java.awt.BorderLayout.CENTER);

        C1_pnbot.setBackground(new java.awt.Color(204, 204, 255));
        C1_pnbot.setPreferredSize(new java.awt.Dimension(900, 56));

        javax.swing.GroupLayout C1_pnbotLayout = new javax.swing.GroupLayout(C1_pnbot);
        C1_pnbot.setLayout(C1_pnbotLayout);
        C1_pnbotLayout.setHorizontalGroup(
            C1_pnbotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        C1_pnbotLayout.setVerticalGroup(
            C1_pnbotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        add(C1_pnbot, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void cb_nvtdvItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_nvtdvItemStateChanged
        // TODO add your handling code here:
        if (cb_nvtdv.isSelected() == true) {
            C2_c1pncenter_bot.removeAll();
            C2_c1pncenter_bot.setLayout(new BorderLayout(4, 4));

            listnvdv();// lay data de tao model
            tb_nvtdv = new JTable(modelnvdv) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            tb_nvtdv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            tb_nvtdv
                    .setDefaultRenderer(Object.class,
                            centerRenderer);

            sp_nvtdv.add(tb_nvtdv);
            sp_nvtdv.setViewportView(tb_nvtdv);

            C2_c1pncenter_bot.add(sp_nvtdv, BorderLayout.CENTER);
            sp_nvtdv.setVisible(true);

            C2_c1pncenter_bot.add(lb_soluongp, BorderLayout.SOUTH);
            lb_soluongp.setHorizontalAlignment(JLabel.CENTER);
            lb_soluongp.setPreferredSize(new Dimension(100, 40));
            lb_soluongp.setText("Số lượng nhân viên: " + tb_nvtdv.getRowCount());

            lb_soluongp.setVisible(true);

            C2_c1pncenter_bot.revalidate();
            C2_c1pncenter_bot.repaint();

            C1_pnbot.removeAll();
            C1_pnbot.setLayout(new FlowLayout(1, 36, 12));

            ArrayList<DonViDTO> a = dvbus.getList();
            cbb_dsdv.removeAllItems();
            cbb_dsdv.addItem("nhân viên đã có đơn vị");
            cbb_dsdv.addItem("nhân viên chưa có đơn vị");
            for (DonViDTO z : a) {
                String t = "nhân viên đơn vị ";
                cbb_dsdv.addItem(t + z.getten());
            }

            C1_pnbot.add(lbdanhsach);
            lbdanhsach.setVisible(true);

            C1_pnbot.add(cbb_dsdv);
            cbb_dsdv.setVisible(true);

            C1_pnbot.add(bt_nvdv_capnhatdsnv);
            bt_nvdv_capnhatdsnv.setText("Cập nhật nhân viên mới");
            bt_nvdv_capnhatdsnv.setVisible(true);

            C1_pnbot.add(bt_dsdv_chuyendv);
            bt_dsdv_chuyendv.setText("Chuyển đơn vị mới");
            bt_dsdv_chuyendv.setVisible(true);

            C1_pnbot.add(bt_dsdv_loaibo);
            bt_dsdv_loaibo.setText("Loại bỏ khỏi đơn vị");
            bt_dsdv_loaibo.setVisible(true);

            C1_pnbot.revalidate();
            C1_pnbot.repaint();
        }
    }//GEN-LAST:event_cb_nvtdvItemStateChanged

    private void cb_dvItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_dvItemStateChanged
        // TODO add your handling code here:
        if (cb_dv.isSelected() == true) {

            C2_c1pncenter_bot.removeAll();
            C2_c1pncenter_bot.setLayout(new BorderLayout(4, 4));
            listdv();// lay data de tao model
            tb_dv = new JTable(modeldv) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            tb_dv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            tb_dv
                    .setDefaultRenderer(Object.class,
                            centerRenderer);

            sp_dv.add(tb_dv);
            sp_dv.setViewportView(tb_dv);

            C2_c1pncenter_bot.add(sp_dv, BorderLayout.CENTER);
            sp_dv.setVisible(true);

            C2_c1pncenter_bot.add(lb_soluongp, BorderLayout.SOUTH);
            lb_soluongp.setHorizontalAlignment(JLabel.CENTER);
            lb_soluongp.setPreferredSize(new Dimension(100, 40));

            lb_soluongp.setText("Số lượng đơn vị: " + tb_dv.getRowCount());
            lb_soluongp.setVisible(true);

            C2_c1pncenter_bot.revalidate();
            C2_c1pncenter_bot.repaint();

            C1_pnbot.removeAll();
            C1_pnbot.setLayout(new FlowLayout(1, 28, 14));
//            C1_pnbot.add(lb_tendv);
//            lb_tendv.setText("Tên đơn vị:");
//            lb_tendv.setVisible(true);
//
//            C1_pnbot.add(dv_txtdv);
//            dv_txtdv.setPreferredSize(new Dimension(116, 24));
//            dv_txtdv.setText("");
//            dv_txtdv.setVisible(true);

            C1_pnbot.add(bt_dv_them);
            bt_dv_them.setText("Thêm đơn vị");
            bt_dv_them.setVisible(true);

            C1_pnbot.add(bt_dv_capnhat);
            bt_dv_capnhat.setText("Cập nhật thông tin đơn vị");
            bt_dv_capnhat.setVisible(true);

            C1_pnbot.add(bt_dv_xoa);
            bt_dv_xoa.setText("Xóa đơn vị đang chọn");
            bt_dv_xoa.setVisible(true);

            C1_pnbot.revalidate();
            C1_pnbot.repaint();
        }
    }//GEN-LAST:event_cb_dvItemStateChanged

    private void cb_nvtdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_nvtdvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_nvtdvActionPerformed

    private void bt_thuchienthemdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_thuchienthemdvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_thuchienthemdvActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel C1_pnbot;
    private javax.swing.JPanel C1_pncenter;
    private javax.swing.JPanel C2_c1pncenter_bot;
    private javax.swing.JPanel C2_c1pncenter_top;
    private javax.swing.JCheckBox add_cbr1;
    private javax.swing.JCheckBox add_cbr2;
    private javax.swing.JCheckBox add_cbr3;
    private javax.swing.JCheckBox add_cbr4;
    private javax.swing.JCheckBox add_cbr5;
    private javax.swing.JButton bt_chuyendonvi;
    private javax.swing.JButton bt_doitendv;
    private javax.swing.JButton bt_doitendv_huythaotac;
    private javax.swing.JButton bt_dsdv_chuyendv;
    private javax.swing.JButton bt_dsdv_loaibo;
    private javax.swing.JButton bt_dv_capnhat;
    private javax.swing.JButton bt_dv_them;
    private javax.swing.JButton bt_dv_xoa;
    private javax.swing.JButton bt_huythaotac;
    private javax.swing.JButton bt_huythemdvmoi;
    private javax.swing.JButton bt_themdvmoi_huythaotac;
    private javax.swing.JButton bt_themdvmoi_thuchien;
    private javax.swing.JButton bt_thuchienthemdv;
    private javax.swing.ButtonGroup btg_Thongtin;
    private javax.swing.JCheckBox cb_dv;
    private javax.swing.JCheckBox cb_nvtdv;
    private javax.swing.JCheckBox cb_r1;
    private javax.swing.JCheckBox cb_r2;
    private javax.swing.JCheckBox cb_r3;
    private javax.swing.JCheckBox cb_r4;
    private javax.swing.JCheckBox cb_r5;
    private javax.swing.JComboBox<String> cbb_dsdv;
    private javax.swing.JComboBox<String> cbb_dsdvden;
    private javax.swing.JTextField dv_txtdv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jp22d2;
    private javax.swing.JLabel lb_bangchuyendonvi;
    private javax.swing.JLabel lb_change_showdv;
    private javax.swing.JLabel lb_chondvden;
    private javax.swing.JLabel lb_chuyendonvi_thongtinselect;
    private javax.swing.JLabel lb_mcttddc;
    private javax.swing.JLabel lb_nhaptenmoidv;
    private javax.swing.JLabel lb_nhaptenmoidv1;
    private javax.swing.JLabel lb_soluongp;
    private javax.swing.JLabel lb_tendv;
    private javax.swing.JLabel lb_thongtin;
    private javax.swing.JLabel lb_tieude;
    private javax.swing.JLabel lb_tt_dvdangchon;
    private javax.swing.JLabel lb_ttpn;
    private javax.swing.JPanel pn_12edd;
    private javax.swing.JPanel pn_asdhas;
    private javax.swing.JPanel pn_chuyendonvi;
    private javax.swing.JPanel pn_content;
    private javax.swing.JPanel pn_control_chuyendv;
    private javax.swing.JPanel pn_doitendv;
    private javax.swing.JPanel pn_doitendv_bot;
    private javax.swing.JPanel pn_doitendv_center;
    private javax.swing.JPanel pn_doitendv_top;
    private javax.swing.JPanel pn_dsdsa;
    private javax.swing.JPanel pn_dvto;
    private javax.swing.JPanel pn_themdvmoi;
    private javax.swing.JPanel pn_thongtinselect;
    private javax.swing.JPanel pn_ttchuyendonvi;
    private javax.swing.JPanel pn_uthemDVmoi;
    private javax.swing.JScrollPane sp_dv;
    private javax.swing.JScrollPane sp_nvtdv;
    private javax.swing.JTable tb_dv;
    private javax.swing.JTable tb_nvtdv;
    private javax.swing.JTextField tf_change_tenmoi;
    private javax.swing.JTextField tf_tendonvimoi_them;
    private javax.swing.JTextField tf_them_tendvmoi;
    private javax.swing.JPanel u_cb_r2;
    // End of variables declaration//GEN-END:variables
}

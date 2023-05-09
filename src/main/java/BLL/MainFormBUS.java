package BLL;

import DAL.ChucNangDAO;
import DTO.ChucNang;
import DTO.CodeCN;
import GUI.QLChamCong.ChamCongForm;
import GUI.QLLuong.QuanLyLuongContent;
import GUI.QLNhanVien.HopDongGUI;
import GUI.QLNhanVien.NhanVienGUI;
import GUI.Model.Content;
import GUI.QLTaiKhoan.K_DoiMatKhaugui;
import GUI.QLTaiKhoan.K_Panel_QuanLyTaiKhoan;
import GUI.XemThongTin.ViewInfo;

import java.util.List;
import java.util.Map;

public class MainFormBUS {
    private String[] dsTenCN;
    private Map<CodeCN, String> mapTenCN;
    private List<ChucNang> dsChucNang;
    private ChucNangDAO dao;
    public MainFormBUS() {
        dao = new ChucNangDAO();
//        mapTenCN = new HashMap<>();
//        mapTenCN.put(CodeCN.QLNV, "Quản lý nhân viên");
//        mapTenCN.put(CodeCN.QLHD, "Quản lý hợp đồng");
//        mapTenCN.put(CodeCN.QLCC, "Quản lý chấm công");
//        mapTenCN.put(CodeCN.QLTL, "Quản lý tính lương");
    }

    public List<ChucNang> getDsTenCN(String username) {
        if (dsChucNang == null) {
            dsChucNang = dao.selectAllByUsername(username);
        }
        return dsChucNang;
    }

    public Content changeContent(String tenCN, String username) {
        for (var chucNang : dsChucNang) {
            if (chucNang.getTenCN().equals(tenCN)) {
                switch (chucNang.getCodeCN()) {
                    case QLNV -> {
                        return new NhanVienGUI();
                    }
                    case QLHD -> {
                        return new HopDongGUI();
                    }
                    case QLCC -> {
                        return new ChamCongForm();
                    }
                    case QLTL -> {
                        return new QuanLyLuongContent();
                    }
                    case VIEW_INFOR -> {
                        return new ViewInfo();
                    }
                    case QLTK -> {
                        return new K_Panel_QuanLyTaiKhoan();
                    }
                    case CHANGE_PASS -> {
                        return new K_DoiMatKhaugui(username);
                    }
                }
                break;
            }
        }
        return null;
    }
}

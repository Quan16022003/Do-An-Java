package BLL;

import DAL.ChucNangDAO;
import DTO.ChucNang;
import DTO.CodeCN;
import GUI.QLChamCong.ChamCongForm;
import GUI.QLLuong.QuanLyLuongContent;
import GUI.QLNhanVien.HopDongGUI;
import GUI.QLNhanVien.NhanVienGUI;
import GUI.modal.Content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.c;

public class MainFormBUS {
    private String[] dsTenCN;
    private Map<String, CodeCN> mapTenCN;
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

    public String[] getDsTenCN(String username) {
        if (dsChucNang == null) {
            dsChucNang = dao.selectAllByUsername(username);

            mapTenCN = new HashMap<>();
            dsTenCN = new String[dsChucNang.size()];
            int i = 0;
            for (var cn : dsChucNang) {
                dsTenCN[i++] = cn.getTenCN();
                mapTenCN.put(cn.getTenCN(), cn.getCodeCN());
            }
        }
        return dsTenCN;
    }

    public Content changeContent(String tenCN) {
        switch (mapTenCN.get(tenCN)) {
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
        }
        return null;
    }
}

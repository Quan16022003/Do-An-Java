/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.ChamCongDAO;
import DTO.ChamCong;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ChamCongBUS extends AbstractElementBUS<ChamCong, String>{
    private final ChamCongDAO dao = new ChamCongDAO();
    private List<ChamCong> listChamCong;
    
    
    @Override
    public boolean insert(ChamCong t) {
        return dao.insert(t);
    }

    @Override
    public boolean update(ChamCong t) {
        return dao.update(t);
    }

    @Override
    public boolean delete(String k) {
        return dao.delete(k);
    }

    @Override
    public ChamCong select(String k) {
        return dao.select(k);
    }

    @Override
    public List<ChamCong> selectAll() {
        if (listChamCong == null) {
            listChamCong = dao.selectAll();
        }
        return listChamCong;
    }

    public boolean updateDeleted(ChamCong t) {
        return dao.updateDeleted(t);
    }

    public List<ChamCong> find(String k) {
        return dao.find(k);
    }
    
}

package DTO;

import java.util.Date;

/**
 *
 * @author Luan
 */
public class ChamCong {

    
    private String MaNV,HoTen;
    private int TimeIn,TimeOut;

    private Date NgayThang;
//    public String getID() {
//        return ID;
//    }
//
//    public void setID(String ID) {
//        this.ID = ID;
//    }
    
    public ChamCong( String MaNV, String HoTen, Date NgayThang, int TimeIn,int TimeOut) {
//        this.ID = ID;
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.NgayThang = NgayThang;
        this.TimeIn = TimeIn;
        this.TimeOut = TimeOut;
    }
    public  ChamCong() {
        
    }
    
    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public Date getNgayThang() {
        return NgayThang;
    }

    public void setNgayThang(Date NgayThang) {
        this.NgayThang = NgayThang;
    }

    

    public int getTimeIn() {
        return TimeIn;
    }

    public void setTimeIn(int TimeIn) {
        this.TimeIn = TimeIn;
    }

    public int getTimeOut() {
        return TimeOut;
    }

    public void setTimeOut(int TimeOut) {
        this.TimeOut = TimeOut;
    }

}

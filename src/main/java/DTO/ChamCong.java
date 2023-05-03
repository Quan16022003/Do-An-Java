package DTO;

import java.util.Date;

/**
 *
 * @author Luan
 */
public class ChamCong {

    
    private String MaNV,TimeIn,TimeOut,xacNhan;
    private int Is_deleted;
    private Date NgayThang;

    
    public ChamCong( String MaNV, String xacNhan, Date NgayThang, String TimeIn,String TimeOut,int Is_deleted) {
        this.Is_deleted = Is_deleted;
        this.MaNV = MaNV;
        this.xacNhan = xacNhan;
        this.NgayThang = NgayThang;
        this.TimeIn = TimeIn;
        this.TimeOut = TimeOut;
    }

    public int getIs_deleted() {
        return Is_deleted;
    }

    public void setIs_deleted(int Is_deleted) {
        this.Is_deleted = Is_deleted;
    }
    
    
    public  ChamCong() {
        
    }
    
    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getxacNhan() {
        return xacNhan;
    }

    public void setxacNhan(String xacNhan) {
        this.xacNhan = xacNhan;
    }

    public Date getNgayThang() {
        return NgayThang;
    }

    public void setNgayThang(Date NgayThang) {
        this.NgayThang = NgayThang;
    }

    

    public String getTimeIn() {
        return TimeIn;
    }

    public void setTimeIn(String TimeIn) {
        this.TimeIn = TimeIn;
    }

    public String getTimeOut() {
        return TimeOut;
    }

    public void setTimeOut(String TimeOut) {
        this.TimeOut = TimeOut;
    }

}

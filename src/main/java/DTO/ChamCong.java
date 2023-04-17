package DTO;

import java.time.Duration;
import java.time.LocalTime;

public class ChamCong {
    String maNV;
    String hoTen;
    String gioVao;
    String gioRa;
    String gioCong;
    String xacNhanCong;

    public ChamCong() {
    }

    public ChamCong(String maNV, String gioVao, String gioRa) {
        this.maNV = maNV;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioVao() {
        return gioVao;
    }

    public void setGioVao(String gioVao) {
        this.gioVao = gioVao;
    }

    public String getGioRa() {
        return gioRa;
    }

    public void setGioRa(String gioRa) {
        this.gioRa = gioRa;
    }

    public String getGioCong() {
        return gioCong;
    }

    public void setGioCong(String gioCong) {
        this.gioCong = gioCong;
    }

    public String getXacNhanCong() {
        return xacNhanCong;
    }

    public void setXacNhanCong(String xacNhanCong) {
        this.xacNhanCong = xacNhanCong;
    }

    public void calculateGioCong() {
        Duration duration = Duration.between(LocalTime.parse(gioVao), LocalTime.parse(gioRa));
        this.gioCong = String.format("%02d:%02d", duration.toHours(), duration.toMinutes()%60);
        if (LocalTime.parse(this.gioCong).compareTo(LocalTime.parse("08:00")) >= 1) {
            this.xacNhanCong = "Đủ công";
        } else {
            this.xacNhanCong = "Không đủ công";
        }
    }

    @Override
    public String toString() {
        return String.format("Mã NV: %s, giờ vào: %s, giờ ra: %s, giờ công: %s", getMaNV(), getGioVao(), getGioRa(), getGioCong());
    }
}

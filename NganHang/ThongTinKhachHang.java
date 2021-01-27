/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nganhang;

/**
 *
 * @author ASUS
 */
public class ThongTinKhachHang {
    private long soTaiKhoan;
    private String ten;
    private double soTien;
    public ThongTinKhachHang(){
        
    }

    public ThongTinKhachHang(long soTaiKhoan, String ten, double soTien) {
        this.soTaiKhoan = soTaiKhoan;
        this.ten = ten;
        this.soTien = soTien;
    }
    public long getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(long soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    @Override
    public String toString() {
        return "ThongTinKhachHang{" + "soTaiKhoan=" + soTaiKhoan + ","
                + " ten=" + ten + ","
                + " soTien=" + soTien + '}';
    }
    
    
}

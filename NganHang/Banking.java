/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nganhang;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Banking {
     double laiXuat = 0.005;
     double taiKhoanBanDau = 50000;
    Scanner sc = new Scanner(System.in);
    
    
    
    
    public ThongTinKhachHang ThemKH(){
        ThongTinKhachHang kh = new ThongTinKhachHang();
        System.out.println("Tên khách hàng: ");
        kh.setTen(sc.nextLine());
        System.out.println("Tiền ban đầu: ");
        kh.setSoTien(sc.nextDouble());
        System.out.println("Số tài khoản: ");
        kh.setSoTaiKhoan(sc.nextLong());
        return kh;
    }

    public double KiemTraSoDu(ThongTinKhachHang ttkh){
        return ttkh.getSoTien();
    }
    
    public double NapTien(ThongTinKhachHang ttkh){
       boolean test = true;
       double tienNhapVao;
//       Nap tien vao tai khoan
       while(test){
           test= true;
           System.out.println("Xin moi ban nhap so tien vao: ");
           tienNhapVao = sc.nextDouble();
           if(tienNhapVao < 0){
               System.out.println("Xin mời nhập số tiền lớn hơn 0");
               
           }
           else{
               double themTien = ttkh.getSoTien() + tienNhapVao;
               ttkh.setSoTien(themTien);
               test = false;
           }
       }
       return ttkh.getSoTien();
    }
//    Rut tien ra khoi tai khoan
    public double RutTien(ThongTinKhachHang ttkh){
        boolean test = true;
        double tienMuonRut;
        double anToan=0;
        while(test){
            System.out.println("Số tiền bạn muốn rút: ");
            tienMuonRut = sc.nextDouble();
            anToan =  ttkh.getSoTien() - tienMuonRut - 2;
            if(ttkh.getSoTien() < 50){
                System.out.println("Mời bạn nạp thêm tiền!");
            }
            else if(anToan < 50){
                System.out.println("Số tiền bạn muốn rút ra lớn hơn tài khoản của bạn hoặc tiền bạn rút lớn hơn tiền trong tài khoản");
            }
            else {
                test = false;
                ttkh.setSoTien(anToan);
                System.out.println("Rút tiền thành công");
                
            }
            
        }
//        trả về giá trị của ttkh
        return anToan;
    }
    public void ChuyenTienBank(ThongTinKhachHang ttkh, List<ThongTinKhachHang> listMember){
        boolean test = true;
        long soTaiKhoanDich ;
        int choise;
        while(test){
            ThongTinKhachHang kh2 = new ThongTinKhachHang();
            System.out.println("Nhap so tai khoan muon chuyen: ");
            soTaiKhoanDich  = sc.nextLong();
            for(ThongTinKhachHang x : listMember){
                if(x.getSoTaiKhoan() == soTaiKhoanDich){
                    System.out.println("---------------------------");
                    double moneyOut = RutTien(ttkh);
                    System.out.println("-------  money out "+moneyOut+"--------");
                     x.setSoTien(moneyOut);
                    System.out.println("Tài khoản nguồn: "+RutTien(ttkh));
                    System.out.println("---------------------------");
                    System.out.println("Tài khoản đích"+x.getSoTien());
                    test = false;
                }
                else{
                    System.out.println("Bạn đã nhập sai số tài khoản đích ");
                    break;
                }
            }
            
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nganhang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class NganHang {

    /**
     * @param args the command line arguments
     */
    final static Scanner sc = new Scanner(System.in);
    static List<ThongTinKhachHang> listMember = new ArrayList<ThongTinKhachHang>();
    public static void main(String[] args) {
        // TODO code application logic here
       
        int choise = 0;
        boolean test = true;
        

        while (test) {
            System.out.println("Xin mời lựa chọn");
            System.out.println("1 - Thêm tài khoản ");
            System.out.println("2 - Danh sách các tài khoản đã thêm");
            System.out.println("3- Lựa chọn tài khoản muốn xem");
            System.out.println("4-  Exit");
            System.out.print("Xin mời lựa chọn:       ");
            choise = sc.nextInt();
            Banking bk = new Banking();

            if (choise < 0 || choise > 5) {
                System.out.println("Xin mời bạn nhập lại!");

            }
            switch (choise) {
//                Thêm tài khoản
                case 1:
                    listMember.add(bk.ThemKH());
                    break;
//              Xem danh sách các tài khoản đã thêm
                case 2:
                    for (ThongTinKhachHang x : listMember) {
                        System.out.println(x);
                    }
                    break;
                case 3:
                    long watch = 0;
                    System.out.println("---------------------------");
                    System.out.println("tài khoản muốn xem: ");
                    watch = sc.nextLong();
                    for (int i = 0; i < listMember.size(); i++) {
                        if (listMember.get(i).getSoTaiKhoan() == watch) {
                            System.out.println("Đã chạy vào đây");
                            OrderKhachHang(listMember.get(i));
                            
                        }
                    }
                    System.out.println("*****************************");
                    break;
                case 4:
                    System.out.println("Cám ơn bạn đã dùng dịch vụ của chúng tôi");
                    test = false;

            }
        }
        System.out.println("về nhà ăn tết");
    }

    public static void OrderKhachHang(ThongTinKhachHang banker) {
        int choise = 0;
        
        boolean check = true;
        while(check){
            System.out.println("1- Kiểm tra số dư");
            System.out.println("2- Nạp tiền vào tài khoản");
            System.out.println("3- Rút tiền");
            System.out.println("4- Chuyển tiền vào tài khoản- Banking");
            System.out.println("5 - Exit tool nhỏ");
            System.out.print("Xin mời nhập vào : ");
            choise = sc.nextInt();
            switch (choise) {
//                 Kiem tra so du
                case 1:
                    System.out.println("Kiem tra so du: " + banker.getSoTien());
                    break;
    //                  Nap tien   
                case 2:
                    Banking bk = new Banking();
                    
                    System.out.println("Số tiền trong tài khoản của bạn: " + bk.NapTien(banker));
                    System.out.println("---------------------------");
                    System.out.println("Bạn đã nạp tiền");
                    break;
    //                     Rut tien
                case 3:
                    Banking bk1 = new Banking();
                    
                    System.out.println("Số tiền trong tài khoản của bạn: " + bk1.RutTien(banker));
                    System.out.println("---------------------------");
                    System.out.println("Bạn đã rút tiền");
                    break;
                case 4:
                    Banking bk2 = new Banking();
                    long taiKhoanDich = 0;
                    System.out.println("Số tài khoản đích: ");
                    taiKhoanDich = sc.nextLong();
                    for(int i = 0; i < listMember.size(); i++){
                        if(listMember.get(i).getSoTaiKhoan() == taiKhoanDich){
                            double tienBiRut = bk2.RutTien(banker);
                            System.out.println("Tien bi rut: "+tienBiRut);
                            listMember.get(i).setSoTien(tienBiRut);
                            System.out.println("Tien da duoc nap: "+listMember.get(i).getSoTien());
                            
                        }
                    }
//                    bk2.ChuyenTienBank(banker,taiKhoanDich); 
                    break;
                case 5:
                    System.out.println("Cám ơn bạn đã sử dụng dịch vụ!");
                    check = false;
                    break;
            }
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Object.KhachHang;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class KhachHangData {
    public static PreparedStatement ps;
    public static ResultSet rs;
    
    public KhachHang dangNhap(String taiKhoan, String pass) {
        KhachHang kh = null;
        try{
            ps = Connect.getConnect().prepareStatement("SELECT * FROM Ban_Doc where Ma_Ban_Doc = ? and Password=?");
            ps.setString(1, taiKhoan);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()) {
                kh = new KhachHang();
                kh.setMaBandoc(rs.getString("Ma_Ban_Doc"));
                kh.setPass(rs.getString("Password"));
                kh.setBirth(rs.getDate("Ngay_sinh"));
                kh.setName(rs.getString("Ten_Ban_Doc"));
                kh.setDiaChi(rs.getString("Dia_chi"));
                kh.setPhone(rs.getString("Phone"));
            }
        }
        catch(SQLException e) {
            return kh = null;
        }
        return kh;
    }
    
    
     public static void InsertKhachHang(KhachHang kh) {
        String sql = "insert into Ban_Doc values(?,?,?,?,?,?)";
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, kh.getMaBandoc());
            ps.setString(2, kh.getPass());
            ps.setString(3, kh.getName());
            ps.setDate(4, kh.getBirth());
            ps.setString(5, kh.getDiaChi());
            ps.setString(6, kh.getPhone());
           
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm bạn đọc thành công!" , "Thông báo", 1);
        } catch(HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Bạn đọc không được thêm" , "Thông báo", 2);
        }
    }

    

    
}

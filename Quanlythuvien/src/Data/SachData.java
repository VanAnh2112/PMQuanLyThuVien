/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Object.Sach;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class SachData {
    
    public static PreparedStatement ps;
    public static ResultSet rs;
    
     public static void InsertSach(Sach s) {
        String sql = "insert into SACH values(?,?,?,?,?,?)";
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, s.getMaSach());
            ps.setString(2, s.getTenSach());
            ps.setString(3, s.getTenTacGia());
            ps.setString(4, s.getNhaXB());
            ps.setInt(5, s.getGiaTien());
            ps.setInt(6, s.getSoLuong());
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm sách thành công!" , "Thông báo", 1);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Sach không được thêm" , "Thông báo", 1);
        }
    }
    
  
}

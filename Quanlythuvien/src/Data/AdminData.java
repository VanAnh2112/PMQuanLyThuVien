/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Object.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class AdminData {
    public static PreparedStatement ps;
    public static ResultSet rs;
    
    
    public Admin dangNhap(String taiKhoan, String pass) {
        Admin ad = null;
        try{
            ps = Connect.getConnect().prepareStatement("SELECT * FROM QUAN_TRI where Ma_Admin = ? and Password=?");
            ps.setString(1, taiKhoan);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                ad = new Admin();
                
            }
        }
        catch(SQLException e) {
            return ad = null;
        }
        return ad;
    }
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Drinks_22;
import Utilities.DBUtility_49;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THO
 */
public class DrinksDAO_41 {
    
    private static DrinksDAO_41 instance;
    
    public DrinksDAO_41() {
    }
    
    public static DrinksDAO_41 getInstance() {
        if (instance == null) {
            instance = new DrinksDAO_41();
        }
        return instance;
    }
    
    public List<Drinks_22> GetListDrink() {
        List<Drinks_22> list = new ArrayList<Drinks_22>();
        Connection con = DBUtility_49.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM drinks");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Drinks_22 drinks = new Drinks_22(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5));
                list.add(drinks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DrinksDAO_41.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}

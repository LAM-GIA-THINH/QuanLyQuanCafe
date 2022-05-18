/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Drinks_322;
import Utilities.DBUtility_349;
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
public class DrinksDAO_341 {
    
    private static DrinksDAO_341 instance;
    
    public DrinksDAO_341() {
    }
    
    public static DrinksDAO_341 getInstance() {
        if (instance == null) {
            instance = new DrinksDAO_341();
        }
        return instance;
    }
    
    public List<Drinks_322> GetListDrink() {
        List<Drinks_322> list = new ArrayList<Drinks_322>();
        Connection con = DBUtility_349.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM drinks");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Drinks_322 drinks = new Drinks_322(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5));
                list.add(drinks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DrinksDAO_341.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}

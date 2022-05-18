/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Menu_322;
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
public class MenuDAO_341 {

    private static MenuDAO_341 instance;

    public MenuDAO_341() {
    }

    public static MenuDAO_341 getInstance() {
        if (instance == null) {
            instance = new MenuDAO_341();
        }
        return instance;
    }

    public static void setInstance(MenuDAO_341 instance) {
        MenuDAO_341.instance = instance;
    }

    public List<Menu_322> GetListMenuByTableId(int id) {
        List<Menu_322> list = new ArrayList<Menu_322>();
        Connection con = DBUtility_349.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT drinks.ten_d, orders.counts, drinks.price, orders.counts*drinks.price AS totalPrice FROM orders, invoice, drinks WHERE orders.invoice_ID = invoice.ID_i AND orders.drinks_ID = drinks.ID_d AND invoice.status_i = 0 AND invoice.tables_id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Menu_322 menu = new Menu_322(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
                list.add(menu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO_341.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}

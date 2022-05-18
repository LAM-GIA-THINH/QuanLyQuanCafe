/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Invoices_322;
import DTO.Orders_322;
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
public class OrdersDAO_341 {

    private static OrdersDAO_341 instance;

    public OrdersDAO_341() {
    }

    public static OrdersDAO_341 getInstance() {
        if (instance == null) {
            instance = new OrdersDAO_341();
        }
        return instance;
    }

    public List<Orders_322> ListOrder(int id) {
        List<Orders_322> list = new ArrayList<Orders_322>();
        Connection con = DBUtility_349.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM orders WHERE invoice_ID = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Orders_322 orders = new Orders_322(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
                list.add(orders);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO_341.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Boolean Insert(int drinkId, int invoiceId, int count) {
        Connection con = DBUtility_349.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO orders(drinks_ID, counts, invoice_ID) VALUES (?,?,?)");
            pstmt.setInt(1, drinkId);
            pstmt.setInt(2, count);
            pstmt.setInt(3, invoiceId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO_341.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

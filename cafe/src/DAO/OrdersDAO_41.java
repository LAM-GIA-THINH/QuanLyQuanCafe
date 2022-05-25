/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Invoices_22;
import DTO.Orders_22;
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
public class OrdersDAO_41 {

    private static OrdersDAO_41 instance;

    public OrdersDAO_41() {
    }

    public static OrdersDAO_41 getInstance() {
        if (instance == null) {
            instance = new OrdersDAO_41();
        }
        return instance;
    }

    public List<Orders_22> ListOrder(int id) {
        List<Orders_22> list = new ArrayList<Orders_22>();
        Connection con = DBUtility_49.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM orders WHERE invoice_ID = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Orders_22 orders = new Orders_22(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
                list.add(orders);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO_41.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Boolean Insert(int drinkId, int invoiceId, int count) {
        Connection con = DBUtility_49.getConnection();
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
            Logger.getLogger(MenuDAO_41.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

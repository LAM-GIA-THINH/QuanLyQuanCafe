/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Tables_22;
import GiaoDien.QuanLyBan_40;
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
public class TablesDAO_41 {

    private static TablesDAO_41 instance;

    public TablesDAO_41() {
    }

    public static TablesDAO_41 getInstance() {
        if (instance == null) {
            instance = new TablesDAO_41();
        }
        return instance;
    }

    public static void setInstance(TablesDAO_41 instance) {
        TablesDAO_41.instance = instance;
    }

    public List<Tables_22> LoadListTables() {
        List<Tables_22> listTable = new ArrayList<Tables_22>();

        Connection con = DBUtility_49.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tablez");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Tables_22 tables = new Tables_22(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4) == 0 ? "Còn trống" : "Đã đặt");
                listTable.add(tables);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TablesDAO_41.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTable;
    }
}

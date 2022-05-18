/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Tables_322;
import GiaoDien.QuanLyBan_340;
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
public class TablesDAO_341 {

    private static TablesDAO_341 instance;

    public TablesDAO_341() {
    }

    public static TablesDAO_341 getInstance() {
        if (instance == null) {
            instance = new TablesDAO_341();
        }
        return instance;
    }

    public static void setInstance(TablesDAO_341 instance) {
        TablesDAO_341.instance = instance;
    }

    public List<Tables_322> LoadListTables() {
        List<Tables_322> listTable = new ArrayList<Tables_322>();

        Connection con = DBUtility_349.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tablez");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Tables_322 tables = new Tables_322(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4) == 0 ? "Còn trống" : "Đã đặt");
                listTable.add(tables);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TablesDAO_341.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTable;
    }
}

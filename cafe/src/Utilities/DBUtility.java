/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KHP2T
 */
public class DBUtility {
    public static String databaseName = "ql_cafe";
    public static Connection getConnection() {
    String url = "net.sourceforge.jtds.jdbc.Driver";
        try {
            Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://localhost:1433/" + databaseName;
            return DriverManager.getConnection(dbUrl,"","");
//          return DriverManager.getConnection(dbUrl,user, pass);
        } catch (Exception ex) {
            Logger.getLogger(DBUtility.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static void main(String[] args) {
        DBUtility.getConnection();
    }
}

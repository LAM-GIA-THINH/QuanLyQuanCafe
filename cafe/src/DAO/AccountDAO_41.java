/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Account_22;
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
public class AccountDAO_41 {

    private static AccountDAO_41 instance;
    Account_22 account = new Account_22();

    public AccountDAO_41() {
    }

    public static AccountDAO_41 getInstance() {
        if (instance == null) {
            instance = new AccountDAO_41();
        }
        return instance;
    }

    public static void setInstance(AccountDAO_41 instance) {
        AccountDAO_41.instance = instance;
    }

    public Boolean Login(String username, String password) {
        Connection con = DBUtility_49.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM account WHERE username = ? AND matkhau = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                account.setId(rs.getInt(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setName(rs.getString(4));
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO_41.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Account_22 GetAccount() {
        return account;
    }

    public List<Account_22> listAccount() {
        List<Account_22> list = new ArrayList<Account_22>();
        Connection con = DBUtility_49.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT ID, username, matkhau, ten FROM account");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Account_22 account = new Account_22(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO_41.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Boolean Add(String name, String username, String pass) {
        Connection con = DBUtility_49.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO account(username, matkhau, ten) VALUES (?,?,?)");
            pstmt.setString(1, username);
            pstmt.setString(2, pass);
            pstmt.setString(3, name);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO_41.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean Update(int id, String name, String pass) {
        Connection con = DBUtility_49.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE account SET matkhau=?,ten=? WHERE ID=?");
            pstmt.setString(1, pass);
            pstmt.setString(2, name);
            pstmt.setInt(3, id);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO_41.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean Delete(int id) {
        Connection con = DBUtility_49.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("Delete from account where ID=?");
            pstmt.setInt(1, id);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO_41.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean DoiMatKhau(int id, String pass) {
        Connection con = DBUtility_49.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE account SET matkhau=? WHERE ID=?");
            pstmt.setString(1, pass);
            pstmt.setInt(2, id);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO_41.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

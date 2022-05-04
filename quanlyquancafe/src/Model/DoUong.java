/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author tuanta
 */
public class DoUong {
    private int id;
    private String tenDoUong;
    private String LoaiDoUong;
    private String DonVi;
    private int SoLuong;
    private double giaTien; 

    public DoUong(int id, String tenDoUong, String LoaiDoUong, String DonVi, int SoLuong, double giaTien) {
        this.id = id;
        this.tenDoUong = tenDoUong;
        this.LoaiDoUong = LoaiDoUong;
        this.DonVi = DonVi;
        this.SoLuong = SoLuong;
        this.giaTien = giaTien;
    }

    public DoUong() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDoUong() {
        return tenDoUong;
    }

    public void setTenDoUong(String tenDoUong) {
        this.tenDoUong = tenDoUong;
    }

    public String getLoaiDoUong() {
        return LoaiDoUong;
    }

    public void setLoaiDoUong(String LoaiDoUong) {
        this.LoaiDoUong = LoaiDoUong;
    }

    public String getDonVi() {
        return DonVi;
    }

    public void setDonVi(String DonVi) {
        this.DonVi = DonVi;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }
    
    

}

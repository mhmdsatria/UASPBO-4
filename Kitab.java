/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PembayaranKitab;

/**
 *
 * @author marse
 */
public class Kitab {
    private int idKitab;
    private String namaKitab;
    private double harga;
    private int stock;

    public Kitab(int idKitab, String namaKitab, double harga, int stock) {
        this.idKitab = idKitab;
        this.namaKitab = namaKitab;
        this.harga = harga;
        this.stock = stock;
    }

    public int getIdKitab() {
        return idKitab;
    }

    public void setIdKitab(int idKitab) {
        this.idKitab = idKitab;
    }

    public String getNamaKitab() {
        return namaKitab;
    }

    public void setNamaKitab(String namaKitab) {
        this.namaKitab = namaKitab;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Kitab{" +
                "idKitab=" + idKitab +
                ", namaKitab='" + namaKitab + '\'' +
                ", harga=" + harga +
                ", stock=" + stock +
                '}';
    }
}

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
import java.util.Date;

public class Transaksi {
    private int idTransaksi;
    private int idSantri;
    private int idKitab;
    private int jumlah;
    private Date tanggalTransaksi;

    public Transaksi(int idTransaksi, int idSantri, int idKitab, int jumlah, Date tanggalTransaksi) {
        this.idTransaksi = idTransaksi;
        this.idSantri = idSantri;
        this.idKitab = idKitab;
        this.jumlah = jumlah;
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdSantri() {
        return idSantri;
    }

    public void setIdSantri(int idSantri) {
        this.idSantri = idSantri;
    }

    public int getIdKitab() {
        return idKitab;
    }

    public void setIdKitab(int idKitab) {
        this.idKitab = idKitab;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    @Override
    public String toString() {
        return "Transaksi{" +
                "idTransaksi=" + idTransaksi +
                ", idSantri=" + idSantri +
                ", idKitab=" + idKitab +
                ", jumlah=" + jumlah +
                ", tanggalTransaksi=" + tanggalTransaksi +
                '}';
    }
}


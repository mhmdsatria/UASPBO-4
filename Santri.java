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
public class Santri {
    private int idsantri;
    private String nama;
    private String kobong;

    public Santri(int idsantri, String nama, String kobong) {
        this.idsantri = idsantri;
        this.nama = nama;
        this.kobong = kobong;
    }

    // Getter and setter methods
    public int getIdsantri() {
        return idsantri;
    }

    public void setIdsantri(int idsantri) {
        this.idsantri = idsantri;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKobong() {
        return kobong;
    }

    public void setKobong(String kobong) {
        this.kobong = kobong;
    }

    @Override
    public String toString() {
        return "Santri{" +
                "idsantri=" + idsantri +
                ", nama='" + nama + '\'' +
                ", kobong='" + kobong + '\'' +
                '}';
    }
}


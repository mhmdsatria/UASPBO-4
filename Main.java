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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu Utama:");
            System.out.println("1. Tambah Data Santri");
            System.out.println("2. Tambah Data Kitab");
            System.out.println("3. Tambah Transaksi");
            System.out.println("4. Lihat Data Santri");
            System.out.println("5. Lihat Data Kitab");
            System.out.println("6. Lihat Data Transaksi");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (pilihan) {
                case 1:
                    tambahDataSantri();
                    break;
                case 2:
                    tambahDataKitab();
                    break;
                case 3:
                    tambahTransaksi();
                    break;
                case 4:
                    lihatDataSantri();
                    break;
                case 5:
                    lihatDataKitab();
                    break;
                case 6:
                    lihatDataTransaksi();
                    break;
                case 7:
                    System.out.println("Keluar...");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void tambahDataSantri() {
        System.out.print("Nama Santri: ");
        String nama = scanner.nextLine();
        System.out.print("Kobong/Kamar: ");
        String kobong = scanner.nextLine();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO santri (nama, kobong) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nama);
            stmt.setString(2, kobong);
            stmt.executeUpdate();
            System.out.println("Data santri berhasil ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void tambahDataKitab() {
        System.out.print("Nama Kitab: ");
        String namaKitab = scanner.nextLine();
        System.out.print("Harga: ");
        double harga = scanner.nextDouble();
        System.out.print("Stok: ");
        int stock = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO kitab (namakitab, harga, stock) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, namaKitab);
            stmt.setDouble(2, harga);
            stmt.setInt(3, stock);
            stmt.executeUpdate();
            System.out.println("Data kitab berhasil ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void tambahTransaksi() {
        System.out.print("ID Santri: ");
        int idSantri = scanner.nextInt();
        System.out.print("ID Kitab: ");
        int idKitab = scanner.nextInt();
        System.out.print("Jumlah: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Date tanggalTransaksi = new Date(); // Tanggal transaksi hari ini

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO transaksi (idsantri, idkitab, jumlah, tanggal_transaksi) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idSantri);
            stmt.setInt(2, idKitab);
            stmt.setInt(3, jumlah);
            stmt.setDate(4, new java.sql.Date(tanggalTransaksi.getTime()));
            stmt.executeUpdate();
            System.out.println("Transaksi berhasil ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void lihatDataSantri() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM santri";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Data Santri:");
            while (rs.next()) {
                int idSantri = rs.getInt("idsantri");
                String nama = rs.getString("nama");
                String kobong = rs.getString("kobong");
                System.out.println(idSantri + "\t" + nama + "\t" + kobong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void lihatDataKitab() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM kitab";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Data Kitab:");
            while (rs.next()) {
                int idKitab = rs.getInt("idkitab");
                String namaKitab = rs.getString("namakitab");
                double harga = rs.getDouble("harga");
                int stock = rs.getInt("stock");
                System.out.println(idKitab + "\t" + namaKitab + "\t" + harga + "\t" + stock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void lihatDataTransaksi() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT transaksi.idtransaksi, santri.nama AS nama_santri, kitab.namakitab, transaksi.jumlah, transaksi.tanggal_transaksi " +
                         "FROM transaksi " +
                         "JOIN santri ON transaksi.idsantri = santri.idsantri " +
                         "JOIN kitab ON transaksi.idkitab = kitab.idkitab";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Data Transaksi:");
            while (rs.next()) {
                int idtransaksi = rs.getInt("idtransaksi");
                String namaSantri = rs.getString("nama_santri");
                String namaKitab = rs.getString("namakitab");
                int jumlah = rs.getInt("jumlah");
                Date tanggalTransaksi = rs.getDate("tanggal_transaksi");
                System.out.println(idtransaksi + "\t" + namaSantri + "\t" + namaKitab + "\t" + jumlah + "\t" + tanggalTransaksi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author ACER NITRO
 */

import java.util.ArrayList;
import java.util.Scanner;
import models.JadwalRoket;

public class RoketService {
    private ArrayList<JadwalRoket> daftarJadwal = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    // CREATE
    public void tambahJadwal() {
        System.out.print("Masukkan ID Roket: ");
        int id = input.nextInt();
        input.nextLine();

        // Validasi ID unik
        for (JadwalRoket jr : daftarJadwal) {
            if (jr.getId() == id) {
                System.out.println("⚠ ID sudah digunakan!");
                return;
            }
        }

        System.out.print("Masukkan Nama Roket: ");
        String namaRoket = input.nextLine();
        System.out.print("Masukkan Tujuan: ");
        String tujuan = input.nextLine();
        System.out.print("Masukkan Tanggal Peluncuran: ");
        String tanggal = input.nextLine();
        System.out.print("Masukkan Status (Terjadwal/Ditunda/Selesai): ");
        String status = input.nextLine();

        daftarJadwal.add(new JadwalRoket(id, namaRoket, tujuan, tanggal, status));
        System.out.println("✅ Jadwal berhasil ditambahkan!");
    }

    // READ
    public void lihatJadwal() {
        if (daftarJadwal.isEmpty()) {
            System.out.println("⚠ Belum ada jadwal penerbangan!");
        } else {
            System.out.println("\n----- Daftar Jadwal Roket -----");
            for (JadwalRoket jr : daftarJadwal) {
                System.out.println(jr.getId() + " | " + jr.getNamaRoket() + " | " + jr.getTujuan() +
                        " | " + jr.getTanggal() + " | " + jr.getStatus());
            }
        }
    }

    // UPDATE
    public void updateJadwal() {
        lihatJadwal();
        if (daftarJadwal.isEmpty()) return;

        System.out.print("Masukkan ID Roket yang ingin diupdate: ");
        int updateId = input.nextInt();
        input.nextLine();

        for (JadwalRoket jr : daftarJadwal) {
            if (jr.getId() == updateId) {
                System.out.println("Pilih yang ingin diubah:");
                System.out.println("[1] Nama Roket");
                System.out.println("[2] Tujuan");
                System.out.println("[3] Tanggal");
                System.out.println("[4] Status");
                int pilih = input.nextInt();
                input.nextLine();

                switch (pilih) {
                    case 1 -> { System.out.print("Nama baru: "); jr.setNamaRoket(input.nextLine()); }
                    case 2 -> { System.out.print("Tujuan baru: "); jr.setTujuan(input.nextLine()); }
                    case 3 -> { System.out.print("Tanggal baru: "); jr.setTanggal(input.nextLine()); }
                    case 4 -> { System.out.print("Status baru: "); jr.setStatus(input.nextLine()); }
                    default -> { System.out.println("⚠ Pilihan tidak valid!"); return; }
                }
                System.out.println("✅ Jadwal berhasil diperbarui!");
                return;
            }
        }
        System.out.println("⚠ ID tidak ditemukan!");
    }

    // DELETE
    public void hapusJadwal() {
        lihatJadwal();
        if (daftarJadwal.isEmpty()) return;

        System.out.print("Masukkan ID Roket yang ingin dihapus: ");
        int hapusId = input.nextInt();
        input.nextLine();

        for (int i = 0; i < daftarJadwal.size(); i++) {
            if (daftarJadwal.get(i).getId() == hapusId) {
                daftarJadwal.remove(i);
                System.out.println("✅ Jadwal berhasil dihapus!");
                return;
            }
        }
        System.out.println("⚠ Jadwal tidak ditemukan!");
    }

    // SEARCH
    public void cariJadwal() {
        System.out.print("Masukkan nama roket yang ingin dicari: ");
        String keyword = input.nextLine().toLowerCase();

        boolean ditemukan = false;
        for (JadwalRoket jr : daftarJadwal) {
            if (jr.getNamaRoket().toLowerCase().contains(keyword)) {
                System.out.println(jr.getId() + " | " + jr.getNamaRoket() + " | " + jr.getTujuan() +
                        " | " + jr.getTanggal() + " | " + jr.getStatus());
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("⚠ Jadwal dengan nama tersebut tidak ditemukan!");
        }
    }
}

    


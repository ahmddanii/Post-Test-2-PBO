package models;

public class JadwalRoket {
    private int id;
    private String namaRoket;
    private String tujuan;
    private String tanggal;
    private String status;

    // Constructor
    public JadwalRoket(int id, String namaRoket, String tujuan, String tanggal, String status) {
        this.id = id;
        this.namaRoket = namaRoket;
        this.tujuan = tujuan;
        this.tanggal = tanggal;
        this.status = status;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public String getNamaRoket() {
        return namaRoket;
    }

    public void setNamaRoket(String namaRoket) {
        this.namaRoket = namaRoket;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

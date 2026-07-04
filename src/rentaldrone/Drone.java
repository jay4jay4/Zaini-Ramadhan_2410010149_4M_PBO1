package rentaldrone;

public abstract class Drone {

    private String nama;
    private double hargaSewa;

    public Drone(String nama, double hargaSewa) {
        this.nama = nama;
        this.hargaSewa = hargaSewa;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHargaSewa() {
        return hargaSewa;
    }

    public void setHargaSewa(double hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    public abstract double hitungBiaya(int hari);

    public abstract String getJenis();
}
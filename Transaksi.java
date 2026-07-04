package rentaldrone;

import java.io.FileWriter;
import java.io.IOException;

public class Transaksi {

    private Penyewa penyewa;
    private Drone drone;
    private int lamaSewa;

    public Transaksi(Penyewa penyewa, Drone drone, int lamaSewa) {
        this.penyewa = penyewa;
        this.drone = drone;
        this.lamaSewa = lamaSewa;
    }

    public double hitungTotal() {
        return drone.hitungBiaya(lamaSewa);
    }

    public void simpanFile() {

        try {

            FileWriter fw = new FileWriter("transaksi.txt", true);

            fw.write("============================\n");
            fw.write("Nama : " + penyewa.getNama() + "\n");
            fw.write("No HP : " + penyewa.getNoHp() + "\n");
            fw.write("Drone : " + drone.getNama() + "\n");
            fw.write("Jenis : " + drone.getJenis() + "\n");
            fw.write("Lama : " + lamaSewa + " hari\n");
            fw.write("Total : Rp" + hitungTotal() + "\n");
            fw.write("============================\n\n");

            fw.close();

        } catch (IOException e) {
            System.out.println("Gagal menyimpan file!");
        }

    }

}
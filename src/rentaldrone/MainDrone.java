package rentaldrone;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainDrone {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Array
        Drone[] daftarDrone = new Drone[4];

        // Membuat objek Drone Kamera
        daftarDrone[0] = new DroneKamera("DJI Mini 4 Pro", 250000);
        daftarDrone[1] = new DroneKamera("DJI Air 3S", 400000);

        // Membuat objek Drone FPV
        daftarDrone[2] = new DroneFPV("DJI Avata 2", 300000);
        daftarDrone[3] = new DroneFPV("BetaFPV Cetus X", 150000);

        int pilihan;
        // Perulangan
        do {
            System.out.println("\n=================================");
            System.out.println("      RENTAL DRONE NUSANTARA");
            System.out.println("=================================");
            System.out.println("1. Lihat Daftar Drone");
            System.out.println("2. Sewa Drone");
            System.out.println("3. Keluar");
            System.out.print("Pilih Menu : ");
            try {
                // Menerima input menu
                pilihan = input.nextInt();
                input.nextLine();
                // Seleksi Menu
                switch (pilihan) {
                    // MENU 1
                    case 1:
                        System.out.println("\n===== DAFTAR DRONE =====");
                        // Perulangan untuk menampilkan isi array
                        for (int i = 0; i < daftarDrone.length; i++) {
                            System.out.println((i + 1) + ". " + daftarDrone[i].getNama());
                            System.out.println("   Jenis : " + daftarDrone[i].getJenis());
                            System.out.println("   Harga : Rp" + daftarDrone[i].getHargaSewa());
                            System.out.println();
                        }
                        break;
                    // MENU 2
                    case 2:
                        String nama;
                        String hp;

                        // Validasi Nama
                        do {
                            System.out.print("Nama Penyewa : ");
                            nama = input.nextLine().trim();

                            if (!nama.matches("[a-zA-Z ]+")) {
                                System.out.println("Nama hanya boleh berisi huruf dan spasi!");
                            }

                        } while (!nama.matches("[a-zA-Z ]+"));

                        // Validasi Nomor HP
                        do {
                            System.out.print("No HP : ");
                            hp = input.nextLine().trim();

                            if (!hp.matches("\\d{10,15}")) {
                                System.out.println("Nomor HP hanya boleh angka (10-15 digit)!");
                            }

                        } while (!hp.matches("\\d{10,15}"));

                        // Membuat objek Penyewa
                        Penyewa penyewa = new Penyewa(nama, hp);

                        System.out.println("\n===== PILIH DRONE =====");

                        // Menampilkan pilihan drone
                        for (int i = 0; i < daftarDrone.length; i++) {
                            System.out.println((i + 1) + ". "
                                    + daftarDrone[i].getNama()
                                    + " (" + daftarDrone[i].getJenis() + ")");
                        }

                        System.out.print("Pilih Drone : ");
                        int pilihDrone = input.nextInt();

                        // Validasi nomor drone
                        if (pilihDrone < 1 || pilihDrone > daftarDrone.length) {
                            System.out.println("Pilihan tidak tersedia!");
                            break;
                        }

                        System.out.print("Lama Sewa (hari) : ");
                        int hari = input.nextInt();

                        // Mengambil objek drone sesuai pilihan user
                        Drone drone = daftarDrone[pilihDrone - 1];

                        Transaksi transaksi = new Transaksi(penyewa, drone, hari);

                        // Menampilkan hasil transaksi
                        System.out.println("\n========== STRUK ==========");
                        System.out.println("Nama Penyewa : " + penyewa.getNama());
                        System.out.println("No HP        : " + penyewa.getNoHp());
                        System.out.println("Drone        : " + drone.getNama());
                        System.out.println("Jenis        : " + drone.getJenis());
                        System.out.println("Harga/Hari   : Rp" + drone.getHargaSewa());
                        System.out.println("Lama Sewa    : " + hari + " hari");
                        System.out.println("Total Bayar  : Rp" + transaksi.hitungTotal());
                        System.out.println("===========================");

                        // Menyimpan transaksi ke file transaksi.txt
                        transaksi.simpanFile();

                        System.out.println("Transaksi berhasil disimpan ke transaksi.txt");

                        break;
                    // Keluar
                    case 3:

                        System.out.println("Terima kasih telah menggunakan Rental Drone.");

                        break;

                    // Jika menu tidak tersedia
                    default:

                        System.out.println("Menu tidak tersedia.");
                }
            }
            // ERROR HANDLING
            catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                input.nextLine();
                pilihan = 0;
            }
        } while (pilihan != 3);

    }

}
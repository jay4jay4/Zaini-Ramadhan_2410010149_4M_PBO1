# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah contoh sederhana aplikasi pengolahan data mahasiswa menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi **Rental Drone Nusantara** merupakan program berbasis Java yang digunakan untuk melakukan proses penyewaan drone. Pengguna dapat melihat daftar drone yang tersedia, memasukkan data penyewa berupa nama dan nomor HP, memilih jenis drone, serta menentukan lama penyewaan. Setelah transaksi selesai, aplikasi akan menghitung total biaya sewa berdasarkan jenis drone yang dipilih, menampilkan struk transaksi, dan menyimpan data transaksi ke dalam file `transaksi.txt`.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam Pemrograman Berorientasi Objek (OOP), seperti **Class, Object, Atribut, Constructor, Method Accessor (Getter), Method Mutator (Setter), Encapsulation, Inheritance, Polymorphism (Overriding), Abstract Class, Seleksi, Perulangan, Array, IO Sederhana (File I/O), dan Error Handling**.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `Drone`, `DroneFPV`, `DroneKamera`, `Transaksi`, `Penyewa`, dan `MainDrone` adalah contoh dari class.

```bash
public abstract class Drone {
    ...
}

public class DroneFPV extends Drone {
    ...
}

public class DroneKamera extends Drone {
    ...
}

public class Penyewa {
    ...
}

public class Transaksi {
    ...
}

public class MainDrone {
    ...
}
```

2. **Object** adalah instance dari class. Pada kode ini, `daftarDrone[0] = new DroneKamera("DJI Mini 4 Pro", 250000);, Penyewa penyewa = new Penyewa(nama, hp);, Transaksi transaksi = new Transaksi(penyewa, drone, hari);` adalah contoh pembuatan object.

```bash
daftarDrone[0] = new DroneKamera("DJI Mini 4 Pro", 250000);
daftarDrone[1] = new DroneKamera("DJI Air 3S", 400000);
daftarDrone[2] = new DroneFPV("DJI Avata 2", 300000);
daftarDrone[3] = new DroneFPV("BetaFPV Cetus X", 150000);

Penyewa penyewa = new Penyewa(nama, hp);

Transaksi transaksi = new Transaksi(penyewa, drone, hari);
```

3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `nama`, `hargaSewa`, `noHp`, `drone`, `lamaSewa`, dan `penyewa` adalah contoh atribut.

```bash
    class Drone
    String nama;
    double hargaSewa;

    class Penyewa
    String nama;
    String noHp;

    class Transaksi
    Penyewa penyewa;
    Drone drone;
    int lamaSewa;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class `Drone`, `DroneFPV`, `DroneKamera`, `Transaksi`, `Penyewa`.

```bash
    public Drone(String nama, double hargaSewa) {
        this.nama = nama;
        this.hargaSewa = hargaSewa;
    }

    public DroneFPV(String nama, double hargaSewa) {
        super(nama, hargaSewa);
    }

    public DroneKamera(String nama, double hargaSewa) {
        super(nama, hargaSewa);
    }

    public Penyewa(String nama, String noHp) {
        this.nama = nama;
        this.noHp = noHp;
    }

    public Transaksi(Penyewa penyewa, Drone drone, int lamaSewa) {
        this.penyewa = penyewa;
        this.drone = drone;
        this.lamaSewa = lamaSewa;
    }
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setNama`, `setHargaSewa`, dan `setNoHp` adalah contoh method mutator.

```bash
    class Drone
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHargaSewa(double hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    class Penyewa
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getNama`, `getHargaSewa`, `getJenis`, dan `getNoHp` adalah contoh method accessor.

```bash
    class Drone
    public String getNama() {
        return nama;
    }

    public double getHargaSewa() {
        return hargaSewa;
    }

    public abstract String getJenis();

    class DroneFPV
    @Override
    public String getJenis() {
        return "Drone FPV";
    }

    class DroneKamera
    @Override
    public String getJenis() {
        return "Drone Kamera";
    }

    class Penyewa
    public String getNama() {
        return nama;
    }

    public String getNoHp() {
        return noHp;
    }

```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, atribut `nama`, `hargaSewa`, `noHp`, `penyewa`, `drone`, dan `lamaSewa` dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.

```bash
    class Drone
    private String nama;
    private double hargaSewa;

    class Penyewa
    private String nama;
    private String noHp;

    class Transaksi
    private Penyewa penyewa;
    private Drone drone;
    private int lamaSewa;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `DroneFPV` dan `DroneKamera` mewarisi `Drone` dengan sintaks `extends`.

```bash
public class DroneFPV extends Drone {
    ...
}

public class DroneKamera extends Drone {
    ...
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Ini memungkinkan metode-metode dengan nama yang sama untuk berperilaku berbeda tergantung pada tipe objek yang mereka manipulasi, polymorphism bisa berbentuk Overloading ataupun Overriding. Pada program ini, polymorphism diterapkan menggunakan method overriding, yaitu method `getJenis()` yang dideklarasikan sebagai abstract method pada class `Drone`, kemudian dioverride oleh class  `DroneFPV` dan `DroneKamera`. Meskipun nama method sama, hasil yang dikembalikan berbeda sesuai dengan jenis objek yang dipanggil.

```bash
    public abstract String getJenis();

    class DroneFPV
    @Override
    public String getJenis() {
        return "Drone FPV";
    }

    class DroneKamera
    @Override
    public String getJenis() {
        return "Drone Kamera";
    }
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada program ini, seleksi diterapkan menggunakan `switch` untuk menentukan menu yang dipilih pengguna, serta `if` untuk melakukan validasi data yang diinput pengguna, seperti nama penyewa, nomor HP, dan pilihan drone. Jika data yang dimasukkan tidak sesuai dengan ketentuan, program akan menampilkan pesan kesalahan dan meminta pengguna menginput kembali.

```bash
// Seleksi menu menggunakan switch
switch (pilihan) {
    case 1:
        // Menampilkan daftar drone
        break;

    case 2:
        // Proses penyewaan drone
        break;

    case 3:
        System.out.println("Terima kasih telah menggunakan Rental Drone.");
        break;

    default:
        System.out.println("Menu tidak tersedia.");
}

//Validasi Nama
if (!nama.matches("[a-zA-Z ]+")) {
    System.out.println("Nama hanya boleh berisi huruf dan spasi!");
}

//Validasi NoHp
if (!hp.matches("\\d{10,15}")) {
    System.out.println("Nomor HP hanya boleh angka (10-15 digit)!");
}

// Seleksi menggunakan if
if (pilihDrone < 1 || pilihDrone > daftarDrone.length) {
    System.out.println("Pilihan tidak tersedia!");
    break;
}
```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada program ini, digunakan `for` untuk menampilkan seluruh daftar drone yang tersimpan dalam array, serta  `do-while` untuk menampilkan menu utama secara berulang hingga pengguna memilih menu keluar. Selain itu, do-while juga digunakan untuk melakukan validasi input nama penyewa dan nomor HP sehingga program akan terus meminta input sampai data yang dimasukkan sesuai dengan ketentuan.
```bash
for (int i = 0; i < daftarDrone.length; i++) {
    System.out.println((i + 1) + ". " + daftarDrone[i].getNama());
    System.out.println("   Jenis : " + daftarDrone[i].getJenis());
    System.out.println("   Harga : Rp" + daftarDrone[i].getHargaSewa());
    System.out.println();
}

do {
    System.out.println("\n=================================");
    System.out.println("      RENTAL DRONE NUSANTARA");
    System.out.println("=================================");
    System.out.println("1. Lihat Daftar Drone");
    System.out.println("2. Sewa Drone");
    System.out.println("3. Keluar");

    // proses menu

} while (pilihan != 3);

do {
    System.out.print("Nama Penyewa : ");
    nama = input.nextLine().trim();

    if (!nama.matches("[a-zA-Z ]+")) {
        System.out.println("Nama hanya boleh berisi huruf dan spasi!");
    }

} while (!nama.matches("[a-zA-Z ]+"));

do {
    System.out.print("No HP : ");
    hp = input.nextLine().trim();

    if (!hp.matches("\\d{10,15}")) {
        System.out.println("Nomor HP hanya boleh angka (10-15 digit)!");
    }

} while (!hp.matches("\\d{10,15}"));
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada program ini, digunakan class Scanner untuk menerima input seperti pilihan menu, nama penyewa, nomor HP, pilihan drone, dan lama sewa. Sementara itu, method `System.out.print()` dan `System.out.println()` digunakan untuk menampilkan menu, daftar drone, serta hasil transaksi kepada pengguna.

```bash
Scanner input = new Scanner(System.in);

System.out.print("Pilih Menu : ");
int pilihan = input.nextInt();

System.out.print("Nama Penyewa : ");
String nama = input.nextLine();

System.out.print("No HP : ");
String hp = input.nextLine();

System.out.println("\n========== STRUK ==========");
System.out.println("Nama Penyewa : " + penyewa.getNama());
System.out.println("No HP        : " + penyewa.getNoHp());
System.out.println("Drone        : " + drone.getNama());
System.out.println("Jenis        : " + drone.getJenis());
System.out.println("Harga/Hari   : Rp" + drone.getHargaSewa());
System.out.println("Lama Sewa    : " + hari + " hari");
System.out.println("Total Bayar  : Rp" + transaksi.hitungTotal());
System.out.println("===========================");
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada program ini, `array` digunakan untuk menyimpan daftar objek `Drone`, yang terdiri dari beberapa jenis drone, yaitu `DroneKamera` dan `DroneFPV`. Dengan menggunakan array, program dapat mengelola dan menampilkan seluruh data drone menggunakan perulangan

```bash
// Array
Drone[] daftarDrone = new Drone[4];

// Membuat objek Drone Kamera
daftarDrone[0] = new DroneKamera("DJI Mini 4 Pro", 250000);
daftarDrone[1] = new DroneKamera("DJI Air 3S", 400000);

// Membuat objek Drone FPV
daftarDrone[2] = new DroneFPV("DJI Avata 2", 300000);
daftarDrone[3] = new DroneFPV("BetaFPV Cetus X", 150000);
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada program ini, digunakan blok `try-catch` untuk menangani dua jenis error, yaitu `InputMismatchException` ketika pengguna memasukkan input yang tidak sesuai dengan tipe data yang diharapkan, serta `IOException` ketika terjadi kesalahan saat proses penyimpanan data transaksi ke dalam file `transaksi.txt`.
```
try {
    pilihan = input.nextInt();
    input.nextLine();

    switch (pilihan) {
        case 1:
            // Menampilkan daftar drone
            break;

        case 2:
            // Proses penyewaan drone
            break;

        case 3:
            System.out.println("Terima kasih telah menggunakan Rental Drone.");
            break;

        default:
            System.out.println("Menu tidak tersedia.");
    }

} catch (InputMismatchException e) {
    System.out.println("Input harus berupa angka!");
    input.nextLine();
    pilihan = 0;
}

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
```

## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Zaini Ramadhan
NPM: 2410010149

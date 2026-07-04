package rentaldrone;

public class DroneKamera extends Drone {

    public DroneKamera(String nama, double hargaSewa) {
        super(nama, hargaSewa);
    }

    @Override
    public double hitungBiaya(int hari) {
        return (getHargaSewa() * hari) + 50000;
    }

    @Override
    public String getJenis() {
        return "Drone Kamera";
    }
}
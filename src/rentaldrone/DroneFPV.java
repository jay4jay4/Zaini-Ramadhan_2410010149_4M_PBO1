package rentaldrone;

public class DroneFPV extends Drone {

    public DroneFPV(String nama, double hargaSewa) {
        super(nama, hargaSewa);
    }

    @Override
    public double hitungBiaya(int hari) {
        return (getHargaSewa() * hari) + 30000;
    }

    @Override
    public String getJenis() {
        return "Drone FPV";
    }
}
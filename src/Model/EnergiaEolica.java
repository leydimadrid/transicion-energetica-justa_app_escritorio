package Model;

public class EnergiaEolica extends EnergiaRenovable {
    private double capacidadRotor;
    private int cantidadRotores;
    private double velocidadViento;


    public EnergiaEolica() {
    }

    public EnergiaEolica(String nombreFuente, double capacidadRotor, int cantidadRotores, double velocidadViento) {
        super(nombreFuente);
        this.capacidadRotor = capacidadRotor;
        this.cantidadRotores = cantidadRotores;
        this.velocidadViento = velocidadViento;
    }

    public double getCapacidadRotor() {
        return capacidadRotor;
    }

    public void setCapacidadRotor(double capacidadRotor) {
        this.capacidadRotor = capacidadRotor;
    }

    public int getCantidadRotores() {
        return cantidadRotores;
    }

    public void setCantidadRotores(int cantidadRotores) {
        this.cantidadRotores = cantidadRotores;
    }

    public double getVelocidadViento() {
        return velocidadViento;
    }

    public void setVelocidadViento(double velocidadViento) {
        this.velocidadViento = velocidadViento;
    }

    @Override
    public String toString() {
        return "EnergiaEolica{" +
                "capacidadRotor=" + capacidadRotor +
                ", cantidadRotores=" + cantidadRotores +
                ", velocidadViento=" + velocidadViento +
                ", nombreFuente='" + nombreFuente + '\'' +
                '}';
    }
}
package Model;

import java.time.LocalDate;

public class EnergiaEolica extends EnergiaRenovable {
    private double capacidadRotor;
    private int cantidadRotores;
    private double velocidadViento;
    private int anio;


    public EnergiaEolica() {
    }

    public EnergiaEolica(String nombreFuente, double capacidadRotor, int cantidadRotores, double velocidadViento, int anio) {
        super(nombreFuente);
        this.capacidadRotor = capacidadRotor;
        this.cantidadRotores = cantidadRotores;
        this.velocidadViento = velocidadViento;
        this.anio = anio;
    }


    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
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

}
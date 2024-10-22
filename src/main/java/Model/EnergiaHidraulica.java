package Model;

public class EnergiaHidraulica extends EnergiaRenovable {
    private double factorEnergetico;
    private int cantidadTurbinas;
    private double capacidadTurbina;

    public EnergiaHidraulica() {
    }

    public EnergiaHidraulica(String nombreFuente, double factorEnergetico, int cantidadTurbinas, double capacidadTurbina) {
        super(nombreFuente);
        this.factorEnergetico = factorEnergetico;
        this.cantidadTurbinas = cantidadTurbinas;
        this.capacidadTurbina = capacidadTurbina;
    }

    public double getFactorEnergetico() {
        return factorEnergetico;
    }

    public void setFactorEnergetico(double factorEnergetico) {
        this.factorEnergetico = factorEnergetico;
    }

    public int getCantidadTurbinas() {
        return cantidadTurbinas;
    }

    public void setCantidadTurbinas(int cantidadTurbinas) {
        this.cantidadTurbinas = cantidadTurbinas;
    }

    public double getCapacidadTurbina() {
        return capacidadTurbina;
    }

    public void setCapacidadTurbina(double capacidadTurbina) {
        this.capacidadTurbina = capacidadTurbina;
    }

    @Override
    public String toString() {
        return "EnergiaHidraulica{" +
                "factorEnergetico=" + factorEnergetico +
                ", cantidadTurbinas=" + cantidadTurbinas +
                ", capacidadTurbina=" + capacidadTurbina +
                ", nombreFuente='" + nombreFuente + '\'' +
                '}';
    }
}
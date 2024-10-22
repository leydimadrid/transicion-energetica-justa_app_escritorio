package Model;

public class Biomasa extends EnergiaRenovable {
    private double factorEnergetico;
    private String tipoMasa;

    public Biomasa() {
    }

    @Override
    public double calcularProduccion() {
        return 0;
    }

    @Override
    public double calcularConsumo() {
        return 0;
    }

    public Biomasa(String nombreFuente, double factorEnergetico, String tipoMasa) {
        super(nombreFuente);
        this.factorEnergetico = factorEnergetico;
        this.tipoMasa = tipoMasa;
    }

    public double getFactorEnergetico() {
        return factorEnergetico;
    }

    public void setFactorEnergetico(double factorEnergetico) {
        this.factorEnergetico = factorEnergetico;
    }

    public String getTipoMasa() {
        return tipoMasa;
    }

    public void setTipoMasa(String tipoMasa) {
        this.tipoMasa = tipoMasa;
    }

    @Override
    public String toString() {
        return "Biomasa{" +
                "factorEnergetico=" + factorEnergetico +
                ", tipoMasa='" + tipoMasa + '\'' +
                ", nombreFuente='" + nombreFuente + '\'' +
                '}';
    }
}
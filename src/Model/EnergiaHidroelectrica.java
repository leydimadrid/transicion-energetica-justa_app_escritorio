package Model;
public class EnergiaHidroelectrica extends EnergiaRenovable {
    private double capacidadEmbalse;
    private double caudal;


    public EnergiaHidroelectrica() {
    }

    public EnergiaHidroelectrica(int id, Localizacion localizacion, String nombre, int ano, double produccionAnual, double consumoAnual, double capacidadInstalada, boolean compartida, double eficiencia, double capacidadEmbalse, double caudal) {
        super(id, localizacion, nombre, ano, produccionAnual, consumoAnual, capacidadInstalada, compartida, eficiencia);
        this.capacidadEmbalse = capacidadEmbalse;
        this.caudal = caudal;
    }

    public double getCapacidadEmbalse() {
        return capacidadEmbalse;
    }

    public void setCapacidadEmbalse(double capacidadEmbalse) {
        this.capacidadEmbalse = capacidadEmbalse;
    }

    public double getCaudal() {
        return caudal;
    }

    public void setCaudal(double caudal) {
        this.caudal = caudal;
    }

    @Override
    public double calcularProduccion() {
        return capacidadEmbalse * 365;
    }

    @Override
    public double calcularConsumo() {
        return capacidadEmbalse * 0.75 * 365;
    }

    @Override
    public String toString() {
        return "EnergiaHidroelectrica{" +
                "caudal=" + caudal +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ano=" + ano +
                ", produccionAnual=" + produccionAnual +
                ", consumoAnual=" + consumoAnual +
                ", capacidadInstalada=" + capacidadInstalada +
                ", compartida=" + compartida +
                ", eficiencia=" + eficiencia +
                ", capacidadEmbalse=" + capacidadEmbalse +
                '}';
    }
}
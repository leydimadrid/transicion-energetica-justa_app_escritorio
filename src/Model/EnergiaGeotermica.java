package Model;

public class EnergiaGeotermica extends EnergiaRenovable {
    private double factorGeotermico;


    public EnergiaGeotermica() {
    }

    public EnergiaGeotermica(String nombreFuente, double factorGeotermico) {
        super(nombreFuente);
        this.factorGeotermico = factorGeotermico;
    }

    public double getFactorGeotermico() {
        return factorGeotermico;
    }

    public void setFactorGeotermico(double factorGeotermico) {
        this.factorGeotermico = factorGeotermico;
    }

    @Override
    public String toString() {
        return "EnergiaGeotermica{" +
                "nombreFuente='" + nombreFuente + '\'' +
                ", factorGeotermico=" + factorGeotermico +
                '}';
    }
}
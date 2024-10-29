package Model;

public class EnergiaSolar extends EnergiaRenovable {
    private double factorLuminiscencia;

    public EnergiaSolar() {
    }

    public EnergiaSolar(String nombreFuente, double factorLuminiscencia) {
        super(nombreFuente);
        this.factorLuminiscencia = factorLuminiscencia;
    }

    public double getFactorLuminiscencia() {
        return factorLuminiscencia;
    }

    public void setFactorLuminiscencia(double factorLuminiscencia) {
        this.factorLuminiscencia = factorLuminiscencia;
    }

    @Override
    public String toString() {
        return "EnergiaSolar{" +
                "factorLuminiscencia=" + factorLuminiscencia +
                ", nombreFuente='" + nombreFuente + '\'' +
                '}';
    }
}
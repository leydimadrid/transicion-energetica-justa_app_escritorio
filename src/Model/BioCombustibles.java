
package Model;
public class BioCombustibles extends EnergiaRenovable {
    private String tipoBiocombustible;

    public BioCombustibles() {
    }

    public BioCombustibles(int id, Localizacion localizacion, String nombre, int ano, double produccionAnual, double consumoAnual, double capacidadInstalada, boolean compartida, double eficiencia, String tipoBiocombustible) {
        super(id, localizacion, nombre, ano, produccionAnual, consumoAnual, capacidadInstalada, compartida, eficiencia);
        this.tipoBiocombustible = tipoBiocombustible;
    }

    public String getTipoBiocombustible() {
        return tipoBiocombustible;
    }

    public void setTipoBiocombustible(String tipoBiocombustible) {
        this.tipoBiocombustible = tipoBiocombustible;
    }

    @Override
    public double calcularProduccion() {
        return capacidadInstalada * 365;
    }

    @Override
    public double calcularConsumo() {
        return capacidadInstalada * 0.85 * 365;
    }

    @Override
    public String toString() {
        return "BioCombustibles{" +
                "tipoBiocombustible='" + tipoBiocombustible + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ano=" + ano +
                ", produccionAnual=" + produccionAnual +
                ", consumoAnual=" + consumoAnual +
                ", capacidadInstalada=" + capacidadInstalada +
                ", compartida=" + compartida +
                ", eficiencia=" + eficiencia +
                '}';
    }
}
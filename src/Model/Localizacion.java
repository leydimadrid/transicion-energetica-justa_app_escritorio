
package Model;
import java.util.List;

public class Localizacion {
    private String nombre;
    private List<EnergiaRenovable> energiasRenovables;

    public Localizacion() {
    }

    public Localizacion(String nombre, List<EnergiaRenovable> energiasRenovables) {
        this.nombre = nombre;
        this.energiasRenovables = energiasRenovables;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public List<EnergiaRenovable> getEnergiasRenovables() {
        return energiasRenovables;
    }

    public void setEnergiasRenovables(List<EnergiaRenovable> energiasRenovables) {
        this.energiasRenovables = energiasRenovables;
    }

    public double obtenerDatosEnergeticos() {
        return 0.0d;
    }

    public double calcularPorcentajeRenovable() {
        return 0.0d;
    }


    @Override
    public String toString() {
        return "Localizacion{" +
                "nombre='" + nombre + '\'' +
                ", energiasRenovables=" + energiasRenovables +
                '}';
    }
}
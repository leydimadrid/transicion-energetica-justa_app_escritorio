package Model;
public class EnergiaGeotermica extends EnergiaRenovable {
    private double temperaturaTierra;
    private double profundidadPerforacion;

    public EnergiaGeotermica() {
    }

    public EnergiaGeotermica(int id, Localizacion localizacion, String nombre, int ano, double produccionAnual, double consumoAnual, double capacidadInstalada, boolean compartida, double eficiencia, double profundidadPerforacion, double temperaturaTierra) {
        super(id, localizacion, nombre, ano, produccionAnual, consumoAnual, capacidadInstalada, compartida, eficiencia);
        this.profundidadPerforacion = profundidadPerforacion;
        this.temperaturaTierra = temperaturaTierra;
    }

    public double getTemperaturaTierra() {
        return temperaturaTierra;
    }

    public void setTemperaturaTierra(double temperaturaTierra) {
        this.temperaturaTierra = temperaturaTierra;
    }

    public double getProfundidadPerforacion() {
        return profundidadPerforacion;
    }

    public void setProfundidadPerforacion(double profundidadPerforacion) {
        this.profundidadPerforacion = profundidadPerforacion;
    }

    @Override
    public double calcularProduccion() {
        return temperaturaTierra * 365;
    }

    @Override
    public double calcularConsumo() {
        return temperaturaTierra * 0.8 * 365;
    }

    @Override
    public String toString() {
        return "EnergiaGeotermica{" +
                "profundidadPerforacion=" + profundidadPerforacion +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ano=" + ano +
                ", produccionAnual=" + produccionAnual +
                ", consumoAnual=" + consumoAnual +
                ", capacidadInstalada=" + capacidadInstalada +
                ", compartida=" + compartida +
                ", eficiencia=" + eficiencia +
                ", temperaturaTierra=" + temperaturaTierra +
                '}';
    }
}
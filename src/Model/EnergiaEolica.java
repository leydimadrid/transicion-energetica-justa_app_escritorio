package Model;
public class EnergiaEolica extends EnergiaRenovable {
    private double numeroTurbinas;
    private double velocidadViento;

    public EnergiaEolica() {
    }

    public EnergiaEolica(int id, Localizacion localizacion, String nombre, int ano, double produccionAnual, double consumoAnual, double capacidadInstalada, boolean compartida, double eficiencia, double numeroTurbinas, double velocidadViento) {
        super(id, localizacion, nombre, ano, produccionAnual, consumoAnual, capacidadInstalada, compartida, eficiencia);
        this.numeroTurbinas = numeroTurbinas;
        this.velocidadViento = velocidadViento;
    }

    public double getNumeroTurbinas() {
        return numeroTurbinas;
    }

    public void setNumeroTurbinas(double numeroTurbinas) {
        this.numeroTurbinas = numeroTurbinas;
    }

    public double getVelocidadViento() {
        return velocidadViento;
    }

    public void setVelocidadViento(double velocidadViento) {
        this.velocidadViento = velocidadViento;
    }

    @Override
    public double calcularProduccion() {
        return numeroTurbinas * velocidadViento * 365;
    }

    @Override
    public double calcularConsumo() {
        return numeroTurbinas * velocidadViento * 0.8 * 365;
    }

    @Override
    public String toString() {
        return "EnergiaEolica{" +
                "velocidadViento=" + velocidadViento +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ano=" + ano +
                ", produccionAnual=" + produccionAnual +
                ", consumoAnual=" + consumoAnual +
                ", capacidadInstalada=" + capacidadInstalada +
                ", compartida=" + compartida +
                ", eficiencia=" + eficiencia +
                ", numeroTurbinas=" + numeroTurbinas +
                '}';
    }

}
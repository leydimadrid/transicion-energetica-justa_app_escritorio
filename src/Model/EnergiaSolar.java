package Model;
public class EnergiaSolar extends EnergiaRenovable {
    private double numeroPaneles;
    private double horasSolDia;


    public EnergiaSolar() {
    }

    public EnergiaSolar(int id, Localizacion localizacion, String nombre, int ano, double produccionAnual, double consumoAnual, double capacidadInstalada, boolean compartida, double eficiencia, double numeroPaneles, double horasSolDia) {
        super(id, localizacion, nombre, ano, produccionAnual, consumoAnual, capacidadInstalada, compartida, eficiencia);
        this.numeroPaneles = numeroPaneles;
        this.horasSolDia = horasSolDia;
    }

    public double getNumeroPaneles() {
        return numeroPaneles;
    }

    public void setNumeroPaneles(double numeroPaneles) {
        this.numeroPaneles = numeroPaneles;
    }

    public double getHorasSolDia() {
        return horasSolDia;
    }

    public void setHorasSolDia(double horasSolDia) {
        this.horasSolDia = horasSolDia;
    }

    @Override
    public double calcularProduccion() {
        return numeroPaneles * horasSolDia * 365;
    }

    @Override
    public double calcularConsumo() {
        return numeroPaneles * horasSolDia * 0.9 * 365;
    }


    @Override
    public String toString() {
        return "EnergiaSolar{" +
                "horasSolDia=" + horasSolDia +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ano=" + ano +
                ", produccionAnual=" + produccionAnual +
                ", consumoAnual=" + consumoAnual +
                ", capacidadInstalada=" + capacidadInstalada +
                ", compartida=" + compartida +
                ", eficiencia=" + eficiencia +
                ", numeroPaneles=" + numeroPaneles +
                '}';
    }
}
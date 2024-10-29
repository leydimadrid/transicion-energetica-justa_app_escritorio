package Model;

public class Pais {
    private String nombre;
    private int codigoPais;
    private long poblacion;
    private double energiaRequerida;
    private double nivelCobertura;

    public Pais() {
    }

    public Pais(String nombre, int codigoPais, long poblacion, double energiaRequerida, double nivelCobertura) {
        this.nombre = nombre;
        this.codigoPais = codigoPais;
        this.poblacion = poblacion;
        this.energiaRequerida = energiaRequerida;
        this.nivelCobertura = nivelCobertura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(int codigoPais) {
        this.codigoPais = codigoPais;
    }

    public long getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(long poblacion) {
        this.poblacion = poblacion;
    }

    public double getEnergiaRequerida() {
        return energiaRequerida;
    }

    public void setEnergiaRequerida(double energiaRequerida) {
        this.energiaRequerida = energiaRequerida;
    }

    public double getNivelCobertura() {
        return nivelCobertura;
    }

    public void setNivelCobertura(double nivelCobertura) {
        this.nivelCobertura = nivelCobertura;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "nombre='" + nombre + '\'' +
                ", codigoPais=" + codigoPais +
                ", poblacion=" + poblacion +
                ", energiaRequerida=" + energiaRequerida +
                ", nivelCobertura=" + nivelCobertura +
                '}';
    }
}
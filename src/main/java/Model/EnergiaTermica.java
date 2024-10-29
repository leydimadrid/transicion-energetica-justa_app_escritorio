package Model;

public class EnergiaTermica extends EnergiaRenovable {
    private String fuenteEnergia;

    public EnergiaTermica() {
    }

    public EnergiaTermica(String nombreFuente, String fuenteEnergia) {
        super(nombreFuente);
        this.fuenteEnergia = fuenteEnergia;
    }

    public String getFuenteEnergia() {
        return fuenteEnergia;
    }

    public void setFuenteEnergia(String fuenteEnergia) {
        this.fuenteEnergia = fuenteEnergia;
    }


    @Override
    public String toString() {
        return "EnergiaTermica{" +
                "fuenteEnergia='" + fuenteEnergia + '\'' +
                ", nombreFuente='" + nombreFuente + '\'' +
                '}';
    }
}
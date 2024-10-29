package Model;

import Utils.Interfaces.*;


public class EnergiaRenovable implements IEnergiaRenovable {
    public String nombreFuente;

    public EnergiaRenovable() {

    }

    public EnergiaRenovable(String nombreFuente) {
        this.nombreFuente = nombreFuente;
    }

    public String getNombreFuente() {
        return nombreFuente;
    }

    public void setNombreFuente(String nombreFuente) {
        this.nombreFuente = nombreFuente;
    }

    public double calcularCapacidadProduccionNominal() {
        return 0.0d;
    }


    @Override
    public double calcularProduccion() {
        return 0;
    }

    @Override
    public double calcularConsumo() {
        return 0;
    }
}
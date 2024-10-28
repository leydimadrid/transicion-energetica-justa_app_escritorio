/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dtos;

/**
 * @author MI PC
 */
public class ProduccionEnergia {
    private String tipoEnergia;
    private String region;
    private double produccionTotal;

    // Getters y Setters
    public String getTipoEnergia() {
        return tipoEnergia;
    }

    public void setTipoEnergia(String tipoEnergia) {
        this.tipoEnergia = tipoEnergia;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getProduccionTotal() {
        return produccionTotal;
    }

    public void setProduccionTotal(double produccionTotal) {
        this.produccionTotal = produccionTotal;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dtos;

/**
 *
 * @author MI PC
 */
public class ConsumoRegion {
    private String region;
    private double consumoTotal;
    private double capacidadInstaladaEnergiaRenovable;
    private double porcentajeEnergiaRenovable;

    // Constructor
    public ConsumoRegion(String region, double consumoTotal, double capacidadInstaladaEnergiaRenovable, double porcentajeEnergiaRenovable) {
        this.region = region;
        this.consumoTotal = consumoTotal;
        this.capacidadInstaladaEnergiaRenovable = capacidadInstaladaEnergiaRenovable;
        this.porcentajeEnergiaRenovable = porcentajeEnergiaRenovable;
    }

    // Getters y Setters
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getConsumoTotal() {
        return consumoTotal;
    }

    public void setConsumoTotal(double consumoTotal) {
        this.consumoTotal = consumoTotal;
    }

    public double getCapacidadInstaladaEnergiaRenovable() {
        return capacidadInstaladaEnergiaRenovable;
    }

    public void setCapacidadInstaladaEnergiaRenovable(double capacidadInstaladaEnergiaRenovable) {
        this.capacidadInstaladaEnergiaRenovable = capacidadInstaladaEnergiaRenovable;
    }

    public double getPorcentajeEnergiaRenovable() {
        return porcentajeEnergiaRenovable;
    }

    public void setPorcentajeEnergiaRenovable(double porcentajeEnergiaRenovable) {
        this.porcentajeEnergiaRenovable = porcentajeEnergiaRenovable;
    }
}

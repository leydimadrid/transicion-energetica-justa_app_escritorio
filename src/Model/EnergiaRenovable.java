package Model;

import Utils.Intefaces.IEnergiaRenovable;

public abstract class EnergiaRenovable implements IEnergiaRenovable {

    public int id;
    public Localizacion localizacion;
    public String nombre;
    public int ano;
    public double produccionAnual;
    public double consumoAnual;
    public double capacidadInstalada;
    public boolean compartida;
    public double eficiencia;

    public EnergiaRenovable() {
    }

    public EnergiaRenovable(int id, Localizacion localizacion, String nombre, int ano, double produccionAnual, double consumoAnual, double capacidadInstalada, boolean compartida, double eficiencia) {
        this.id = id;
        this.localizacion = localizacion;
        this.nombre = nombre;
        this.ano = ano;
        this.produccionAnual = produccionAnual;
        this.consumoAnual = consumoAnual;
        this.capacidadInstalada = capacidadInstalada;
        this.compartida = compartida;
        this.eficiencia = eficiencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getProduccionAnual() {
        return produccionAnual;
    }

    public void setProduccionAnual(double produccionAnual) {
        this.produccionAnual = produccionAnual;
    }

    public double getConsumoAnual() {
        return consumoAnual;
    }

    public void setConsumoAnual(double consumoAnual) {
        this.consumoAnual = consumoAnual;
    }

    public double getCapacidadInstalada() {
        return capacidadInstalada;
    }

    public void setCapacidadInstalada(double capacidadInstalada) {
        this.capacidadInstalada = capacidadInstalada;
    }

    public boolean isCompartida() {
        return compartida;
    }

    public void setCompartida(boolean compartida) {
        this.compartida = compartida;
    }

    public double getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(double eficiencia) {
        this.eficiencia = eficiencia;
    }

    public static String mostrarInformacion() {
        return "";
    }


    public abstract double calcularProduccion();

    public abstract double calcularConsumo();
}
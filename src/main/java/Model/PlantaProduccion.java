package Model;

import java.time.LocalDate;

public class PlantaProduccion extends EnergiaRenovable {

    private EnergiaRenovable energia;
    private String ubicacionDepartamento;
    private int disponibilidadHoraria;
    private LocalDate anio;

    public PlantaProduccion() {
    }

    public PlantaProduccion(String nombreFuente, EnergiaRenovable energia, String ubicacionDepartamento, int disponibilidadHoraria, LocalDate anio) {
        super(nombreFuente);
        this.energia = energia;
        this.ubicacionDepartamento = ubicacionDepartamento;
        this.disponibilidadHoraria = disponibilidadHoraria;
        this.anio = anio;
    }

    public EnergiaRenovable getEnergia() {
        return energia;
    }

    public void setEnergia(EnergiaRenovable energia) {
        this.energia = energia;
    }

    public String getUbicacionDepartamento() {
        return ubicacionDepartamento;
    }

    public void setUbicacionDepartamento(String ubicacionDepartamento) {
        this.ubicacionDepartamento = ubicacionDepartamento;
    }

    public int getDisponibilidadHoraria() {
        return disponibilidadHoraria;
    }

    public void setDisponibilidadHoraria(int disponibilidadHoraria) {
        this.disponibilidadHoraria = disponibilidadHoraria;
    }

    public LocalDate getAnio() {
        return anio;
    }

    public void setAnio(LocalDate anio) {
        this.anio = anio;
    }

    public double calcularProduccion() {
        return 0.0d;
    }

    @Override
    public String toString() {
        return "PlantaProduccion{" +
                "energia=" + energia +
                ", ubicacionDepartamento='" + ubicacionDepartamento + '\'' +
                ", disponibilidadHoraria=" + disponibilidadHoraria +
                ", anio=" + anio +
                ", nombreFuente='" + nombreFuente + '\'' +
                '}';
    }
}
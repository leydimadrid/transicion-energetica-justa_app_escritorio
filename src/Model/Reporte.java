package Model;

import java.time.LocalDate;
import java.util.List;

public class Reporte {
    private int id;
    private String tipoEnergia;
    private Pais pais;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;


    public Reporte() {
    }

    public Reporte(int id, String tipoEnergia, Pais pais, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.tipoEnergia = tipoEnergia;
        this.pais = pais;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pais getLocalizacion() {
        return pais;
    }

    public void setLocalizacion(Pais pais) {
        this.pais = pais;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoEnergia() {
        return tipoEnergia;
    }

    public void setTipoEnergia(String tipoEnergia) {
        this.tipoEnergia = tipoEnergia;
    }

    public static String generarReporte(List<EnergiaRenovable> energiasRenovables) {
        StringBuilder reporte = new StringBuilder();
        reporte.append("\nINFORME DE ENERGÍAS RENOVABLES\n");
        reporte.append("================================\n\n");

        return reporte.toString();
    }


    @Override
    public String toString() {
        return "Reporte{" +
                "id=" + id +
                ", pais='" + pais + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", tipoEnergia='" + tipoEnergia + '\'' +
                '}';
    }
}
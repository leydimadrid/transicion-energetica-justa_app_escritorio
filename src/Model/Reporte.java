
package Model;
import java.time.LocalDate;
import java.util.List;

public class Reporte {
    private int id;
    private String tipoEnergia;
    private Localizacion localizacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;


    public Reporte() {
    }

    public Reporte(int id,  String tipoEnergia, Localizacion localizacion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.tipoEnergia = tipoEnergia;
        this.localizacion = localizacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
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
        for (EnergiaRenovable energia : energiasRenovables) {
            reporte.append("Tipo de Energía: ").append(energia.getNombre()).append("\n");
            reporte.append("Año: ").append(energia.getAno()).append("\n");
            reporte.append("Producción Anual: ").append(energia.getProduccionAnual()).append("\n");
            reporte.append("Consumo Anual: ").append(energia.getConsumoAnual()).append("\n");
            reporte.append("Capacidad Instalada: ").append(energia.getCapacidadInstalada()).append("\n");
            reporte.append("Compartida: ").append(energia.isCompartida()).append("\n");
            reporte.append("Eficiencia: ").append(energia.getEficiencia()).append("\n");
            reporte.append("Localización: ").append(energia.getLocalizacion().getNombre()).append("\n");
            reporte.append("--------------------------------\n");
        }

        return reporte.toString();
    }


    @Override
    public String toString() {
        return "Reporte{" +
                "id=" + id +
                ", localizacion='" + localizacion + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", tipoEnergia='" + tipoEnergia + '\'' +
                '}';
    }
}
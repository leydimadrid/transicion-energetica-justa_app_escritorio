package Utils.Interfaces;

public interface IEnergiaRenovableService {

    public String obtenerProduccionTotalEnergia(String fuente, String anio);

    public String obtenerPorcentajeConsumoElectricoTotalRegion(String fuente, String anio);
}

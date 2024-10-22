package Utils.Interfaces;

public interface IEnergiaRenovableRepository {
    String obtenerProduccionTotalEnergia(String fuente, String anio);

    String obtenerPorcentajeConsumoElectricoTotalRegion(String fuente, String anio);
}

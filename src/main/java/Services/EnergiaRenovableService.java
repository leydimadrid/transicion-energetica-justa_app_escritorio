package Services;

import Model.EnergiaEolica;
import Repository.EnergiaRenovableRepository;

import java.util.List;


public class EnergiaRenovableService {

    public EnergiaRenovableRepository _energiaRenovableRepository;

    public EnergiaRenovableService() {
    }

    public EnergiaRenovableService(EnergiaRenovableRepository energiaRenovableRepository) {
        this._energiaRenovableRepository = energiaRenovableRepository;
    }


    public String obtenerProduccionTotalEnergia(String fuente, String anio) {
        String produccionTotalEnergia = _energiaRenovableRepository.obtenerProduccionTotalEnergia(fuente, anio);
        return produccionTotalEnergia;
    }


    public String obtenerPorcentajeConsumoElectricoTotalRegion(String fuente, String anio) {

        String porcentajeConsumoElectricoTotalRegion = _energiaRenovableRepository.obtenerPorcentajeConsumoElectricoTotalRegion(fuente, anio);
        return porcentajeConsumoElectricoTotalRegion;

    }

    public List<EnergiaEolica> obtenerTop10PaisesEolica() {
        List<EnergiaEolica> top10ProduccionEolica = _energiaRenovableRepository.obtenerTop10PaisesEolica();
        return top10ProduccionEolica;
    }
}
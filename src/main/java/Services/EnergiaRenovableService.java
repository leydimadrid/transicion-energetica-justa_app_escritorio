package Services;

import Model.Dtos.ProduccionEnergia;
import Repository.EnergiaRenovableRepository;
import java.util.List;


public class EnergiaRenovableService {

    public EnergiaRenovableRepository _energiaRenovableRepository;

    public EnergiaRenovableService() {
    }

    public EnergiaRenovableService(EnergiaRenovableRepository energiaRenovableRepository) {
        this._energiaRenovableRepository = energiaRenovableRepository;
    }


    public List<ProduccionEnergia> obtenerProduccionTotalEnergia(String fuente, int anio)  {
        List<ProduccionEnergia>  produccionTotalEnergia = _energiaRenovableRepository.obtenerProduccionTotalEnergia(fuente, anio);
        return produccionTotalEnergia;
    }


    public String obtenerPorcentajeConsumoElectricoTotalRegion(String fuente, String anio) {

        String porcentajeConsumoElectricoTotalRegion = _energiaRenovableRepository.obtenerPorcentajeConsumoElectricoTotalRegion(fuente, anio);
        return porcentajeConsumoElectricoTotalRegion;

    }
}
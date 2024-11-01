package Services;

import Model.Dtos.CapacidadInstaladaSolar;
import Model.Dtos.ConsumoRegion;
import Model.Dtos.ProduccionEnergia;
import Model.EnergiaEolica;
import Repository.EnergiaRenovableRepository;

import java.util.List;
import java.util.Map;

public class EnergiaRenovableService {

    public EnergiaRenovableRepository _energiaRenovableRepository;

    public EnergiaRenovableService() {
    }

    public EnergiaRenovableService(EnergiaRenovableRepository energiaRenovableRepository) {
        this._energiaRenovableRepository = energiaRenovableRepository;
    }

    public List<ProduccionEnergia> obtenerProduccionTotalEnergia(String fuente, int anio) {
        List<ProduccionEnergia> produccionTotalEnergia = _energiaRenovableRepository.obtenerProduccionTotalEnergia(fuente, anio);
        return produccionTotalEnergia;
    }

    public List<ConsumoRegion> obtenerPorcentajeConsumoElectricoTotalRegion() {

         return _energiaRenovableRepository.obtenerPorcentajeConsumoElectricoTotalRegion();
    }

    public List<CapacidadInstaladaSolar> obtenerCapacidadInstaladaEnergiaSolarTodosLosAnios() {

        return  _energiaRenovableRepository.obtenerCapacidadInstaladaEnergiaSolarTodosLosAnios();
    }

    public List<EnergiaEolica> obtenerTop10PaisesEolica(int anio) {
        return _energiaRenovableRepository.obtenerTop10PaisesEolica(anio);
    }

    public Map<String, Double> obtenerParticipacionConsumo() {
        return _energiaRenovableRepository.obtenerParticipacionConsumo();
    }
}

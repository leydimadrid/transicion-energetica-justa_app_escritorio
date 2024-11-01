package Controllers;

import Model.Dtos.CapacidadInstaladaSolar;
import Model.Dtos.ConsumoRegion;
import Model.Dtos.ProduccionEnergia;
import Model.EnergiaEolica;
import Services.EnergiaRenovableService;

import java.util.List;
import java.util.Map;

public class EnergiaRenovableController {

    public EnergiaRenovableService _energiaRenovableService;

    public EnergiaRenovableController() {
    }

    public EnergiaRenovableController(EnergiaRenovableService energiaRenovableService) {
        this._energiaRenovableService = energiaRenovableService;

    }

    /*
    Obtener la produccion total de energia renovable por tipo de fuente en un año, especifico agrupada por regiones
     */
    public List<ProduccionEnergia> obtenerProduccionTotalEnergia(String tipoEnergia, int anio) {
        List<ProduccionEnergia> produccionTotalEnergia = _energiaRenovableService.obtenerProduccionTotalEnergia(tipoEnergia, anio);
        return produccionTotalEnergia;
    }

    /*
    *Calcular el porcentaje de energía renovable en el consumo eléctrico total de cada región.
     */
    public List<ConsumoRegion> obtenerPorcentajeConsumoElectricoTotalRegion() {

        return _energiaRenovableService.obtenerPorcentajeConsumoElectricoTotalRegion();
        
    }

    /*
    Obtener la tendencia de la capacidad instalada de energía solar a lo largo de los años.*/
    public List<CapacidadInstaladaSolar> obtenerCapacidadInstaladaEnergiaSolarTodosLosAnios() {

        return _energiaRenovableService.obtenerCapacidadInstaladaEnergiaSolarTodosLosAnios();
      
    }
    
    public List<EnergiaEolica> obtenerTop10PaisesEolica(int anio) {
        return _energiaRenovableService.obtenerTop10PaisesEolica(anio);
    }

    public Map<String, Double> obtenerParticipacionConsumo() {
        return _energiaRenovableService.obtenerParticipacionConsumo();
    }

}

package Controllers;

import Model.Dtos.ProduccionEnergia;
import Services.EnergiaRenovableService;
import java.util.List;

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
    public List<ProduccionEnergia> obtenerProduccionTotalEnergia(String tipoEnergia, int anio)  {
        List<ProduccionEnergia> produccionTotalEnergia = _energiaRenovableService.obtenerProduccionTotalEnergia(tipoEnergia, anio);
        return produccionTotalEnergia;
    }

    public String obtenerPorcentajeConsumoElectricoTotalRegion(String tipoEnergia, String anio) {

        String porcentajeConsumoElectricoTotalRegion = _energiaRenovableService.obtenerPorcentajeConsumoElectricoTotalRegion(tipoEnergia, anio);
        return porcentajeConsumoElectricoTotalRegion;

    }
}

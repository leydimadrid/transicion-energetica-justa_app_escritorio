package Controllers;

import Model.EnergiaEolica;
import Services.EnergiaRenovableService;

import java.util.List;


public class EnergiaRenovableController {

    public EnergiaRenovableService _energiaRenovableService;

    public EnergiaRenovableController() {
    }

    public EnergiaRenovableController(EnergiaRenovableService energiaRenovableService) {
        this._energiaRenovableService = energiaRenovableService;

    }


    public String obtenerProduccionTotalEnergia(String tipoEnergia, String anio) {
        String produccionTotalEnergia = _energiaRenovableService.obtenerProduccionTotalEnergia(tipoEnergia, anio);
        return produccionTotalEnergia;
    }


    public String obtenerPorcentajeConsumoElectricoTotalRegion(String tipoEnergia, String anio) {

        String porcentajeConsumoElectricoTotalRegion = _energiaRenovableService.obtenerPorcentajeConsumoElectricoTotalRegion(tipoEnergia, anio);
        return porcentajeConsumoElectricoTotalRegion;

    }

    public List<EnergiaEolica> obtenerTop10PaisesEolica() {
        List<EnergiaEolica> top10ProduccionEolica = _energiaRenovableService.obtenerTop10PaisesEolica();
        return top10ProduccionEolica;
    }
}
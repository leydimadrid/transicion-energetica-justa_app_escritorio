package Controllers;

import Services.EnergiaRenovableService;


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
}
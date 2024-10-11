/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import utils.intefaces.IEnergiaRenovableService;

/**
 *
 * @author MI PC
 */
public class EnergiaRenovableController  {
    
   private final IEnergiaRenovableService _energiaRenovableService;
   
    public EnergiaRenovableController(IEnergiaRenovableService energiaRenovableService){
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Serivices.EnergiaRenovableService;
import utils.intefaces.IEnergiaRenovableService;

/**
 *
 * @author MI PC
 */
public class EnergiaRenovableController  {
    
    public  EnergiaRenovableService _energiaRenovableService;
   
    public EnergiaRenovableController( EnergiaRenovableService energiaRenovableService){
        this._energiaRenovableService = energiaRenovableService;
 
    }
 public EnergiaRenovableController( ){
       
 
    }

  
    public String obtenerProduccionTotalEnergia(String tipoEnergia, String anio) {
        String produccionTotalEnergia = _energiaRenovableService.obtenerProduccionTotalEnergia(tipoEnergia, anio);
        return produccionTotalEnergia;
    }


 
    public String obtenerPorcentajeConsumoElectricoTotalRegion(String tipoEnergia, String anio) {
     
        String porcentajeConsumoElectricoTotalRegion = _energiaRenovableService.obtenerPorcentajeConsumoElectricoTotalRegion(tipoEnergia, anio);
        return porcentajeConsumoElectricoTotalRegion;

    } 
    
       // Método para iniciar sesión
    public boolean iniciarSesion(String email, String contrasenia) {
        
        boolean porcentajeConsumoElectricoTotalRegion = _energiaRenovableService.iniciarSesion(email, contrasenia);
        return porcentajeConsumoElectricoTotalRegion;
      }
    
}

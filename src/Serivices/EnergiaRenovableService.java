/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serivices;

import Repository.EnergiaRenovableRepository;
import utils.intefaces.IEnergiaRenovableRepository;

/**
 *
 * @author MI PC
 */
public class EnergiaRenovableService {
      
    public EnergiaRenovableRepository  _energiaRenovableRepository;
    
    public EnergiaRenovableService( EnergiaRenovableRepository  energiaRenovableRepository){
       this._energiaRenovableRepository = energiaRenovableRepository;
    }


    public EnergiaRenovableService(){
 
    }


    public String obtenerProduccionTotalEnergia(String fuente, String anio) {
      String produccionTotalEnergia = _energiaRenovableRepository.obtenerProduccionTotalEnergia(fuente, anio);
        return produccionTotalEnergia;
    }


    public String obtenerPorcentajeConsumoElectricoTotalRegion(String fuente, String anio) {
        
        String porcentajeConsumoElectricoTotalRegion = _energiaRenovableRepository.obtenerPorcentajeConsumoElectricoTotalRegion(fuente, anio);
        return porcentajeConsumoElectricoTotalRegion;

    }
    
        
       // Método para iniciar sesión
    public boolean iniciarSesion(String email, String contrasenia) {
        
        boolean inicioSesion = _energiaRenovableRepository.iniciarSesion(email,contrasenia);
        return inicioSesion;
      }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import utils.intefaces.IEnergiaRenovableRepository;

/**
 *
 * @author MI PC
 */
public class EnergiaRenovableRepository implements IEnergiaRenovableRepository{
 
    @Override
    public String obtenerProduccionTotalEnergia(String fuente, String anio) {
        return fuente + anio;
    }
    @Override
    public String obtenerPorcentajeConsumoElectricoTotalRegion(String fuente, String anio) {
        return fuente + anio;
    }
}

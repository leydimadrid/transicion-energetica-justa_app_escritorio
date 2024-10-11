/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serivices;

import utils.intefaces.IEnergiaRenovableRepository;

/**
 *
 * @author MI PC
 */
public class EnergiaRenovableService implements IEnergiaRenovableRepository{
        private final IEnergiaRenovableRepository _energiaRenovableRepository;

    public EnergiaRenovableService(IEnergiaRenovableRepository energiaRenovableRepository){
        this._energiaRenovableRepository = energiaRenovableRepository;
    }

    @Override
    public String obtenerProduccionTotalEnergia(String fuente, String anio) {
      String produccionTotalEnergia = _energiaRenovableRepository.obtenerProduccionTotalEnergia(fuente, anio);
        return produccionTotalEnergia;
    }

@Override
    public String obtenerPorcentajeConsumoElectricoTotalRegion(String fuente, String anio) {
        String porcentajeConsumoElectricoTotalRegion = _energiaRenovableRepository.obtenerPorcentajeConsumoElectricoTotalRegion(fuente, anio);
        return porcentajeConsumoElectricoTotalRegion;
    }
}

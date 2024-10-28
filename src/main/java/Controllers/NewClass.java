/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Model.Dtos.ProduccionEnergia;
import Model.PlantaProduccion;
import Repository.EnergiaRenovableRepository;
import Repository.UsuarioRepository;
import Services.EnergiaRenovableService;
import Services.UsuarioService;
import Vistas.VistaPrincipal;
import java.util.List;

/**
 *
 * @author MI PC
 */
public class NewClass {
        public static void main(String[] args) {
                EnergiaRenovableRepository energiaRenovableRepository = new EnergiaRenovableRepository();
                EnergiaRenovableService energiaRenovableService = new EnergiaRenovableService(energiaRenovableRepository);
                EnergiaRenovableController energiaController = new EnergiaRenovableController(energiaRenovableService);
                
              List<ProduccionEnergia>  listenergiasRenovables = energiaController.obtenerProduccionTotalEnergia("Eólica", 2023);
              
              List<ProduccionEnergia>  listenergiasRenovablese = listenergiasRenovables;
              
              
    }
}

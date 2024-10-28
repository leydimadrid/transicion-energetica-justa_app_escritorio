/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Model.Dtos.ProduccionEnergia;
import Model.EnergiaEolica;
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

            System.out.println("\n----Obtener los 10 países con mayor producción de energía eólica en un año específico----\n");
            List<EnergiaEolica> topPaisesEolica = energiaController.obtenerTop10PaisesEolica(2022);
            for (EnergiaEolica energia : topPaisesEolica) {
                System.out.println("País: " + energia.getNombreFuente());
                System.out.println("Año: " + energia.getAnio());
                System.out.println("Producción total: " + energia.getCapacidadRotor());
                System.out.println("-------------------------");
            }


        }
}

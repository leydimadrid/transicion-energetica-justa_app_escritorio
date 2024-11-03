/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Model.Dtos.CapacidadInstaladaSolar;
import Model.Dtos.ConsumoRegion;
import Model.Dtos.ProduccionEnergia;
import Model.EnergiaEolica;
import Model.PlantaProduccion;
import Repository.EnergiaRenovableRepository;
import Repository.UsuarioRepository;
import Services.EnergiaRenovableService;
import Services.UsuarioService;
import Vistas.VistaPrincipal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MI PC
 */
public class ClaseDePrueba {

    public static void main(String[] args) {

        EnergiaRenovableRepository energiaRenovableRepository = new EnergiaRenovableRepository();
        EnergiaRenovableService energiaRenovableService = new EnergiaRenovableService(energiaRenovableRepository);
        EnergiaRenovableController energiaController = new EnergiaRenovableController(energiaRenovableService);

        /*obtenerProduccionTotalEnergia Prueba metodo */
        List<ProduccionEnergia> listenergiasRenovables = energiaController.obtenerProduccionTotalEnergia("Eólica", 2023);
        List<ProduccionEnergia> listenergiasRenovablese = listenergiasRenovables;

        /*obtenerCapacidadInstaladaEnergiaSolarTodosLosAnios Prueba metodo */
        List<CapacidadInstaladaSolar> capacidadInstaladaSolar = energiaController.obtenerCapacidadInstaladaEnergiaSolarTodosLosAnios();
        List<CapacidadInstaladaSolar> capacidadInstaladaSolare = capacidadInstaladaSolar;

        /* *Calcular el porcentaje de energía renovable en el consumo eléctrico total de cada región. */
        List<ConsumoRegion> consumoRegion = energiaController.obtenerPorcentajeConsumoElectricoTotalRegion();
        List<ConsumoRegion> consumoRegionn = consumoRegion;

        /*obtenerTop10PaisesEolica Prueba metodo */
        System.out.println("\n----Obtener los 10 países con mayor producción de energía eólica en un año específico----\n");
        List<EnergiaEolica> topPaisesEolica = energiaController.obtenerTop10PaisesEolica(2022);
        for (EnergiaEolica energia : topPaisesEolica) {
            System.out.println("País: " + energia.getNombreFuente());
            System.out.println("Año: " + energia.getAnio());
            System.out.println("Producción total: " + energia.getCapacidadRotor());
            System.out.println("-------------------------");
        }

        /* Listar todas las fuentes de energía y su participación en el consumo eléctrico total a nivel global. */
        Map<String, Double> consumo = energiaController.obtenerParticipacionConsumo();

        System.out.println("\n----Participación en el consumo eléctrico por fuente de energía----\n");
        for (Map.Entry<String, Double> entry : consumo.entrySet()) {
            System.out.println("Fuente de energía: " + entry.getKey() + " - Consumo eléctrico: " + entry.getValue());
            System.out.println("-------------------------");
        }

    }
}

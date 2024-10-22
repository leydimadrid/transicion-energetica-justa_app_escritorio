package Controllers;

import Model.Usuario;
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
    
    public List<Usuario>  obtenerUsuarios() {

        List<Usuario>  usuarios = _energiaRenovableService.obtenerUsuarios();
        return usuarios;

    }


    // Metodo para iniciar sesión
    public boolean iniciarSesion(String email, String contrasenia) {

        boolean porcentajeConsumoElectricoTotalRegion = _energiaRenovableService.iniciarSesion(email, contrasenia);
        return porcentajeConsumoElectricoTotalRegion;
    }

}

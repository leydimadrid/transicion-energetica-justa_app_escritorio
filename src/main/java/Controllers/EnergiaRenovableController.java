package Controllers;

<<<<<<< HEAD:src/Controllers/EnergiaRenovableController.java
import Services.EnergiaRenovableService;
=======
import Model.Usuario;
import Services.EnergiaRenovableService;
import java.util.List;
>>>>>>> Dev:src/main/java/Controllers/EnergiaRenovableController.java

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
<<<<<<< HEAD:src/Controllers/EnergiaRenovableController.java
=======
    
    public List<Usuario>  obtenerUsuarios() {

        List<Usuario>  usuarios = _energiaRenovableService.obtenerUsuarios();
        return usuarios;

    }

>>>>>>> Dev:src/main/java/Controllers/EnergiaRenovableController.java

    // Metodo para iniciar sesión
    public boolean iniciarSesion(String email, String contrasenia) {

        boolean porcentajeConsumoElectricoTotalRegion = _energiaRenovableService.iniciarSesion(email, contrasenia);
        return porcentajeConsumoElectricoTotalRegion;
    }

}

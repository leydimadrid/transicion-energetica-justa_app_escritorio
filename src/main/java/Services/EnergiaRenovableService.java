package Services;

import Model.Usuario;
import Repository.EnergiaRenovableRepository;
import java.util.List;


public class EnergiaRenovableService {

    public EnergiaRenovableRepository _energiaRenovableRepository;

    public EnergiaRenovableService() {
    }

    public EnergiaRenovableService(EnergiaRenovableRepository energiaRenovableRepository) {
        this._energiaRenovableRepository = energiaRenovableRepository;
    }


    public String obtenerProduccionTotalEnergia(String fuente, String anio) {
        String produccionTotalEnergia = _energiaRenovableRepository.obtenerProduccionTotalEnergia(fuente, anio);
        return produccionTotalEnergia;
    }


    public String obtenerPorcentajeConsumoElectricoTotalRegion(String fuente, String anio) {

        String porcentajeConsumoElectricoTotalRegion = _energiaRenovableRepository.obtenerPorcentajeConsumoElectricoTotalRegion(fuente, anio);
        return porcentajeConsumoElectricoTotalRegion;

    }
    
     public List<Usuario>  obtenerUsuarios() {

        List<Usuario>  usuarios = _energiaRenovableRepository.obtenerUsuarios();
        return usuarios;

    }


    // Metodo para iniciar sesión
    public boolean iniciarSesion(String email, String contrasenia) {

        boolean inicioSesion = _energiaRenovableRepository.iniciarSesion(email, contrasenia);
        return inicioSesion;
    }
}

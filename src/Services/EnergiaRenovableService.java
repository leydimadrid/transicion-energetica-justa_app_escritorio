package Services;

import Repository.EnergiaRenovableRepository;


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


    // Metodo para iniciar sesión
    public boolean iniciarSesion(String email, String contrasenia) {

        boolean inicioSesion = _energiaRenovableRepository.iniciarSesion(email, contrasenia);
        return inicioSesion;
    }
}

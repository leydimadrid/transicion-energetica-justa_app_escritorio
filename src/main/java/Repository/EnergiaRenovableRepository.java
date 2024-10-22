/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import ConfigBD.ConexionSql;
import Model.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnergiaRenovableRepository {

    private ConexionSql conexion;

    // Constructor
    public EnergiaRenovableRepository() {
        this.conexion = new ConexionSql();
    }


    public String obtenerProduccionTotalEnergia(String fuente, String anio) {
        return fuente + anio;
    }


    public String obtenerPorcentajeConsumoElectricoTotalRegion(String fuente, String anio) {
        return fuente + anio;
    }
}
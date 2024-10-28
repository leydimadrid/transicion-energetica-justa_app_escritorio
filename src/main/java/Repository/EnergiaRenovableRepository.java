/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import ConfigBD.ConexionSql;
import Model.EnergiaEolica;
import Model.Rol;
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

    public List<EnergiaEolica> obtenerTop10PaisesEolica () {
        List<EnergiaEolica> energiaEolica = new ArrayList<>();
        Connection conn = null;
          try {

            conn = conexion.conectar();


            // Crear la consulta SQL
            String sql = "SELECT pais, produccion_eolica " +
                         "FROM produccion_energia " +
                         "WHERE anio = ? " +
                         "ORDER BY produccion_eolica DESC " +
                         "LIMIT 10";

            // Crear el statement
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 2023); // Cambiar el año según sea necesario

            // Ejecutar la consulta
            ResultSet rs = ps.executeQuery();

            // Mostrar los resultados en consola
            while (rs.next()) {
                String pais = rs.getString("pais");
                int produccionEolica = rs.getInt("produccion_eolica");
                System.out.println("País: " + pais + " - Producción Eólica: " + produccionEolica);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Cerrar recursos
            conexion.cerrarConexion(conn);
        }
        return energiaEolica;
    }}
    
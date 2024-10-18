/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import ConfigBD.ConexionSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    // Método para iniciar sesión
    public boolean iniciarSesion(String email, String contrasenia) {
        Connection conn = null;
        boolean resultado = false;

        try {
            // Establecemos la conexión
            conn = conexion.conectar();

            if (conn != null) {
                // Consulta SQL para verificar el usuario
                String sql = "SELECT * FROM usuario WHERE email = ? AND contrasenia = ?";

                // Preparamos la consulta
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, contrasenia);

                // Ejecutamos la consulta
                ResultSet rs = ps.executeQuery();

                // Si existe un registro, el usuario y la contraseña coinciden
                if (rs.next()) {
                    resultado = true;
                }

                // Cerramos el ResultSet y el PreparedStatement
                rs.close();
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión después de la operación
            conexion.cerrarConexion(conn);
        }

        return resultado; // true si encontró el usuario, false si no
    }
}

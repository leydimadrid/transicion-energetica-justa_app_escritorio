/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import ConfigBD.ConexionSql;
<<<<<<< HEAD:src/Repository/EnergiaRenovableRepository.java
=======
import Model.Usuario;
>>>>>>> Dev:src/main/java/Repository/EnergiaRenovableRepository.java

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
    
 public List<Usuario> obtenerUsuarios() {
    List<Usuario> usuarios = new ArrayList<>(); 
    Connection conn = null;

    try {
        conn = conexion.conectar();

        if (conn != null) {
            // Realizar la unión para obtener el nombre del rol
            String sql = "SELECT u.id, u.nombre, u.email, r.nombre AS rol " +
                         "FROM usuario u " +
                         "JOIN rol r ON u.rol_id = r.id";  // Asegúrate de que la columna de la clave foránea es 'rol_id'

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String rol = rs.getString("rol");  // Ahora 'rol' contiene el nombre del rol

                Usuario usuario = new Usuario(id, nombre, email, rol);
                usuarios.add(usuario);
            }

            rs.close();
            ps.close();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        conexion.cerrarConexion(conn);
    }

    return usuarios;
}



<<<<<<< HEAD:src/Repository/EnergiaRenovableRepository.java
    // Método para iniciar sesión
=======
>>>>>>> Dev:src/main/java/Repository/EnergiaRenovableRepository.java
    public boolean iniciarSesion(String email, String contrasenia) {
        Connection conn = null;
        boolean resultado = false;

        try {

            conn = conexion.conectar();

            if (conn != null) {

                String sql = "SELECT * FROM usuario WHERE email = ? AND contrasenia = ?";

<<<<<<< HEAD:src/Repository/EnergiaRenovableRepository.java
                // Preparamos la consulta
=======
>>>>>>> Dev:src/main/java/Repository/EnergiaRenovableRepository.java
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, contrasenia);

<<<<<<< HEAD:src/Repository/EnergiaRenovableRepository.java
                // Ejecutamos la consulta
                ResultSet rs = ps.executeQuery();

                // Si existe un registro, el usuario y la contraseña coinciden
=======
                ResultSet rs = ps.executeQuery();

>>>>>>> Dev:src/main/java/Repository/EnergiaRenovableRepository.java
                if (rs.next()) {
                    resultado = true;
                }

<<<<<<< HEAD:src/Repository/EnergiaRenovableRepository.java
                // Cerramos el ResultSet y el PreparedStatement
=======
>>>>>>> Dev:src/main/java/Repository/EnergiaRenovableRepository.java
                rs.close();
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            conexion.cerrarConexion(conn);
        }

<<<<<<< HEAD:src/Repository/EnergiaRenovableRepository.java
        return resultado; // true si encontró el usuario, false si no
=======
        return resultado; 
>>>>>>> Dev:src/main/java/Repository/EnergiaRenovableRepository.java
    }
}

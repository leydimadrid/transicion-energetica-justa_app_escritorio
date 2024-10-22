/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import ConfigBD.ConexionSql;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leydi
 */
public class UsuarioRepository {
    
    private ConexionSql conexion;
    
   
    // Constructor
    public UsuarioRepository() {
        this.conexion = new ConexionSql();
    }
    
    
      /*  public List<Usuario> obtenerUsuarios() {
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

*/
    public boolean iniciarSesion(String email, String contrasenia) {
        Connection conn = null;
        boolean resultado = false;

        try {

            conn = conexion.conectar();

            if (conn != null) {

                String sql = "SELECT * FROM usuario WHERE email = ? AND contrasenia = ?";

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, contrasenia);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    resultado = true;
                }

                rs.close();
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            conexion.cerrarConexion(conn);
        }

        return resultado;
    }
    
}

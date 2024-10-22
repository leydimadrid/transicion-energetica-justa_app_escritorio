/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import ConfigBD.ConexionSql;
import Model.Usuario;
import Repository.UsuarioRepository;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leydi
 */
public class UsuarioService {
    
    public UsuarioRepository usuarioRepository;
     private Connection conexion;
    
       
    // Constructor
    public UsuarioService() {
        conexion = ConexionSql.conectar();
    }
    
  
    

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository= usuarioRepository;
    }

    
         
          public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Connection conn = null;

        try {
            conn = ConexionSql.conectar();

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
            ConexionSql.cerrarConexion(conn);
        }

        return usuarios;
    }
         
         
         
         public void agregarUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuario (nombre, email, contrasenia, rol) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getContrasenia());
        ps.setString(4, usuario.getRol());
        ps.executeUpdate();
        ps.close();
    }
         
         public void actualizarUsuario(Usuario usuario) throws SQLException {
        String query = "UPDATE usuarios SET nombre = ?, email = ?, contraseina = ?, rol = ? WHERE id = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getContrasenia());
        ps.setString(4, usuario.getRol());
        ps.setLong(5, usuario.getId());
        ps.executeUpdate();
        ps.close();
    }
  

    // Metodo para iniciar sesión
    public boolean iniciarSesion(String email, String contrasenia) {
        boolean inicioSesion = usuarioRepository.iniciarSesion(email, contrasenia);
        return inicioSesion;
    }
    
}

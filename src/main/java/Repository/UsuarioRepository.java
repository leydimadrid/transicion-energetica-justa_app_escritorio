/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import ConfigBD.ConexionSql;
import Model.Rol;
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

    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Connection conn = null;

        try {
            conn = conexion.conectar();

            if (conn != null) {
                // Realizar la unión para obtener el id y el nombre del rol
                String sql = "SELECT u.id, u.nombre, u.email, r.id AS rol_id, r.nombre AS rol_nombre "
                        + "FROM usuario u "
                        + "JOIN rol r ON u.rol_id = r.id";  // Asegúrate de que la columna de la clave foránea es 'rol_id'

                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    // Datos del usuario
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String email = rs.getString("email");

                    // Datos del rol
                    long rolId = rs.getLong("rol_id");
                    String rolNombre = rs.getString("rol_nombre");

                    // Crear objeto Rol
                    Rol rol = new Rol(rolId, rolNombre);

                    // Crear objeto Usuario con el Rol
                    Usuario usuario = new Usuario(id, nombre, email, rol);

                    // Agregar el usuario a la lista
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

    public void agregarUsuario(Usuario usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement psRol = null;
        PreparedStatement psUsuario = null;
        ResultSet rs = null;

        try {
            conn = conexion.conectar();

            if (conn != null) {
                // Primero, obtén el id del rol basado en el nombre del rol
                String queryRol = "SELECT id FROM rol WHERE nombre = ?";
                psRol = conn.prepareStatement(queryRol);
                psRol.setString(1, usuario.getRol().getNombre());  // usuario.getRol() devuelve el objeto Rol, usamos getNombre()

                rs = psRol.executeQuery();

                long rolId = -1;
                if (rs.next()) {
                    rolId = rs.getLong("id");  // Obtén el id del rol
                }

                if (rolId != -1) {
                    // Ahora inserta el usuario con el rol_id obtenido
                    String queryUsuario = "INSERT INTO usuario (nombre, email, contrasenia, rol_id) VALUES (?, ?, ?, ?)";
                    psUsuario = conn.prepareStatement(queryUsuario);
                    psUsuario.setString(1, usuario.getNombre());
                    psUsuario.setString(2, usuario.getEmail());
                    psUsuario.setString(3, usuario.getContrasenia());
                    psUsuario.setLong(4, rolId);  // Usa el id del rol obtenido previamente

                    psUsuario.executeUpdate();
                } else {
                    throw new SQLException("No se encontró un rol con ese nombre.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al agregar usuario", e);
        } finally {
            // Cerrar todos los recursos para evitar fugas de memoria
            if (rs != null) {
                rs.close();
            }
            if (psRol != null) {
                psRol.close();
            }
            if (psUsuario != null) {
                psUsuario.close();
            }
            if (conn != null) {
                conexion.cerrarConexion(conn);
            }
        }
    }

    public void actualizarUsuario(Usuario usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = conexion.conectar();

            if (conn != null) {
                // Actualizar el usuario, incluyendo el rol_id (clave foránea)
                String query = "UPDATE usuario SET nombre = ?, email = ?, contrasenia = ?, rol_id = ? WHERE id = ?";

                ps = conn.prepareStatement(query);
                ps.setString(1, usuario.getNombre());
                ps.setString(2, usuario.getEmail());
                ps.setString(3, usuario.getContrasenia());
                ps.setLong(4, usuario.getRol().getId());  // Se usa el ID del objeto Rol
                ps.setLong(5, usuario.getId());

                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al actualizar el usuario", e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            conexion.cerrarConexion(conn);
        }
    }
   
    public List<Rol> obtenerLitaRol() {
        List<Rol> roles = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = conexion.conectar(); // Conexión a la base de datos

            if (conn != null) {
                String sql = "SELECT id, nombre FROM rol";  // Consulta para obtener roles

                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                // Procesar los resultados de la consulta
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");

                    Rol rol = new Rol();
                    rol.setId(id);
                    rol.setNombre(nombre);

                    roles.add(rol);  // Agregar el rol a la lista
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Manejo de errores
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conexion.cerrarConexion(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return roles;  // Devolver la lista de roles
    }
}

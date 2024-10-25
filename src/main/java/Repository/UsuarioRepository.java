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
                String sql = "SELECT u.id, u.nombre, u.email, r.id AS rol_id, r.nombre AS rol_nombre "
                        + "FROM usuario u "
                        + "JOIN rol r ON u.rol_id = r.id";  

                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String email = rs.getString("email");

                    // Datos del rol
                    long rolId = rs.getLong("rol_id");
                    String rolNombre = rs.getString("rol_nombre");

                    Rol rol = new Rol(rolId, rolNombre);

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

    public void agregarUsuario(Usuario usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement psRol = null;
        PreparedStatement psUsuario = null;
        ResultSet rs = null;

        try {
            conn = conexion.conectar();

            if (conn != null) {
                String queryRol = "SELECT id FROM rol WHERE nombre = ?";
                psRol = conn.prepareStatement(queryRol);
                psRol.setString(1, usuario.getRol().getNombre()); 

                rs = psRol.executeQuery();

                long rolId = -1;
                if (rs.next()) {
                    rolId = rs.getLong("id");
                }

                if (rolId != -1) {
                    String queryUsuario = "INSERT INTO usuario (nombre, email, contrasenia, rol_id) VALUES (?, ?, ?, ?)";
                    psUsuario = conn.prepareStatement(queryUsuario);
                    psUsuario.setString(1, usuario.getNombre());
                    psUsuario.setString(2, usuario.getEmail());
                    psUsuario.setString(3, usuario.getContrasenia());
                    psUsuario.setLong(4, rolId); 

                    psUsuario.executeUpdate();
                } else {
                    throw new SQLException("No se encontró un rol con ese nombre.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al agregar usuario", e);
        } finally {
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
                String query = "UPDATE usuario SET nombre = ?, email = ?, contrasenia = ?, rol_id = ? WHERE id = ?";

                ps = conn.prepareStatement(query);
                ps.setString(1, usuario.getNombre());
                ps.setString(2, usuario.getEmail());
                ps.setString(3, usuario.getContrasenia());
                ps.setLong(4, usuario.getRol().getId()); 
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
            conn = conexion.conectar(); 

            if (conn != null) {
                String sql = "SELECT id, nombre FROM rol"; 

                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");

                    Rol rol = new Rol();
                    rol.setId(id);
                    rol.setNombre(nombre);

                    roles.add(rol);  
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conexion.cerrarConexion(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return roles;  
    }

    public Usuario obtenerUsuarioByEmail(String email) {
        Usuario usuario = null;
        Connection conn = null;

        try {
            conn = conexion.conectar();

            if (conn != null) {
                String sql = "SELECT u.id, u.nombre, u.email, u.contrasenia, r.id AS rol_id, r.nombre AS rol_nombre "
                        + "FROM usuario u "
                        + "JOIN rol r ON u.rol_id = r.id "
                        + "WHERE u.email = ?"; 

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, email);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String emailObtenido = rs.getString("email");
                    String contrasenia = rs.getString("contrasenia");

                    long rolId = rs.getLong("rol_id");
                    String rolNombre = rs.getString("rol_nombre");
                    Rol rol = new Rol(rolId, rolNombre);
                    usuario = new Usuario(id, nombre, emailObtenido, contrasenia, rol);
                }

                rs.close();
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion(conn);
        }

        return usuario;
    }

    public Usuario eliminarUsuarioById(long id) {
        Connection conn = null;
        Usuario usuarioEliminado = null;

        try {
            conn = conexion.conectar();

            if (conn != null) {
                String selectSql = "SELECT u.id, u.nombre, u.email, u.contrasenia, r.id AS rol_id, r.nombre AS rol_nombre "
                        + "FROM usuario u "
                        + "JOIN rol r ON u.rol_id = r.id "
                        + "WHERE u.id = ?";
                PreparedStatement selectPs = conn.prepareStatement(selectSql);
                selectPs.setLong(1, id);

                ResultSet rs = selectPs.executeQuery();

                if (rs.next()) {
                    int userId = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String email = rs.getString("email");
                    String contrasenia = rs.getString("contrasenia");
                    long rolId = rs.getLong("rol_id");
                    String rolNombre = rs.getString("rol_nombre");
                    Rol rol = new Rol(rolId, rolNombre);
                    usuarioEliminado = new Usuario(userId, nombre, email, contrasenia, rol);
                }

                rs.close();
                selectPs.close();
                if (usuarioEliminado != null) {
                    String deleteSql = "DELETE FROM usuario WHERE id = ?";
                    PreparedStatement deletePs = conn.prepareStatement(deleteSql);
                    deletePs.setLong(1, id);

                    deletePs.executeUpdate(); 
                    deletePs.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion(conn);
        }

        return usuarioEliminado; 
    }

}

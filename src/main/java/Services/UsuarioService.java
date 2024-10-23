/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import ConfigBD.ConexionSql;
import Model.Rol;
import Model.Usuario;
import Repository.UsuarioRepository;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leydi
 */
public class UsuarioService {
    
    public UsuarioRepository usuarioRepository;
      
    // Constructor
    public UsuarioService() {
     
    }
 
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository= usuarioRepository;
    }

    
         
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioRepository.obtenerUsuarios();     
        return usuarios;
    }
         
         
         
    public void agregarUsuario(Usuario usuario){
        try {
            usuarioRepository.agregarUsuario(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
         
    public void actualizarUsuario(Usuario usuario) {
       try {
            usuarioRepository.actualizarUsuario(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  

    // Metodo para iniciar sesión
    public boolean iniciarSesion(String email, String contrasenia) {
        boolean inicioSesion = usuarioRepository.iniciarSesion(email, contrasenia);
        return inicioSesion;
    }
     public List<Rol> obtenerListaRol() {

        List<Rol> rol = usuarioRepository.obtenerLitaRol();
        return rol;
    }
    
}

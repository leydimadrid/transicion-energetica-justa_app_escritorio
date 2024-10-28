/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import ConfigBD.ConexionSql;
import Model.Dtos.ProduccionEnergia;
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

    // Método para obtener la producción total de energía
    public List<ProduccionEnergia> obtenerProduccionTotalEnergia(String fuente, int anio) {
        List<ProduccionEnergia> produccionList = new ArrayList<>();
        Connection conn = null;

        try {
            conn = conexion.conectar();
            if (conn != null) {
                String sql = "SELECT " +
                             "er.nombre_fuente AS tipo_energia, " +
                             "pp.isla_departamento AS region, " +
                             "SUM(pp.disponibilidad_horas) AS produccion_total " +
                             "FROM planta_produccion pp " +
                             "JOIN energia_renovable er ON pp.energia_renovable_id = er.energia_renovable_id " +
                             "WHERE pp.anio = ? AND er.nombre_fuente = ? " +
                             "GROUP BY er.nombre_fuente, pp.isla_departamento " +
                             "ORDER BY er.nombre_fuente, pp.isla_departamento";

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, anio);
                ps.setString(2, fuente);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    ProduccionEnergia produccion = new ProduccionEnergia();
                    produccion.setTipoEnergia(rs.getString("tipo_energia"));
                    produccion.setRegion(rs.getString("region"));
                    produccion.setProduccionTotal(rs.getDouble("produccion_total"));
                    produccionList.add(produccion);
                }

                rs.close();
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            conexion.cerrarConexion(conn);
        }

        return produccionList; 
    }

   
    public String obtenerPorcentajeConsumoElectricoTotalRegion(String fuente, String anio) {
        return fuente + anio;
    }
}

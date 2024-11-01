/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import ConfigBD.ConexionSql;
import Model.Dtos.CapacidadInstaladaSolar;
import Model.Dtos.ConsumoRegion;
import Model.Dtos.ProduccionEnergia;
import Model.EnergiaEolica;
import Model.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                String sql = "SELECT " + "er.nombre_fuente AS tipo_energia, "
                        + "pp.isla_departamento AS region, "
                        + "SUM(pp.disponibilidad_horas) AS produccion_total "
                        + "FROM planta_produccion pp "
                        + "JOIN energia_renovable er ON pp.energia_renovable_id = er.energia_renovable_id "
                        + "WHERE pp.anio = ? AND er.nombre_fuente = ? "
                        + "GROUP BY er.nombre_fuente, pp.isla_departamento "
                        + "ORDER BY er.nombre_fuente, pp.isla_departamento";

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

    public List<ConsumoRegion> obtenerPorcentajeConsumoElectricoTotalRegion() {
        List<ConsumoRegion> listaConsumoRegion = new ArrayList<>();
        Connection conn = null;

        try {
            conn = conexion.conectar();
            if (conn != null) {
                String sql = "SELECT "
                        + "p.nombre AS Region, "
                        + "COALESCE(SUM(c.cantidad_consumida), 0) AS consumo_total, "
                        + "COALESCE(SUM(p2.disponibilidad_horas), 0) AS capacidad_instalada_energia_renovable, "
                        + "(COALESCE(SUM(c.cantidad_consumida), 0) / NULLIF(SUM(p2.disponibilidad_horas), 0)) * 100 AS porcentaje_energia_renovable "
                        + "FROM pais p "
                        + "LEFT JOIN consumo c ON p.pais_id = c.pais_id "
                        + "LEFT JOIN energia_renovable er ON c.energia_renovable_id = er.energia_renovable_id "
                        + "LEFT JOIN (SELECT SUM(disponibilidad_horas) AS disponibilidad_horas FROM planta_produccion) p2 ON 1 = 1 "
                        + "GROUP BY p.nombre "
                        + "ORDER BY p.nombre";

                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String region = rs.getString("Region");
                    double consumoTotal = rs.getDouble("consumo_total");
                    double capacidadInstalada = rs.getDouble("capacidad_instalada_energia_renovable");
                    double porcentajeEnergiaRenovable = rs.getDouble("porcentaje_energia_renovable");

                    ConsumoRegion consumoRegion = new ConsumoRegion(region, consumoTotal, capacidadInstalada, porcentajeEnergiaRenovable);
                    listaConsumoRegion.add(consumoRegion);
                }

                rs.close();
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion(conn);
        }

        return listaConsumoRegion;
    }

    public List<CapacidadInstaladaSolar> obtenerCapacidadInstaladaEnergiaSolarTodosLosAnios() {
        List<CapacidadInstaladaSolar> capacidadList = new ArrayList<>();
        Connection conn = null;

        try {
            conn = conexion.conectar();
            if (conn != null) {
                String sql = "SELECT anio, SUM(capacidad_instalador) AS capacidad_total_instalada "
                        + "FROM energia_solar "
                        + "GROUP BY anio "
                        + "ORDER BY anio";

                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    CapacidadInstaladaSolar capacidad = new CapacidadInstaladaSolar();
                    capacidad.setAnio(rs.getInt("anio"));
                    capacidad.setCapacidadTotalInstalada(rs.getDouble("capacidad_total_instalada"));
                    capacidadList.add(capacidad);
                }

                rs.close();
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion(conn);
        }

        return capacidadList;
    }


    /*

       public List<PorcentajeConsumoElectrico> obtenerPorcentajeConsumoElectricoTotalRegion() {
        List<PorcentajeConsumoElectrico> porcentajeList = new ArrayList<>();
        Connection conn = null;

        try {
            conn = conexion.conectar();
            if (conn != null) {
                String sql = "SELECT " +
                        "pp.isla_departamento AS region, " +
                        "er.nombre_fuente AS tipo_energia, " +
                        "SUM(pp.disponibilidad_horas) AS produccion_renovable, " +
                        "SUM(COALESCE(pp.total_energia, 0)) AS consumo_total, " +
                        "(SUM(pp.disponibilidad_horas) / NULLIF(SUM(COALESCE(pp.total_energia, 0)), 0)) * 100 AS porcentaje_renovable " +
                        "FROM planta_produccion pp " +
                        "JOIN energia_renovable er ON pp.energia_renovable_id = er.energia_renovable_id " +
                        "GROUP BY pp.isla_departamento, er.nombre_fuente " +
                        "ORDER BY porcentaje_renovable DESC";

                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    PorcentajeConsumoElectrico porcentaje = new PorcentajeConsumoElectrico();
                    porcentaje.setRegion(rs.getString("region"));
                    porcentaje.setTipoEnergia(rs.getString("tipo_energia"));
                    porcentaje.setProduccionRenovable(rs.getDouble("produccion_renovable"));
                    porcentaje.setConsumoTotal(rs.getDouble("consumo_total"));
                    porcentaje.setPorcentajeRenovable(rs.getDouble("porcentaje_renovable"));
                    porcentajeList.add(porcentaje);
                }

                rs.close();
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion(conn);
        }

        return porcentajeList;
    }
     */
    public List<EnergiaEolica> obtenerTop10PaisesEolica(int anio) {
        List<EnergiaEolica> energiaEolicaList = new ArrayList<>();
        Connection conn = null;

        try {
            conn = conexion.conectar();
            if (conn != null) {

                String sql = "SELECT region, SUM(produccion) AS total_produccion "
                        + "FROM energia_eolica " + "WHERE anio = ? "
                        + "GROUP BY region " + "ORDER BY total_produccion DESC "
                        + "LIMIT 10";

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, anio);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    double total_produccion = rs.getDouble("total_produccion");
                    String region = rs.getString("region");

                    EnergiaEolica energiaEolica = new EnergiaEolica();
                    energiaEolica.setNombreFuente(region);
                    energiaEolica.setAnio(anio);
                    energiaEolica.setCapacidadRotor(total_produccion);
                    energiaEolicaList.add(energiaEolica);
                }
                rs.close();
                ps.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion(conn);
        }
        return energiaEolicaList;
    }

    public Map<String, Double> obtenerParticipacionConsumo() {
        Map<String, Double> consumoMap = new HashMap<>();
        Connection conn = null;
        try {
            conn = conexion.conectar();
            if (conn != null) {
                String sql = "SELECT c.cantidad_consumida, e.nombre_fuente AS fuente_energia "
                        + "FROM consumo c "
                        + "JOIN energia_Renovable e ON c.energia_renovable_id = e.energia_renovable_id";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String fuente = rs.getString("fuente_energia");
                    double consumo = rs.getDouble("cantidad_consumida");
                    consumoMap.put(fuente, consumo);
                }
                rs.close();
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion(conn);
        }
        return consumoMap;
    }

}

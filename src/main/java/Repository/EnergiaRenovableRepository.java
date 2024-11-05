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
                String sql = SqlQueries.OBTENER_PRODUCCION_TOTAL_ENERGIA;

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
                String sql = SqlQueries.OBTENER_PORCENTAJE_CONSUMO_REGION;

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
                String sql = SqlQueries.OBTENER_CAPACIDAD_INSTALADA_SOLAR;
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

    public List<EnergiaEolica> obtenerTop10PaisesEolica(int anio) {
        List<EnergiaEolica> energiaEolicaList = new ArrayList<>();
        Connection conn = null;

        try {
            conn = conexion.conectar();
            if (conn != null) {

                String sql = SqlQueries.OBTENER_TOP_10_PAISES_EOLICA;

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
                String sql = SqlQueries.OBTENER_PARTICIPACION_CONSUMO;
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

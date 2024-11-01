/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

/**
 *
 * @author MI PC
 */
public class SqlQueries {
     public static final String OBTENER_PRODUCCION_TOTAL_ENERGIA = 
        "SELECT er.nombre_fuente AS tipo_energia, "
        + "pp.isla_departamento AS region, "
        + "SUM(pp.disponibilidad_horas) AS produccion_total "
        + "FROM planta_produccion pp "
        + "JOIN energia_renovable er ON pp.energia_renovable_id = er.energia_renovable_id "
        + "WHERE pp.anio = ? AND er.nombre_fuente = ? "
        + "GROUP BY er.nombre_fuente, pp.isla_departamento "
        + "ORDER BY er.nombre_fuente, pp.isla_departamento";

    public static final String OBTENER_PORCENTAJE_CONSUMO_REGION =
        "SELECT p.nombre AS Region, "
        + "COALESCE(SUM(c.cantidad_consumida), 0) AS consumo_total, "
        + "COALESCE(SUM(p2.disponibilidad_horas), 0) AS capacidad_instalada_energia_renovable, "
        + "(COALESCE(SUM(c.cantidad_consumida), 0) / NULLIF(SUM(p2.disponibilidad_horas), 0)) * 100 AS porcentaje_energia_renovable "
        + "FROM pais p "
        + "LEFT JOIN consumo c ON p.pais_id = c.pais_id "
        + "LEFT JOIN energia_renovable er ON c.energia_renovable_id = er.energia_renovable_id "
        + "LEFT JOIN (SELECT SUM(disponibilidad_horas) AS disponibilidad_horas FROM planta_produccion) p2 ON 1 = 1 "
        + "GROUP BY p.nombre "
        + "ORDER BY p.nombre";

    public static final String OBTENER_CAPACIDAD_INSTALADA_SOLAR =
        "SELECT anio, SUM(capacidad_instalador) AS capacidad_total_instalada "
        + "FROM energia_solar "
        + "GROUP BY anio "
        + "ORDER BY anio";
    
    public static final String OBTENER_TOP_10_PAISES_EOLICA =
        "SELECT region, SUM(produccion) AS total_produccion "
        + "FROM energia_eolica "
        + "WHERE anio = ? "
        + "GROUP BY region "
        + "ORDER BY total_produccion DESC "
        + "LIMIT 10";

    public static final String OBTENER_PARTICIPACION_CONSUMO =
        "SELECT c.cantidad_consumida, e.nombre_fuente AS fuente_energia "
        + "FROM consumo c "
        + "JOIN energia_Renovable e ON c.energia_renovable_id = e.energia_renovable_id";
}

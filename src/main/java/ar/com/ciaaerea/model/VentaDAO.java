package ar.com.ciaaerea.model;

import ar.com.ciaaerea.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    public String GenerarSerie(){
        String numeroSerie = "";
        String sql = "select max(numeroSerie) from venta";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                numeroSerie = rs.getString(1);
            }
        }catch(Exception e){
            
        }
        return numeroSerie;
    }
    
    public String idVentas(){
        String idVentas="";
        String sql = "select max (idVentas) from venta";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                idVentas = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idVentas;
    }
    
    public int guardarVenta(Venta ve){
        String sql = "insert into venta(nombrePax,vuelo,monto,estado)values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ve.getNombrePax());
            ps.setString(2, ve.getVuelo());
            ps.setDouble(3, ve.getMonto());
            ps.setString(4, ve.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public int guardarDetalleVentas(Venta ve){
        String sql = "insert into detalle_venta()values()";
        try {
            
        } catch (Exception e) {
        }
        return r;       
    }
}

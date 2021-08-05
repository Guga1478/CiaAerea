package ar.com.ciaaerea.model;

import ar.com.ciaaerea.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FlotaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Flota validar(String modelo){
        Flota fl = new Flota();
        String sql = "select * from flota where modelo=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, modelo);
            rs=ps.executeQuery();
            while(rs.next()){
                fl.setId(rs.getInt("id"));
                fl.setModelo(rs.getString("modelo"));
                fl.setCapacidad(rs.getString("capacidad"));
                fl.setMaxVenta(rs.getString("maxVenta"));
            }
        } catch (Exception e) {
        }
        return fl;
    }
    
    public List listar(){
        String sql = "select * from flota";
        List<Flota> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Flota fl = new Flota();
                fl.setId(rs.getInt(1));
                fl.setModelo(rs.getString(2));
                fl.setCapacidad(rs.getString(3));
                fl.setMaxVenta(rs.getString(4));
                lista.add(fl);
            }
        } catch (Exception e) {
        }
     return lista;   
    }
    
    public int agregar(Flota fl){
        String sql = "insert into flota(modelo,capacidad,max_venta)values(?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, fl.getModelo());
            ps.setString(2, fl.getCapacidad());
            ps.setString(3, fl.getMaxVenta());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public Flota listarId(int id){
        Flota fl = new Flota();
        String sql = "select * from flota where id="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                fl.setModelo(rs.getString(2));
                fl.setCapacidad(rs.getString(3));
                fl.setMaxVenta(rs.getString(4));
            }
        } catch (Exception e) {
        }
        return fl;
    }
    
    public int actualizar(Flota fl){
        String sql = "update flota set modelo=?, capacidad=?, max_venta=? where id=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, fl.getModelo());
            ps.setString(2, fl.getCapacidad());
            ps.setString(3, fl.getMaxVenta());
            ps.setInt(4, fl.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;        
    }
    
    public void delete(int id){
        String sql = "delete from flota where id="+id;
        try {
            con=cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public Flota buscar(String modelo){
        Flota fl = new Flota();
        String sql = "select * from flota where modelo=?"+modelo;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                fl.setId(rs.getInt(1));
                fl.setCapacidad(rs.getString(2));
                fl.setMaxVenta(rs.getString(3));
            }
        } catch (Exception e) {
        }
        return fl;
    }
    
}

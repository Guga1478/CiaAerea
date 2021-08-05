package ar.com.ciaaerea.model;

import ar.com.ciaaerea.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VuelosDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Vuelos validar(String numero){
        Vuelos vu = new Vuelos();
        String sql = "select * from vuelos where numero=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, numero);
            rs=ps.executeQuery();
            while(rs.next()){
                vu.setIdVuelo(rs.getInt("idVuelo"));
                vu.setNumero(rs.getString("numero"));
                vu.setAvionId(rs.getInt("avionId"));
                vu.setOrigen(rs.getString("origen"));
                vu.setDestino(rs.getString("destino"));
                vu.setHorario(rs.getString("horario"));
            }
        } catch (Exception e) {
        }
        return vu;
    }
    
    public List listar(){
        String sql ="select * from vuelos";
        List<Vuelos>lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Vuelos vu = new Vuelos();
                vu.setIdVuelo(rs.getInt(1));
                vu.setNumero(rs.getString(2));
                vu.setAvionId(rs.getInt(3));
                vu.setOrigen(rs.getString(4));
                vu.setDestino(rs.getString(5));
                vu.setHorario(rs.getString(6));
                lista.add(vu);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int agregar(Vuelos vu){
        String sql = "insert into vuelos(numero,avionId,origen,destino,horario)values(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, vu.getNumero());
            ps.setInt(2, vu.getAvionId());
            ps.setString(3, vu.getOrigen());
            ps.setString(4, vu.getDestino());
            ps.setString(5, vu.getHorario());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public Vuelos listarId(int idVuelo){
        Vuelos vu = new Vuelos();
        String sql = "select * from vuelos where idVuelo="+idVuelo;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                vu.setNumero(rs.getString(2));
                vu.setAvionId(rs.getInt(3));
                vu.setOrigen(rs.getString(4));
                vu.setDestino(rs.getString(5));
                vu.setHorario(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return vu;
    }
    
    public int actualizar(Vuelos vu){
        String sql = "update vuelos set numero=?, avionId=?, origen=?, destino=?, horario=? where idVuelo=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, vu.getNumero());
            ps.setInt(2, vu.getAvionId());
            ps.setString(3, vu.getOrigen());
            ps.setString(4, vu.getDestino());
            ps.setString(5, vu.getHorario());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;        
    }
    
    public void delete(int idVuelo){
        String sql = "delete from vuelos where idVuelo="+idVuelo;
        try {
            con=cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
}

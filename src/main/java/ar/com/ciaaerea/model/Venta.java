package ar.com.ciaaerea.model;

public class Venta {
    private int idVenta;
    private String nombrePax;
    private String vuelo;
    private double monto;
    private String estado;

    public Venta() {
    }

    public Venta(int idVenta, String nombrePax, String vuelo, double monto, String estado) {
        this.idVenta = idVenta;
        this.nombrePax = nombrePax;
        this.vuelo = vuelo;
        this.monto = monto;
        this.estado = estado;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getNombrePax() {
        return nombrePax;
    }

    public void setNombrePax(String nombrePax) {
        this.nombrePax = nombrePax;
    }

    public String getVuelo() {
        return vuelo;
    }

    public void setVuelo(String vuelo) {
        this.vuelo = vuelo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", nombrePax=" + nombrePax + ", vuelo=" + vuelo + ", monto=" + monto + ", estado=" + estado + '}';
    }
    
    
    
}

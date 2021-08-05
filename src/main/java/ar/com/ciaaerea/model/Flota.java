package ar.com.ciaaerea.model;

public class Flota {
    private int id;
    private String modelo;
    private String capacidad;
    private String maxVenta;

    public Flota() {
    }

    public Flota(int id, String modelo, String capacidad, String maxVenta) {
        this.id = id;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.maxVenta = maxVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getMaxVenta() {
        return maxVenta;
    }

    public void setMaxVenta(String maxVenta) {
        this.maxVenta = maxVenta;
    }

    @Override
    public String toString() {
        return "Flota{" + "id=" + id + ", modelo=" + modelo + ", capacidad=" + capacidad + ", maxVenta=" + maxVenta + '}';
    }
    
    
    
}

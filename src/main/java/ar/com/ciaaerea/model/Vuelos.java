package ar.com.ciaaerea.model;

public class Vuelos {
    private int idVuelo;
    private String numero;
    private int avionId;
    private String origen;
    private String destino;
    private String horario;

    public Vuelos() {
    }

    public Vuelos(int idVuelo, String numero, int avionId, String origen, String destino, String horario) {
        this.idVuelo = idVuelo;
        this.numero = numero;
        this.avionId = avionId;
        this.origen = origen;
        this.destino = destino;
        this.horario = horario;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getAvionId() {
        return avionId;
    }

    public void setAvionId(int avionId) {
        this.avionId = avionId;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Vuelos{" + "idVuelo=" + idVuelo + ", numero=" + numero + ", avionId=" + avionId + ", origen=" + origen + ", destino=" + destino + ", horario=" + horario + '}';
    }
    
    
    
}


package Modelo;

public class OrdenDeReparacion {

    public int numOrden;
    public String cliente;
    public String fecha;
    public String hora;
    public String equipo;
    public String fallas;
    public String accesorios;
    public String motivo;
    public String tecnico;
    public String fechaEstimada;
    public String diagnostico;
    public String montoTotal;
    public String sena;
    public String estado;


    public OrdenDeReparacion(int numOrden, String cliente, String fecha, String equipo, String fallas, String motivo,String tecnico, String estado,String accesorios , String fechaEstimada,String hora, String diagnostico, String montoTotal ,String sena) {
        this.numOrden = numOrden;
        this.cliente = cliente;
        this.fecha = fecha;
        this.hora = hora;
        this.equipo = equipo;
        this.fallas = fallas;
        this.accesorios = accesorios;
        this.motivo = motivo;
        this.tecnico = tecnico;
        this.fechaEstimada = fechaEstimada;
        this.diagnostico = diagnostico;
        this.montoTotal = montoTotal;
        this.sena = sena;
        this.estado = estado;
    }

    OrdenDeReparacion() {
        
    }

    public int getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(int numOrden) {
        this.numOrden = numOrden;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getFallas() {
        return fallas;
    }

    public void setFallas(String fallas) {
        this.fallas = fallas;
    }

    public String getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(String accesorios) {
        this.accesorios = accesorios;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getFechaEstimada() {
        return fechaEstimada;
    }

    public void setFechaEstimada(String fechaEstimada) {
        this.fechaEstimada = fechaEstimada;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(String montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getSena() {
        return sena;
    }

    public void setSeña(String sena) {
        this.sena = sena;
    }

        public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }   

}

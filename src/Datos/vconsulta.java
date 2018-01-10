
package Datos;

import java.sql.Date;


public class vconsulta {

    private int idconsulta;
    private int idcliente;
    private int idtrabajador;
    private Date fecha_consulta;
    private String estado_consulta;
    private String motivo_consulta;

    public vconsulta() {
    }

    public vconsulta(int idconsulta, int idcliente, int idtrabajador, Date fecha_consulta, String estado_consulta, String motivo_consulta) {
        this.idconsulta = idconsulta;
        this.idcliente = idcliente;
        this.idtrabajador = idtrabajador;
        this.fecha_consulta = fecha_consulta;
        this.estado_consulta = estado_consulta;
        this.motivo_consulta = motivo_consulta;
    }

    public int getIdconsulta() {
        return idconsulta;
    }

    public void setIdconsulta(int idconsulta) {
        this.idconsulta = idconsulta;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(int idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public Date getFecha_consulta() {
        return fecha_consulta;
    }

    public void setFecha_consulta(Date fecha_consulta) {
        this.fecha_consulta = fecha_consulta;
    }

    public String getEstado_consulta() {
        return estado_consulta;
    }

    public void setEstado_consulta(String estado_consulta) {
        this.estado_consulta = estado_consulta;
    }

    public String getMotivo_consulta() {
        return motivo_consulta;
    }

    public void setMotivo_consulta(String motivo_consulta) {
        this.motivo_consulta = motivo_consulta;
    }
    
    
}
    
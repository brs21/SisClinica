package Datos;

import java.io.FileInputStream;
import java.sql.Date;

/**
 *
 * @author Boris
 */
public class vpersona {
    private int idpersona;
    private String nombre;
    private String apellido;
    private String tipo_documento;
    private String numero_documento;
    private String direccion;
    private String telefono;
    private String email;
    private Date fecha_nacimiento;
    private String nom_imagen;
    private FileInputStream imagen;

    public vpersona() {
    }

    public vpersona(int idpersona, String nombre, String apellido, String tipo_documento, String numero_documento, String direccion, String telefono, String email, Date fecha_nacimiento, String nom_imagen, FileInputStream imagen) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nom_imagen = nom_imagen;
        this.imagen = imagen;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNom_imagen() {
        return nom_imagen;
    }

    public void setNom_imagen(String nom_imagen) {
        this.nom_imagen = nom_imagen;
    }

    public FileInputStream getImagen() {
        return imagen;
    }

    public void setImagen(FileInputStream imagen) {
        this.imagen = imagen;
    }

    
    
    
    
    
}
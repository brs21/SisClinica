
package Logica;

import Datos.vcliente;
import Datos.vtrabajador;
//import Datos.vproducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Boris
 */
public class ftrabajador {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre", "Apellido", "Doc", "Número de Documento", "Dirección", "Teléfono", "Correo","Fecha Nac", "Sueldo", "Acceso", "Login", "Clave", "Estado"};
        String[] registro = new String[14];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select p.idpersona,p.nombre,p.apellido,p.tipo_documento,p.numero_documento, "
                + "p.direccion,p.telefono,p.email,p.fecha_nacimiento,t.sueldo,t.acceso,t.login,t.password,t.estado from persona p inner join trabajador t "
                + "on p.idpersona = t.idpersona where numero_documento like '%"
                + buscar + "%' order by idpersona desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("tipo_documento");
                registro[4] = rs.getString("numero_documento");
                registro[5] = rs.getString("direccion");
                registro[6] = rs.getString("telefono");
                registro[7] = rs.getString("email");
                registro[8] = rs.getString("fecha_nacimiento");
                registro[9] = rs.getString("sueldo");
                registro[10] = rs.getString("acceso");
                registro[11] = rs.getString("login");
                registro[12] = rs.getString("password");
                registro[13] = rs.getString("estado");
                
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vtrabajador dts) {
        sSQL = "insert into persona (nombre,apellido,tipo_documento,numero_documento,direccion,telefono,email,fecha_nacimiento)"
                + "values (?,?,?,?,?,?,?,?)";
        sSQL2 = "insert into trabajador (idpersona,sueldo,acceso,login,password,estado)"
                + "values ((select idpersona from persona order by idpersona desc limit 1),?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getTipo_documento());
            pst.setString(4, dts.getNumero_documento());
            pst.setString(5, dts.getDireccion());
            pst.setString(6, dts.getTelefono());
            pst.setString(7, dts.getEmail());
            pst.setDate(8, dts.getFecha_nacimiento());
            
            pst2.setDouble(1, dts.getSueldo());
            pst2.setString(2, dts.getAcceso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            pst2.setString(5, dts.getEstado());
            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex);
            return false;
        }

    }

    public boolean editar(vtrabajador dts) {
        sSQL = "update persona set nombre = ?, apellido = ?, tipo_documento = ?, numero_documento = ?,"
                + "direccion = ?, telefono = ?,  email = ?,fecha_nacimiento=? where idpersona = ?";

        sSQL2 = "update trabajador set sueldo  = ?, acceso =?, login =?, password =?, estado=?"
                + "where idpersona = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getTipo_documento());
            pst.setString(4, dts.getNumero_documento());
            pst.setString(5, dts.getDireccion());
            pst.setString(6, dts.getTelefono());
            pst.setString(7, dts.getEmail());
            pst.setDate(8, dts.getFecha_nacimiento());
            pst.setInt(9, dts.getIdpersona());

            pst2.setDouble(1, dts.getSueldo());
            pst2.setString(2, dts.getAcceso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            pst2.setString(5, dts.getEstado());
            pst2.setInt(6, dts.getIdpersona());
            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex);
            return false;
        }

    }

    public boolean eliminar(vtrabajador dts) {
        sSQL = "delete from trabajador where idpersona = ?";
        sSQL2 = "delete from persona where idpersona = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setInt(1, dts.getIdpersona());

            pst2.setInt(1, dts.getIdpersona());
            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex);
            return false;
        }
    }
    
    public DefaultTableModel login(String login, String password) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre", "Apellido", "Acceso", "Login", "Clave", "Estado"};
        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select p.idpersona,p.nombre,p.apellido,"
                + "t.acceso,t.login,t.password,t.estado from persona p inner join trabajador t "
                + "on p.idpersona = t.idpersona where t.login = '"
                + login + "' and  t.password = '"+password+"' and t.estado ='A'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("acceso");
                registro[4] = rs.getString("login");
                registro[5] = rs.getString("password");
                registro[6] = rs.getString("estado");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
}

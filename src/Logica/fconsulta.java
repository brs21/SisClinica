/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vconsulta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Boris
 */
public class fconsulta {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre", "Apelldo", "Nombre Imagen", "Imagen", "Id consulta", "Fecha Cosnulta", "Motivo", "Alergia", "Diagnostico", "Tratamiento", "Estado"};
        String[] registro = new String[12];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select p.idpersona,p.nombre,p.apellido,"
                + "p.nom_imagen,p.imagen,c.idconsulta,c.fecha_consulta,c.estado_consulta,c.motivo_consulta,"
                + "(select alergico from expediente where idpersona = p.idpersona) as expaler, "
                + "(select diagnostico from expediente where idpersona = p.idpersona) as expdia,"
                + "(select tratamiento from expediente where idpersona = p.idpersona) as exptrata"
                + " from persona p inner join consulta c "
                + "on p.idpersona = c.idcliente and c.estado_consulta = 'Espera' where fecha_consulta like '%"
                + buscar + "%' order by fecha_consulta desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("nom_imagen");
                registro[4] = rs.getString("imagen");
                registro[5] = rs.getString("idconsulta");
                registro[6] = rs.getString("fecha_consulta");
                registro[7] = rs.getString("motivo_consulta");
                registro[8] = rs.getString("expaler");
                registro[9] = rs.getString("expdia");
                registro[10] = rs.getString("exptrata");
                registro[11] = rs.getString("estado_consulta");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vconsulta dts) {
        sSQL = "insert into consulta (idcliente,idtrabajador,fecha_consulta,estado_consulta,motivo_consulta)"
                + "values (?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdcliente());
            pst.setInt(2, dts.getIdtrabajador());
            pst.setDate(3, dts.getFecha_consulta());
            pst.setString(4, dts.getEstado_consulta());
            pst.setString(5, dts.getMotivo_consulta());
            int n = pst.executeUpdate();

            if (n != 0) {

                return true;

            } else {
                return false;
            }

        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex);
            return false;
        }

    }

    public boolean editar(vconsulta dts) {
        sSQL = "update consulta set estado_consulta = ?"
                + "where idconsulta=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            

            pst.setString(1, dts.getEstado_consulta());
            pst.setInt(2, dts.getIdconsulta());
            
            int n = pst.executeUpdate();

            if (n != 0) {

                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex);
            return false;
        }

    }

    public boolean eliminar(vconsulta dts) {
        sSQL = "delete from cliente where idpersona = ?";
        sSQL2 = "delete from persona where idpersona = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            /*pst.setInt(1, dts.getIdpersona());

            pst2.setInt(1, dts.getIdpersona());*/
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

    public DefaultTableModel mostrar(Date buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

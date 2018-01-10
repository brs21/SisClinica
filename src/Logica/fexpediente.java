package Logica;

import Datos.vexpediente;
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
public class fexpediente {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";

    public Integer totalregistros;

    
    

    public boolean editar(vexpediente dts) {
        sSQL = "update expediente set motivo_consulta = ?, antecedentes = ?, alergico = ?, diagnostico = ?,"
                + "tratamiento = ? "
                + "where idpersona = ?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getMotivo_consulta());
            pst.setString(2, dts.getAntecedentes());
            pst.setString(3, dts.getAlergico());
            pst.setString(4, dts.getDiagnostico());
            pst.setString(5, dts.getTratamiento());
            pst.setInt(6, dts.getIdpersona());

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
}

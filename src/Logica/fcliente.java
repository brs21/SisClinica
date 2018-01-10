package Logica;

import Datos.vcliente;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
//import Datos.vproducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Boris
 */
public class fcliente {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    private String sSQL3 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre", "Apelldo", "Doc", "Número de Documento", "Dirección", "Teléfono", "Correo", "Fecha Nac", "Código", "NombreImagen", "Imagen"};
        String[] registro = new String[12];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select p.idpersona,p.nombre,p.apellido,p.tipo_documento,p.numero_documento, "
                + "p.direccion,p.telefono,p.email,p.fecha_nacimiento,p.nom_imagen,p.imagen,c.codigo_cliente from persona p inner join cliente c "
                + "on p.idpersona = c.idpersona where nombre like '%"
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
                registro[9] = rs.getString("codigo_cliente");
                registro[10] = rs.getString("nom_imagen");
                registro[11] = rs.getString("imagen");
                
                
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
    public Image obtenerImagenEnBD(int idpersona) throws IOException {
      Image rpta = null;
      String sql ="select imagen from persona where idpersona ="+ idpersona;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            Blob imagen = null;
            while(rs.next()){
                imagen = rs.getBlob("imagen");
                rpta = javax.imageio.ImageIO.read(imagen.getBinaryStream());
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(fcliente.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
      return rpta;
    } 
    

    public boolean insertar(vcliente dts) {
        sSQL = "insert into persona (nombre,apellido,tipo_documento,numero_documento,direccion,telefono,"
                + "email,fecha_nacimiento,nom_imagen,imagen)"
                + "values (?,?,?,?,?,?,?,?,?,?)";
        sSQL2 = "insert into cliente (idpersona,codigo_cliente)"
                + "values ((select idpersona from persona order by idpersona desc limit 1),?)";

        sSQL3 = "insert into expediente (idpersona)"
                + "values ((select idpersona from persona order by idpersona desc limit 1))";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            PreparedStatement pst3 = cn.prepareStatement(sSQL3);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getTipo_documento());
            pst.setString(4, dts.getNumero_documento());
            pst.setString(5, dts.getDireccion());
            pst.setString(6, dts.getTelefono());
            pst.setString(7, dts.getEmail());
            pst.setDate(8, dts.getFecha_nacimiento());
            pst.setString(9, dts.getNom_imagen());
            pst.setBinaryStream(10, dts.getImagen());
            pst2.setString(1, dts.getCodigo_cliente());
            int n = pst.executeUpdate();

            if (n != 0) {

                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    int n3 = pst3.executeUpdate();
                    if (n3 != 0) {
                        return true;
                    } else {
                        return false;
                    }

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

    public boolean editar(vcliente dts) {
        sSQL = "update persona set nombre = ?, apellido = ?, tipo_documento = ?, numero_documento = ?,"
                + "direccion = ?, telefono = ?,  email = ?, fecha_nacimiento=?, nom_imagen=?, "
                + "imagen =? where idpersona = ?";

        sSQL2 = "update cliente set codigo_cliente = ?"
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
            pst.setString(9, dts.getNom_imagen());
            pst.setBinaryStream(10, dts.getImagen());
            pst.setInt(11, dts.getIdpersona());

            pst2.setString(1, dts.getCodigo_cliente());
            pst2.setInt(2, dts.getIdpersona());
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

    public boolean eliminar(vcliente dts) {
        sSQL = "delete from cliente where idpersona = ?";
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
}

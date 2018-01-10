
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Boris
 */
public class conexion {
    
    public String db="baseclinica";
    public String url="jdbc:mysql://192.168.0.200/" + db;
    /*public String user="root";
    public String pass="";*/
    
    public String user="usuarioclinica";
    public String pass="adminclinica";
    
     public conexion() {
    }
     
     public Connection conectar() {
        Connection link=null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link=DriverManager.getConnection(this.url,this.user,this.pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return link;
    }
}

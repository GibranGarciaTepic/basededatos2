
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gg1br
 */
public class BaseDatosEscuela {
    Connection conexion;
    Statement transaccion;
    ResultSet cursor;
    
    String cadenaConexion = "jdbc:mysql://bdrz5e4zqfwwsmuhgyom-mysql.services.clever-cloud.com:3306/bdrz5e4zqfwwsmuhgyom?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String usuario = "ussxjgocro9f0tsf";
    String pass = "xMqMTxruNSFNeCSCnkLX";
    
    public BaseDatosEscuela(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(cadenaConexion, usuario, pass);
            transaccion = conexion.createStatement();
        }catch(SQLException e){
            
        }catch(ClassNotFoundException e){
            
        }
    }
    
    
    public boolean insertar(Escuela p){
        String SQL_Insertar = "INSERT INTO `Escuela` (`NumeroControl`, `NombreAlumno`, `Carrera`, `FechaEx`, `Semestre`) VALUES (NULL, '%NUM%', '%NOMA%', '%CARR%', '%FEHCA%', '%SEM%');";
        SQL_Insertar = SQL_Insertar.replace("%NOM%", p.numcontrol);
        SQL_Insertar= SQL_Insertar.replace("%DOM%", p.nombrealumno);
        SQL_Insertar = SQL_Insertar.replace("%TEL%", p.carrera);
        SQL_Insertar = SQL_Insertar.replace("%TEL%", p.fechaexpedicion);
        SQL_Insertar = SQL_Insertar.replace("%TEL%", p.semestre);
        try{
            transaccion.execute(SQL_Insertar);
        }catch(SQLException e){
            return false;
        }
        return true;
    }
    
    public ArrayList<Escuela> mostrarTodos(){
        ArrayList<Escuela> datos = new ArrayList<Escuela>();
        String SQL_consulta = "SELECT * FROM `Escuela`";
        
        try {
            //RESULTSET = variable que maneja las tuplas resultado
            cursor = transaccion.executeQuery(SQL_consulta);
            
            if(cursor.next()){
                do{
                   Escuela p = new Escuela(
                           
                           cursor.getString(1),
                           cursor.getString(2),
                           cursor.getString(3),
                           cursor.getString(4),
                           cursor.getString(5)
                        
                   );
                   datos.add(p);
                
                }while(cursor.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatosEscuela.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
    public Escuela obtenerNoControl (String NoC){
        String SQL_consulta = "SELECT * FROM `Escuela` WHERE 'ID'="+NoC;
        
        try {
            //RESULTSET = variable que maneja las tuplas resultado
            cursor = transaccion.executeQuery(SQL_consulta);
            
            if(cursor.next()){
                   Escuela p = new Escuela(
                           
                           cursor.getString(1),
                           cursor.getString(2),
                           cursor.getString(3),
                           cursor.getString(4),
                           cursor.getString(5)
                   );
                   return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatosEscuela.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Escuela("", "","","","");
    }
    
    
    
    public boolean eliminar(String IDaEliminar){
        String SQL_eliminar = "DELETE FROM ´Persona´ WHERE ´ID´= "+IDaEliminar;
        
        try{
        transaccion.execute(SQL_eliminar);
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    
    public boolean actualizar(Escuela p){
 
        String SQL_actualizar = "UPDATE `Persona` SET =`NOMBRE`='%NOM%', `DOMICILIO`'%DOM%', `TELEFONO`='%TEL%' WHERE `ID`=";
        SQL_actualizar = SQL_actualizar.replace("%NOM%", p.numcontrol);
        SQL_actualizar = SQL_actualizar.replace("%DOM%", p.nombrealumno);
        SQL_actualizar = SQL_actualizar.replace("%TEL%", p.carrera);
        SQL_actualizar = SQL_actualizar.replace("%TEL%", p.fechaexpedicion);
        SQL_actualizar = SQL_actualizar.replace("%TEL%", p.semestre);
        try{
            transaccion.executeUpdate(SQL_actualizar);
        }catch(SQLException e){
            return false;
        }
        return true;
    }
        
    
}

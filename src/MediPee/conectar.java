/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MediPee;

import java.sql.*;
import java.sql.DriverManager; 
import java.util.logging.Level; 
import java.util.logging.Logger; 

/**
 *
 * @author Usuario
 */
public class conectar {
    Connection conect = null; 
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost/ph_encuestados", "root", "");            
        } catch (ClassNotFoundException | SQLException ex){
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conect; 
    }
}

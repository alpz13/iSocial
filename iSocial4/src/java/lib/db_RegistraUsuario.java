/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lib;

import Modelo.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author alex
 */
public class db_RegistraUsuario {
    DB_DataBase db = new DB_DataBase();
    
    public boolean insertaUsuario(m_RegistraUsuario mregistra)
    {
        try
        {
            if(db.connect())
            {
                String query = "insert into usuarios(usuario,contrasena,correo) values(?,?,?)";
                PreparedStatement p = db.connection.prepareStatement(query);
                p.setString(1, mregistra.getUsuario());
                p.setString(2, mregistra.getContrasena());
                p.setString(3, mregistra.getCorreo());
                p.executeUpdate();     
                p.close();
                db.close();
                
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lib;
import Modelo.m_Usuario;
import java.sql.*;
import java.util.*;
import lib.*;

/**
 *
 * @author alex
 */
public class db_Usuario {
    
    DB_DataBase db = new DB_DataBase();  
    
    public Collection getUsuario()
    {
        
        Collection c = new ArrayList();
        try
        {
            if(db.connect())
            {
                String query = "select * from usuarios";                
                PreparedStatement p = db.connection.prepareStatement(query);          
                ResultSet resultado = p.executeQuery();         
                while(resultado.next())
                {
                    System.out.println("resultado.next\n");
                    m_Usuario usuario = new m_Usuario(resultado.getInt(1),resultado.getString(2),resultado.getString(3),resultado.getString(4));
                    c.add(usuario);
                }
                resultado.close();
                p.close();
                db.close();
                return c;
            }
            return c;
        }
        catch (Exception e)
        {
            System.out.println(e);            
            return c;
        }
    }

    
     public int getUsuarioId(String usuario)
    {
        try
        {  
            m_Usuario user = null;
            if(db.connect())
            {
                String query = "select u.id_usuario from usuarios u where u.usuario = ?";
                PreparedStatement p = db.connection.prepareStatement(query);
                p.setString(1, usuario);
                ResultSet res = p.executeQuery();
                if(res.next())
                {
                    user = new m_Usuario(res.getInt(1),"","","");
                }
                res.close();
                p.close();
                db.close();
                return user.getIdUsuario();
            }
            return user.getIdUsuario();
        }
        catch(Exception e)
        {
            return 0;
        }
    }


    public boolean validate(m_Usuario usuario)
    {
        try
        {
            if(db.connect())
            {
                String query = "select * from usuarios where usuario=? and contrasena=?";
                PreparedStatement p = db.connection.prepareStatement(query);
                p.setString(1, usuario.getUsuario());
                p.setString(2, usuario.getContrasena());
                ResultSet res = p.executeQuery();
                m_Usuario user = null;
                if(res.next())
                {
                    user = new m_Usuario(res.getInt(1),res.getString(2),res.getString(3),res.getString(4));
                }
                res.close();
                p.close();
                db.close();
                return true;
            }
            return true;
        }catch(Exception e)
        {
            return false;
        }
    }
    
   
    
    
    
    
}

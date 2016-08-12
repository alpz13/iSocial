/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lib;
import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author alex
 */
public class db_CargaCalificar {
    
    DB_DataBase db = new DB_DataBase();
    
    public m_CaliProm getCalificacion(int idLugar)
    {
        m_CaliProm prom = new m_CaliProm();
        int aux=0;
        int x=0;
        try
        {
            if(db.connect())
            {
                String query = "select c.calificacion from calificar c where c.id_lugar=?";
                String query2 = "select count(*) from calificar c where c.id_lugar=?";
                PreparedStatement p = db.connection.prepareStatement(query);
                PreparedStatement p2 = db.connection.prepareStatement(query2);
                p2.setInt(1, idLugar);
                p.setInt(1, idLugar);
                ResultSet res2 = p2.executeQuery();
                ResultSet res = p.executeQuery();
                if(res2.next())
                {
                    x = res2.getInt(1);
                }
                while(res.next())
                {
                    aux = aux + res.getInt(1);
                }
                
                res.close();
                p.close();
                db.close();
                prom.setCalificacion(aux);
                prom.setContador(x);
               
                
                return prom;
            }
            return null;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Collection getComentarios(int idLugar)
    {
        Collection c = new ArrayList();
        try
        {
            if(db.connect())
            {
                String query = "select u.usuario, c.comentario, c.calificacion from usuarios u, calificar c, lugar l where u.id_usuario = c.id_usuario and c.id_lugar = l.id_lugar and l.id_lugar =?";
                PreparedStatement p = db.connection.prepareStatement(query);
                p.setInt(1, idLugar);
                ResultSet res = p.executeQuery();
                while(res.next())
                {
                    m_Comentarios allcomentarios = new m_Comentarios(res.getString(1),res.getString(2),res.getInt(3));
                    c.add(allcomentarios);
                }
                res.close();
                p.close();
                db.close();
                return c;
            }
            return c;
        }catch(Exception e)
        {
            return null;
        }
    }
    
    public m_Lugar getLugar(int id)
    {
        try
        {
            if(db.connect())
            {
                String query = "SELECT id_lugar, nombre, direccion, descripcion, id_tipo, url_imagen FROM `lugar` WHERE id_lugar = ?";
                PreparedStatement p = db.connection.prepareStatement(query);
                p.setInt(1,id);
                ResultSet res = p.executeQuery();
                m_Lugar lugar = null;
                if(res.next())
                {
                    lugar = new m_Lugar(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getString(6));
                }
                res.close();
                p.close();
                db.close();
                return lugar;          
            }
            else
            {
                return null;
            }
        }catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lib;

import Modelo.m_Lugar;
import Modelo.m_Tipo;
import Modelo.m_Top5;
import Modelo.m_Top5filtro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author alex
 */
public class db_Lugar {
    DB_DataBase db = new DB_DataBase();
    public Collection getLugar(String query) {
        Collection c = new ArrayList();
        try{
            if (db.connect()) {
                String q = "select * from lugar where nombre like '%"+query+"%';";
                PreparedStatement p = db.connection.prepareStatement(q);
                ResultSet r = p.executeQuery();
                
                if(r.next()) {
                    r.beforeFirst();
                    m_Lugar lugar = null;
                    while(r.next()) {
                        lugar = new m_Lugar(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getInt(5), r.getString(6));
                        c.add(lugar);
                    }
                    r.close();
                    p.close();
                    return c;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception e) { 
            System.out.println(e);
            return null;
        }
    }
    
    public Collection getTipos() {
        Collection c = new ArrayList();
        try {
            if(db.connect()) {
                String q = "select * from tipo;";
                PreparedStatement p = db.connection.prepareStatement(q);
                ResultSet r = p.executeQuery();
                m_Tipo tipo = null;
                while(r.next()) {
                    tipo = new m_Tipo(r.getInt(1), r.getString(2));
                    c.add(tipo);
                }
                r.close();
                p.close();
                return c;
                
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public boolean insertarLugares(m_Lugar lugar) {
        try {
	      db.connect();
              String q = "insert into lugar (nombre, direccion, descripcion, id_tipo, url_imagen) values(";
              q += "'"+lugar.getNombre()+"',";
              q += "'"+lugar.getDireccion()+"',";
              q += "'"+lugar.getDescripcion()+"',";
              q += "'"+lugar.getTipo()+"',";
              q += "'"+lugar.getUrl()+"');";
              PreparedStatement i = db.connection.prepareStatement(q);
	      i.executeUpdate();
	      i.close(); 
              db.close();
              return true;
        } catch (Exception e) { 
            System.out.println(e);
            return false;
        }
    }
    
    public Collection getTop5()
    {
        Collection c = new ArrayList();
        try
        {
            if(db.connect())
            {
                String query = "SELECT DISTINCT l.id_lugar, l.nombre, l.direccion, c.calificacion, l.descripcion FROM lugar l, calificar c WHERE c.id_lugar = l.id_lugar AND c.calificacion >=8 GROUP BY l.id_lugar ORDER BY c.calificacion DESC LIMIT 5";
                PreparedStatement p = db.connection.prepareStatement(query);
                ResultSet res = p.executeQuery();
                m_Top5 top5 = null;
                while(res.next())
                {
                    top5 = new m_Top5(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getString(5));
                    c.add(top5);   
                }
                res.close();
                p.close();
                db.close();
                return c;
            }
            else
            {
                return null;
            }
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public Collection getTop5Tipos(int tipo)
    {
        Collection c = new ArrayList();
        try
        {
            if(db.connect())
            {
                String query = "SELECT DISTINCT l.id_lugar, l.nombre, l.direccion, c.calificacion, l.descripcion FROM lugar l, calificar c, tipo t WHERE c.id_lugar = l.id_lugar AND l.id_tipo = t.id_tipo AND c.calificacion >=8 AND t.id_tipo = ? GROUP BY l.id_lugar ORDER BY c.calificacion DESC LIMIT 5";
                PreparedStatement p = db.connection.prepareStatement(query);
                p.setInt(1, tipo);
                ResultSet res = p.executeQuery();
                m_Top5filtro top5filtro = null;
                while(res.next())
                {
                    top5filtro = new m_Top5filtro(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getString(5));
                    c.add(top5filtro);
                }
                return c;
            }
            return null;
        }
        catch(Exception e)
        {
            return null;
        }
    
    }
    
    public Collection getTop5TiposComida()
    {
        Collection c = new ArrayList();
        try
        {
            if(db.connect())
            {
                String query = "SELECT DISTINCT l.id_lugar, l.nombre, l.direccion, c.calificacion, l.descripcion FROM lugar l, calificar c, tipo t WHERE c.id_lugar = l.id_lugar AND l.id_tipo = t.id_tipo AND c.calificacion >=8 AND t.id_tipo = 1 GROUP BY l.id_lugar ORDER BY c.calificacion DESC LIMIT 5";
                PreparedStatement p = db.connection.prepareStatement(query);
                ResultSet res = p.executeQuery();
                m_Top5filtro top5filtro = null;
                while(res.next())
                {
                    System.out.println("top5 comida");
                    top5filtro = new m_Top5filtro(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getString(5));
                    System.out.println(res.getInt(1));
                    System.out.println(res.getString(2));
                    System.out.println(res.getString(3));
                    System.out.println(res.getInt(4));
                    System.out.println(res.getString(5));
                    c.add(top5filtro);
                }
                return c;
            }
            return null;
        }
        catch(Exception e)
        {
            return null;
        }
    
    }
    
    public Collection getTop5TiposBebida()
    {
        Collection c = new ArrayList();
        try
        {
            if(db.connect())
            {
                String query = "SELECT DISTINCT l.id_lugar, l.nombre, l.direccion, c.calificacion, l.descripcion FROM lugar l, calificar c, tipo t WHERE c.id_lugar = l.id_lugar AND l.id_tipo = t.id_tipo AND c.calificacion >=8 AND t.id_tipo = 2 GROUP BY l.id_lugar ORDER BY c.calificacion DESC LIMIT 5";
                PreparedStatement p = db.connection.prepareStatement(query);
                ResultSet res = p.executeQuery();
                m_Top5filtro top5filtro = null;
                while(res.next())
                {
                    System.out.println("top5 bebida");
                    top5filtro = new m_Top5filtro(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getString(5));
                    c.add(top5filtro);
                }
                return c;
            }
            return null;
        }
        catch(Exception e)
        {
            return null;
        }
    
    }
    
    public Collection getTop5TiposEntretenimiento()
    {
        Collection c = new ArrayList();
        try
        {
            if(db.connect())
            {
                String query = "SELECT DISTINCT l.id_lugar, l.nombre, l.direccion, c.calificacion, l.descripcion FROM lugar l, calificar c, tipo t WHERE c.id_lugar = l.id_lugar AND l.id_tipo = t.id_tipo AND c.calificacion >=8 AND t.id_tipo = 3 GROUP BY l.id_lugar ORDER BY c.calificacion DESC LIMIT 5";
                PreparedStatement p = db.connection.prepareStatement(query);
                ResultSet res = p.executeQuery();
                m_Top5filtro top5filtro = null;
                while(res.next())
                {
                    System.out.println("top5 entretenimiento");
                    top5filtro = new m_Top5filtro(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getString(5));
                    System.out.println("id_lugar:" + top5filtro.getId_lugar());
                    System.out.println(top5filtro.getNombre());
                    c.add(top5filtro);
                }
                return c;
            }
            return null;
        }
        catch(Exception e)
        {
            return null;
        }
    
    }
}

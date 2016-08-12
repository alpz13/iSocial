package Controlador;

import Modelo.m_Lugar;
import Modelo.m_Tipo;
import java.sql.*;
import java.util.*;

public class c_Lugares {
    Connection connection=null;
	
    public c_Lugares() {
        connection=null;
    }

    public boolean connect(){
	try {
            String urlBD = "jdbc:mysql://localhost:3306/isocial?user=root&zeroDateTimeBehavior=convertToNull"; 
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(urlBD);
        } catch (Exception e) { 
	    System.out.println(e);
            return false;
	}
        return true;
    }
    
    private boolean close() {
        try {
            connection.close(); 
            return true;
        } catch (Exception e) { 
	    System.out.println(e);
            return false;
	}
    }
    
    public Collection getLugar(String query) {
        Collection c = new ArrayList();
        try{
            if (connect()) {
                String q = "select * from lugar where nombre like '%"+query+"%';";
                PreparedStatement p = connection.prepareStatement(q);
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
    
    public m_Lugar getLugarUnico(String query) {
        try{
            if (connect()) {
                String q = "select * from lugar where nombre = ?";
                PreparedStatement p = connection.prepareStatement(q);
                p.setString(1, query);
                ResultSet r = p.executeQuery();
                
                if(r.next()) {
                    r.beforeFirst();
                    m_Lugar lugar = null;
                    while(r.next()) {
                        lugar = new m_Lugar(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getInt(5), r.getString(6));
                    }
                    r.close();
                    p.close();
                    return lugar;
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
    
    public m_Lugar getLugarUnicoId(int query) {
        try{
            if (connect()) {
                String q = "select * from lugar where id_lugar = ?";
                PreparedStatement p = connection.prepareStatement(q);
                p.setInt(1, query);
                ResultSet r = p.executeQuery();
                
                if(r.next()) {
                    r.beforeFirst();
                    m_Lugar lugar = null;
                    while(r.next()) {
                        lugar = new m_Lugar(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getInt(5), r.getString(6));
                    }
                    r.close();
                    p.close();
                    return lugar;
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
            if(connect()) {
                String q = "select * from tipo;";
                PreparedStatement p = connection.prepareStatement(q);
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
	      connect();
              String q = "insert into lugar (nombre, direccion, descripcion, id_tipo, url_imagen) values(";
              q += "'"+lugar.getNombre()+"',";
              q += "'"+lugar.getDireccion()+"',";
              q += "'"+lugar.getDescripcion()+"',";
              q += "'"+lugar.getTipo()+"',";
              q += "'"+lugar.getUrl()+"');";
              PreparedStatement i = connection.prepareStatement(q);
	      i.executeUpdate();
	      i.close(); 
              close();
              return true;
        } catch (Exception e) { 
            System.out.println(e);
            return false;
        }
    }
}

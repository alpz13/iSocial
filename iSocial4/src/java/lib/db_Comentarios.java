/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lib;

import Modelo.m_InsertaComentarios;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author alex
 */
public class db_Comentarios {
    
    DB_DataBase db = new DB_DataBase();
    
    public boolean insertaComentarios(m_InsertaComentarios comentarios)
    {
         String query = "insert into calificar (id_usuario, id_lugar,calificacion,comentario) values(";
            query += "'" + comentarios.getId_usuario()+"',";
            query += "'" + comentarios.getId_lugar()+"',";
            query += "'" + comentarios.getCalificacion()+"',";
            query += "'" + comentarios.getComentario()+"')";
        try{  
            if(db.connect())
            {
                db.connect();
                PreparedStatement p = db.connection.prepareStatement(query);
                p.executeUpdate();
                p.close();
                db.close();            
                return true;
            }
            return true;
        }
        catch(SQLException e)
        {            
            System.out.println(e.getMessage());
                    
            return false;
        }
    }
    
}

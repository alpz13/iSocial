/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author alex
 */
public class m_InsertaComentarios {
    int id_usuario,id_lugar,calificacion;
    String comentario;
    
    public m_InsertaComentarios()
    {
        
    }
    
    public m_InsertaComentarios(int id_usuario,int id_lugar,int calificacion,String comentario)
    {
        this.id_usuario = id_usuario;
        this.id_lugar = id_lugar;
        this.calificacion = calificacion;
        this.comentario = comentario;
             
    }

    public int getId_usuario() 
    {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario)
    {
        this.id_usuario = id_usuario;
    }

    public int getId_lugar() 
    {
        return id_lugar;
    }

    public void setId_lugar(int id_lugar) 
    {
        this.id_lugar = id_lugar;
    }

    public int getCalificacion() 
    {
        return calificacion;
    }

    public void setCalificacion(int calificacion) 
    {
        this.calificacion = calificacion;
    }

    public String getComentario() 
    {
        return comentario;
    }

    public void setComentario(String comentario) 
    {
        this.comentario = comentario;
    }
    
    
    
}

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
public class m_Comentarios {
    int calificacion;
    String usuario,comentario;
    
    public m_Comentarios()
    {
    
    }
    
    public m_Comentarios(String usuario,String comentario,int calificacion)
    {
        this.usuario = usuario;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public int getCalificacion() 
    {
        return calificacion;
    }

    public void setCalificacion(int calificacion) 
    {
        this.calificacion = calificacion;
    }

    public String getUsuario() 
    {
        return usuario;
    }

    public void setUsuario(String usuario) 
    {
        this.usuario = usuario;
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

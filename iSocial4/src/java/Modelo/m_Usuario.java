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
public class m_Usuario {
    private int idusuario;
    private String usuario;
    private String contrasena;
    private String correo;
    
     public m_Usuario()
    {
        
    }
    
    public m_Usuario(int idusuario, String usuario, String contrasena, String correo)
    {
        this.idusuario = idusuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.correo = correo;
    }
    
    public int getIdUsuario()
    {
        return idusuario;
    }
    
    public void setIdUsuario(int idusuario)
    {
        this.idusuario = idusuario;
    }
    
    public String getUsuario()
    {
        return usuario;
    }
    
    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }
    
    public String getContrasena()
    {
        return contrasena;
    }
    
    public void setContrasena(String contrasena)
    {
        this.contrasena = contrasena;
    }
    
    public String getCorreo()
    {
        return correo;
    }
    
    public void setCorreo(String correo)
    {
        this.correo = correo;
    }
    
    
}

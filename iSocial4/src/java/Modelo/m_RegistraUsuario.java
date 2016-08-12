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
public class m_RegistraUsuario {
    String usuario,contrasena,correo;
    
    public m_RegistraUsuario()
    {
    
    }
    
    public m_RegistraUsuario(String usuario, String contrasena, String correo)
    {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.correo = correo;
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

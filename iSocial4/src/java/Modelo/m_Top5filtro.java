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
public class m_Top5filtro {
    int id_lugar,calificacion;
    String nombre,direccion,descripcion;
    
    public m_Top5filtro()
    {
        
    }
    
    public m_Top5filtro(int id_lugar, String nombre, String direccion, int calificacion, String descripcion)
    {
        this.id_lugar = id_lugar;
        this.nombre = nombre;
        this.direccion = direccion;
        this.calificacion = calificacion;
        this.descripcion = descripcion;
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

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getDireccion() 
    {
        return direccion;
    }

    public void setDireccion(String direccion) 
    {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}

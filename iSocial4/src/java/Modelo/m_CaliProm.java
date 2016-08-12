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
public class m_CaliProm {
    private int calificacion,contador;
    
    public m_CaliProm()
    {
    
    }
    
    public m_CaliProm(int calificacion,int contador)
    {
        this.calificacion = calificacion;
        this.contador = contador;
    }

    public int getCalificacion() 
    {
        return calificacion;
    }

    public void setCalificacion(int calificacion) 
    {
        this.calificacion = calificacion;
    }
    
    public int getContador()
    {
        return contador;
    }
    public void setContador(int contador)
    {
        this.contador = contador;
    }
    
    
}

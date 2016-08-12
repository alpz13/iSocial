package Modelo;

public class m_Lugar {
    private int id, tipo;
    private String nombre, direccion, descripcion, url;
    
    public m_Lugar() {
        
    }
    
    public m_Lugar(int id, String nombre, String direccion, String descripcion, int tipo, String url){
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    } 
}

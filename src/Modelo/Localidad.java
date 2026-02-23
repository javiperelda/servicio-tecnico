
package Modelo;
 
public class Localidad {
    private int idLoc;
    private String nombre;
    public Provincia provincia;

    public Localidad(int idProv, String nombre) {
        this.idLoc = idProv;
        this.nombre = nombre;
    }

    public int getIdLoc() {
        return idLoc;
    }

    public void setIdLoc(int idLoc) {
        this.idLoc = idLoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}

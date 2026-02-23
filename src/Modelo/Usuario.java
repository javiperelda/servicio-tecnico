
package Modelo;
 
public class Usuario {
    private int idU;
    private String usuario;
    private String pass;
    private Rol rolU;
    private String nombre;
    private String apellido;
    private String numDocumento;
    
    public Usuario(int idU, String usuario, String pass, Rol rolU,String nombre, String apellido, String numDocumento) {
        this.idU = idU;
        this.usuario = usuario;
        this.pass = pass;
        this.rolU = rolU;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numDocumento = numDocumento;
    }
    public Rol getRolU() {
        return rolU;
    }

    public void setRolU(Rol rolU) {
        this.rolU = rolU;
    }
 
    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }
    
    
}

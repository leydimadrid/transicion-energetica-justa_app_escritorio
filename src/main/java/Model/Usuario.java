package Model;

public class Usuario {

    private long id;
    private String nombre;
    private String email;
    private String contrasenia;
    private Rol rol;

    public Usuario(int id, String nombre, String email, String contrasenia, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.email = email;
        this.rol = rol;

    }

    public Usuario(int id, String nombre, String email, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}

package Model;

public class Usuario {
<<<<<<< HEAD:src/Model/Usuario.java
=======

   
>>>>>>> Dev:src/main/java/Model/Usuario.java
    private long id;
    private String nombre;
    private String email;
    private String contrasenia;
<<<<<<< HEAD:src/Model/Usuario.java
    private String perfil;
=======
    private String rol;
    
     public Usuario(int id, String nombre, String email, String rol) {
         this.id = id;
         this.nombre = nombre;
         this.contrasenia = contrasenia;
         this.email = email; 
         this.rol = rol ;
        
    }
>>>>>>> Dev:src/main/java/Model/Usuario.java

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

<<<<<<< HEAD:src/Model/Usuario.java
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
=======
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
>>>>>>> Dev:src/main/java/Model/Usuario.java
    }
}

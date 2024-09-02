package co.edu.uniquindio.poo;

public class Contacto {
    private String nombre;
    private String alias;
    private String direccion;
    private String telefono;
    private String email;

    public Contacto(String nombre, String alias, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.alias = alias;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        assert nombre != null && !nombre.isBlank() : "El nombre no puede estar vacio ni en blanco";
        assert alias != null && !alias.isBlank() : "El alias no puede estar vacio ni en blanco";
        assert direccion != null && !direccion.isBlank() : "La direccion no puede estar vacio ni en blanco";
        assert telefono != null && !telefono.isBlank() : "El telefono no puede estar vacio ni en blanco";
        assert email != null && !email.isBlank() : "El email no puede estar vacio ni en blanco";
        assert email.contains("@") : "El email debe contener el caratcer @ ";
    }
    // gets y sets 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return nombre + " (" + alias + "), Tel: " + telefono + ", Email: " + email;
    }
}

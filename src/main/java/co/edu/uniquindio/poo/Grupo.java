package co.edu.uniquindio.poo;

import java.util.LinkedList;
import java.util.List;

public class Grupo {
    public enum Categoria {
        OFICINA,
        FIESTA,
        AMIGOS,
        FAMILIA
    }

    private String nombre;
    private Categoria categoria;
    private List<Contacto> contactos;

    public Grupo(String nombre, Categoria categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.contactos = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    @Override
    public String toString() {
        return nombre + " (" + categoria + "): " + contactos +": "+ contactos.size() +" contactos";
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public boolean eliminarContacto(Contacto contacto) {
        if (contactos.contains(contacto)) {
            if (contactos.size() <= 5) {
                mostrarMensaje("No se puede eliminar el contacto. El grupo debe tener al menos 5 contactos.");
                return false;
            }
            contactos.remove(contacto);
            mostrarMensaje("Contacto eliminado: " + contacto.getNombre());
            return true;
        } else {
            mostrarMensaje("El contacto no se encontró en el grupo.");
            return false;
        }
    }

    public boolean addContacto(Contacto contacto) {
        for (Contacto c : contactos) {
            if (c.getNombre().equals(contacto.getNombre()) && c.getTelefono().equals(contacto.getTelefono())) {
                mostrarMensaje("El contacto: " + contacto.getNombre() +" ya está en el grupo: "+ getNombre());
                return false;
            }
        }
        contactos.add(contacto);
        mostrarMensaje("Contacto agregado: " + contacto.getNombre());
        return true;
    }

    /**public void addContacto(Contacto contacto) {
        if (verificarContactoExistente(contacto.getNombre(), contacto.getTelefono())) {
            contactos.add(contacto);
        } else {
            System.out.println("El contacto ya existe en el grupo");
        }
    }*/
}

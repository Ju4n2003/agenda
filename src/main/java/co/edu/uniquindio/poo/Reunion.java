package co.edu.uniquindio.poo;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Reunion {
    private String descripcion;
    private Date fecha;
    private Time hora;
    private List<Contacto> asistentes;

    public Reunion(String descripcion, Date date, Time time) {
        this.descripcion = descripcion;
        this.fecha = date;
        this.hora = time;
        this.asistentes = new LinkedList<>();
    }// Gets y sets

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public List<Contacto> getAsistentes() {
        return asistentes;
    }
    @Override
    public String toString() {
        return "Reunión: " + descripcion + " en " + fecha + " a las " + hora + ", Asistentes: " + asistentes.size();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void setAsistentes(List<Contacto> asistentes) {
        this.asistentes = asistentes;
    }

    public boolean addAsistente(Contacto contacto) {
        for (Contacto c : asistentes) {
            if (c.getNombre().equals(contacto.getNombre()) && c.getTelefono().equals(contacto.getTelefono())) {
                mostrarMensaje("El contacto ya está en la lista de asistentes.");
                return false;
            }
        }
        asistentes.add(contacto);
        mostrarMensaje("Asistente agregado: " + contacto.getNombre());
        return true;
    }

    public void removerAsistente(Contacto contacto) {
        if (asistentes.remove(contacto)) {
            mostrarMensaje("Asistente eliminado: " + contacto.getNombre());
        } else {
            mostrarMensaje("El asistente no se encontró en la reunión.");
        }
    }
}

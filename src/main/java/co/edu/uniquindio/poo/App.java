package co.edu.uniquindio.poo;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import co.edu.uniquindio.poo.Grupo.Categoria;

public class App {
    public static void main(String[] args) {
        
        // Crear contactos
        Contacto contacto1 = new Contacto("Juan Perez", "Juan", "Calle 123", "123456789", "juan@uq.com");
        Contacto contacto2 = new Contacto("Maria Lopez", "Maria", "Calle 456", "98765432", "maria@gmail.com");
        Contacto contacto3 = new Contacto("Carlos Sanchez", "Carlos", "Avenida 789", "12345678", "carlos@outlook.com");
        Contacto contacto4 = new Contacto("Juan Perez", "Pedro", "Calle 789", "123456789", "pedro@hotmail.com");

        // Crear grupo
        Grupo grupoAmigos = new Grupo("Amigos", Grupo.Categoria.AMIGOS);
        grupoAmigos.addContacto(contacto1);
        grupoAmigos.addContacto(contacto2);
        grupoAmigos.addContacto(contacto3);
        grupoAmigos.addContacto(contacto4);
        // Crear grupo2
        Grupo grupoProyecto = new Grupo("Oficina", Grupo.Categoria.OFICINA);
        grupoProyecto.addContacto(contacto1);
        grupoProyecto.addContacto(contacto3);
        grupoProyecto.addContacto(contacto4);

        // Intentar agregar un contacto duplicado
        grupoAmigos.addContacto(contacto1);
        // Intentar eliminar un contato
        grupoAmigos.eliminarContacto(contacto1);
        // Mostrar información del grupo
        System.out.println(grupoAmigos);
        System.out.println(grupoProyecto);

        // Crear reunión
        Reunion reunion = new Reunion("Reunión de Proyecto", new Date(), new Time(10, 0, 0));
        reunion.addAsistente(contacto1);
        reunion.addAsistente(contacto3);

        // Intentar agregar un asistente duplicado
        reunion.addAsistente(contacto1);

        // Mostrar información de la reunión
        System.out.println(reunion);
    }
}

/**private static LinkedList<Contacto> contactos = new LinkedList<>();
    private static LinkedList<Grupo> grupos = new LinkedList<>();
    private static LinkedList<Reunion> reuniones = new LinkedList<>();

    public static void main(String[] args) {
        while (true) {
            String[] opciones = {"Crear Contacto", "Eliminar Contacto", "Crear Grupo", "Crear Reunión", "Salir"};
            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Agenda de Contactos",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (seleccion) {
                case 0 -> crearContacto();
                case 1 -> eliminarContacto();
                case 2 -> crearGrupo();
                case 3 -> crearReunion();
                case 4 -> System.exit(0);
            }
        }
    }

    private static void crearContacto() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del contacto:");
        String alias = JOptionPane.showInputDialog("Ingrese el alias del contacto:");
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección del contacto:");
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del contacto:");
        String email = JOptionPane.showInputDialog("Ingrese el email del contacto:");

        if (nombre != null && telefono != null) {
            Contacto nuevoContacto = new Contacto(nombre, alias, direccion, telefono, email);
            contactos.add(nuevoContacto);
            JOptionPane.showMessageDialog(null, "Contacto creado: " + nuevoContacto);
        } else {
            JOptionPane.showMessageDialog(null, "El nombre y el teléfono son obligatorios.");
        }
    }

    private static void eliminarContacto() {
        if (contactos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay contactos para eliminar.");
            return;
        }

        Contacto contacto = seleccionarContacto();
        if (contacto != null) {
            contactos.remove(contacto);
            JOptionPane.showMessageDialog(null, "Contacto eliminado: " + contacto.getNombre());

            // También eliminar el contacto de los grupos y reuniones en los que esté presente
            for (Grupo grupo : grupos) {
                grupo.eliminarContacto(contacto);
            }
            for (Reunion reunion : reuniones) {
                reunion.removerAsistente(contacto);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún contacto.");
        }
    }

    private static void crearGrupo() {
        if (contactos.size() < 5) {
            JOptionPane.showMessageDialog(null, "Debe haber al menos 5 contactos para crear un grupo.");
            return;
        }

        String nombreGrupo = JOptionPane.showInputDialog("Ingrese el nombre del grupo:");

        String[] categorias = {"OFICINA", "FIESTA", "AMIGOS", "FAMILIA"};
        String categoriaSeleccionada = (String) JOptionPane.showInputDialog(null,
                "Seleccione la categoría del grupo:", "Categoría", JOptionPane.QUESTION_MESSAGE,
                null, categorias, categorias[0]);

        Grupo.Categoria categoria = Grupo.Categoria.valueOf(categoriaSeleccionada);

        Grupo nuevoGrupo = new Grupo(nombreGrupo, categoria);

        while (nuevoGrupo.getContactos().size() < 5) {
            Contacto contacto = seleccionarContacto();
            if (contacto != null) {
                nuevoGrupo.addContacto(contacto);
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar al menos 5 contactos para el grupo.");
                return;
            }
        }

        grupos.add(nuevoGrupo);
        JOptionPane.showMessageDialog(null, "Grupo creado: " + nuevoGrupo);
    }

    private static void crearReunion() {
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción de la reunión:");
        String fechaInput = JOptionPane.showInputDialog("Ingrese la fecha de la reunión (YYYY-MM-DD):");
        String horaInput = JOptionPane.showInputDialog("Ingrese la hora de la reunión (HH:MM):");

        LocalDate fecha = LocalDate.parse(fechaInput);
        LocalTime hora = LocalTime.parse(horaInput);

        Reunion nuevaReunion = new Reunion(descripcion, fecha, hora);

        while (true) {
            Contacto contacto = seleccionarContacto();
            if (contacto != null) {
                nuevaReunion.addAsistente(contacto);
            } else {
                break;
            }
        }

        reuniones.add(nuevaReunion);
        JOptionPane.showMessageDialog(null, "Reunión creada: " + nuevaReunion);
    }

    private static Contacto seleccionarContacto() {
        if (contactos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay contactos disponibles.");
            return null;
        }

        String[] nombresContactos = contactos.stream().map(Contacto::getNombre).toArray(String[]::new);
        String nombreSeleccionado = (String) JOptionPane.showInputDialog(null,
                "Seleccione un contacto:", "Contactos", JOptionPane.QUESTION_MESSAGE,
                null, nombresContactos, nombresContactos[0]);

        return contactos.stream().filter(c -> c.getNombre().equals(nombreSeleccionado)).findFirst().orElse(null);
    }
}*/
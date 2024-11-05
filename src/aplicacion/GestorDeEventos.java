package aplicacion;

import modelo.*;
import pantallas.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorDeEventos {
    private final Teclado teclado;
    private List<Evento> eventos;
    private PantallaCrearEvento pantallaCrearEvento;
    private PantallaEditarUbicacion pantallaEditarUbicacion;
    private PantallaAdministrarIntegrantes pantallaAdministrarIntegrantes;
    private PantallaAdministrarRecursos pantallaAdministrarRecursos;
    private PantallaMostrarFeedback pantallaMostrarFeedback;

    public GestorDeEventos() {
        this.teclado = new Teclado();
        this.eventos = new ArrayList<>();
        this.pantallaCrearEvento = new PantallaCrearEvento(this.teclado);
        this.pantallaEditarUbicacion = new PantallaEditarUbicacion(this.teclado);
        this.pantallaAdministrarIntegrantes = new PantallaAdministrarIntegrantes(this.teclado);
        this.pantallaAdministrarRecursos = new PantallaAdministrarRecursos(new Scanner(System.in));
        this.pantallaMostrarFeedback = new PantallaMostrarFeedback(this.teclado);

    }

    public static void main(String[] args) {
        GestorDeEventos gde = new GestorDeEventos();
        gde.comenzarAplicacion();
    }

    public void comenzarAplicacion() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Bienevenido al gestor de eventos");
        char opcion = 'z';
        while (opcion != '0') {
            mostrarEventos();
            var menu = """
                    a - Crear Evento
                    b - Elegir y administrar evento
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.next().charAt(0);
            teclado.nextLine();

            switch (opcion) {
                case 'a':
                    Evento evento = this.pantallaCrearEvento.crear();
                    this.eventos.add(evento);
                    break;
                case 'b':
                    editarEvento(teclado);
                    break;
                case '0':
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        }

    }

    private void editarEvento(Scanner teclado) {
        System.out.println("Ingresa el numero de evento que quieres editar:");
        int numeracion = teclado.nextInt();
        if (numeracion != 0 && numeracion <= eventos.size()) {
            Evento eventoAEditar = eventos.get(numeracion - 1);

            int opcion = -1;
            while (opcion != 0) {
                System.out.println("Nombre: " + eventoAEditar.getNombre());
                System.out.println("Capacidad maxima: " + eventoAEditar.getCapacidadMaxima());
                System.out.println("Fecha:  " + eventoAEditar.getFecha());
                System.out.println(eventoAEditar.obtenerDetalleUbicacion());
                System.out.println(); //espacio entre el listado y el menu
                var menu = """
                        1 - Editar Nombre
                        2 - Editar fecha
                        3 - Editar capacidad
                        4 - Editar Ubicación
                        5 - Editar Descripcion
                        6 - Administrar Integrantes
                        7 - Administrar Recursos
                        8 - Ver feedbacks del evento
                        0 - Volver al menu anterior
                        """;
                System.out.println(menu);
                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {
                    case 1:

                        editarNombre(teclado, eventoAEditar);
                        break;
                    case 2:

                        editarFecha(teclado, eventoAEditar);
                        break;
                    case 3:

                        editarCapacidad(teclado, eventoAEditar);
                        break;
                    case 4:
                        this.pantallaEditarUbicacion.editarUbicacion(eventoAEditar);
                        break;
                    case 5:
                        editarDescripcion(teclado, eventoAEditar);
                        break;
                    case 6:
                        this.pantallaAdministrarIntegrantes.iniciar(eventoAEditar);
                        break;
                    case 7:
                        this.pantallaAdministrarRecursos.iniciar(eventoAEditar);
                        break;
                    case 8:
                        this.pantallaMostrarFeedback.mostrarFeedback(eventoAEditar);
                        break;
                    case 0:
                        System.out.println("Volviendo al menu principal");
                    default:
                        System.out.println("Opción inválida");

                }
            }
        }
    }

    private void editarDescripcion(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa la nueva descripción");
        String descripcion = teclado.nextLine();
        eventoAEditar.setDescripcion(descripcion);
    }

    private void editarNombre(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa el nuevo nombre");
        String nombre = this.teclado.leerLinea();
        eventoAEditar.setNombre(nombre);
    }

    private void editarFecha(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa la nueva fecha");
        String fecha = this.teclado.leerTexto();
        eventoAEditar.setFecha(LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    private void editarCapacidad(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa la nueva capacidad maxima");
        int capacidadMaxima = this.teclado.leerNumero();
        eventoAEditar.setCapacidadMaxima(capacidadMaxima);
    }


    private void mostrarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos disponibles");
        } else {
            mostrarEventosPasados();
            mostrarEventosEnCurso();

        }

        System.out.println();
    }

    private void mostrarEventosPasados() {
        List<Evento> eventosPasados = eventos.stream().filter(Evento::yaSucedio).toList();

        int numeracion = 1;
        System.out.println("Eventos Pasados: ");

        for (Evento ev : eventosPasados) {
            System.out.println(numeracion + ".  " + ev.getNombre() + " (" + ev.getFecha() + ")");
            numeracion += 1;
        }
    }

    private void mostrarEventosEnCurso() {
        List<Evento> eventosEnCurso = eventos.stream().filter(Evento::estanEnCurso).toList();

        int numeracion = 1;
        System.out.println("Eventos en curso: ");

        for (Evento ev : eventosEnCurso) {
            System.out.println(numeracion + ".  " + ev.getNombre() + " (" + ev.getFecha() + ")");
            numeracion += 1;
        }
    }
}





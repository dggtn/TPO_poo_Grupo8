package aplicacion;

import modelo.*;
import pantallas.PantallaCrearEvento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GestorDeEventos {
    private List<Evento> eventos;
    private PantallaCrearEvento pantallaCrearEvento;

    public GestorDeEventos() {
        this.eventos = new ArrayList<>();
        this.pantallaCrearEvento = new PantallaCrearEvento(new Scanner(System.in));
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
                case 'z':
                    buscarEvento(teclado);
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
                        editarUbicacion(teclado, eventoAEditar);
                        break;
                    case 5:
                        editarDescripcion(teclado, eventoAEditar);
                        break;
                    case 6:
                        administrarIntegrantes(teclado, eventoAEditar);
                        break;
                    case 7:
                        administrarRecursos(teclado, eventoAEditar);
                        break;
                    case 8:
                        mostrarFeedbacks(eventoAEditar,teclado);
                        break;
                    case 0 :
                        System.out.println("Volviendo al menu principal");
                    default:
                        System.out.println("Opción inválida");

                }
            }
        }
    }

    public void mostrarFeedbacks(Evento eventoAEditar, Scanner teclado) {
        int opcion = -1;
        while (opcion != 0) {
            if (eventoAEditar.tieneFeedbacks()) {
                int numeracion = 1;
                System.out.println("Feedbacks: ");
                List<Feedback> feedbacks = eventoAEditar.getFeedbacks();
                for (Feedback fe : feedbacks) {
                    System.out.println(numeracion + ".modelo.Feedback:  " + fe.getMensaje() + "Autor:  " + fe.getAutor());
                    numeracion += 1;
                }
            } else {
                System.out.println("Todavia no hay feedbacks para  este evento");
            }
            var menu = """
                    1 - Da tu feedback sobre el evento 
                    0 - Volver a menu principal
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Escribe el feedback:");
                    String mensaje = teclado.nextLine();
                    System.out.println("Escribe tu nombre:");
                    String autor = teclado.nextLine();
                    eventoAEditar.darFeedback(mensaje, autor);
                    break;
                case 0 :
                    System.out.println("Volviendo al menu principal");
                default:
                    System.out.println("Opción inválida");

            }
        }
    }

    private void administrarIntegrantes(Scanner teclado, Evento eventoAEditar) {
        int opcion = -1;
        while (opcion != 0) {
            mostrarIntegrantes(eventoAEditar);
            System.out.println(); //espacio entre el listado y el menu
            var menu = """
                    1 - Agregar
                    2 - Eliminar
                    3 - Editar
                    0 - Volver al menu anterior
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    agregarIntegrante(teclado, eventoAEditar);
                    break;
                case 2:
                    eliminarIntegrante(teclado, eventoAEditar);
                    break;
                case 3:

                    editarIntegranteExistente(teclado, eventoAEditar);
                    break;
                case 0 :
                    System.out.println("Volviendo al menu principal");
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void editarIntegranteExistente(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa el numero del integrante a editar");
        int numero = teclado.nextInt();
        teclado.nextLine();
        int tamanioLista = eventoAEditar.cantidadIntegrantes();
        if (numero <= tamanioLista) {
            Persona integrante = eventoAEditar.obtenerIntegrante(numero - 1);
            System.out.println("Ingrese el nuevo nombre del integrante: ");
            String nombre = teclado.nextLine();
            integrante.setNombre(nombre);
        }
    }

    private void administrarRecursos(Scanner teclado, Evento eventoAEditar) {
        int opcion = -1;
        while (opcion != 0) {
            mostrarRecursos(eventoAEditar);
            System.out.println(); //espacio entre el listado y el menu
            var menu = """
                    1 - Agregar
                    2 - Eliminar
                    3 - Editar
                    0 - Volver al menu anterior
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    agregarRecurso(teclado, eventoAEditar);
                    break;
                case 2:
                    eliminarRecurso(teclado, eventoAEditar);
                    break;
                case 3:

                    editarRecursoExistente(teclado, eventoAEditar);
                    break;
                case 0 :
                    System.out.println("Volviendo al menu principal");
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    public void mostrarRecursos(Evento eventoAEditar) {
        if (eventoAEditar.tieneRecursos()) {
            int numeracion = 1;
            System.out.println("Recursos: ");
            List<Recurso> recursos = eventoAEditar.getRecursos();
            for (Recurso in : recursos) {
                System.out.println(numeracion + ".  " + in.getNombre());
                numeracion += 1;
            }
        } else {
            System.out.println("No hay recursos asignados en este evento");
        }
    }

    private void editarRecursoExistente(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa el numero del recurso editar");
        int numero = teclado.nextInt();
        teclado.nextLine();
        int tamanioLista = eventoAEditar.cantidadRecursos();
        if (numero <= tamanioLista) {
            Recurso recurso = eventoAEditar.obtenerRecurso(numero - 1);
            System.out.println("Ingrese el nuevo nombre del recurso: ");
            String nombre = teclado.nextLine();
            recurso.setNombre(nombre);
        }
    }

    private void eliminarRecurso(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa el numero del recurso a eliminar");
        int numero = teclado.nextInt();
        int tamanioLista = eventoAEditar.cantidadRecursos();
        if (numero <= tamanioLista) {
            eventoAEditar.eliminarRecurso(numero - 1);
        }

    }

    private void agregarRecurso(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa recurso a agregar :");
        String recurso = teclado.nextLine();
        eventoAEditar.agregarRecurso(recurso);
    }

    private void editarDescripcion(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa la nueva descripción");
        String descripcion = teclado.nextLine();
        eventoAEditar.setDescripcion(descripcion);
    }

    private void agregarIntegrante(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa el nombre a agregar");
        String nombre = teclado.nextLine();
        eventoAEditar.agregarIntegrante(nombre);
    }

    public void mostrarIntegrantes(Evento eventoAEditar) {

        if (eventoAEditar.tieneIntegrantes()) {
            int numeracion = 1;
            System.out.println("Integrantes: ");
            List<Persona> integrantes = eventoAEditar.getIntegrantes();
            for (Persona in : integrantes) {
                System.out.println(numeracion + ".  " + in.getNombre());
                numeracion += 1;
            }
        } else {
            System.out.println("No hay integrantes en este evento");
        }
    }

    private void eliminarIntegrante(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa el numero del integrante a eliminar");
        int numero = teclado.nextInt();
        int tamanioLista = eventoAEditar.cantidadIntegrantes();
        if (numero <= tamanioLista) {
            eventoAEditar.eliminarIntegrante(numero - 1);
        }

    }

    private void editarNombre(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa el nuevo nombre");
        String nombre = teclado.nextLine();
        eventoAEditar.setNombre(nombre);
    }

    private void editarFecha(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa la nueva fecha");
        String fecha = teclado.nextLine();
        eventoAEditar.setFecha(LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    private void editarCapacidad(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa la nueva capacidad maxima");
        int capacidadMaxima = teclado.nextInt();
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
        List<Evento> eventosPasados = eventos.stream()
                .filter(Evento::yaSucedio)
                .toList();

        int numeracion = 1;
        System.out.println("Eventos Pasados: ");

        for (Evento ev : eventosPasados) {
            System.out.println(numeracion + ".  " + ev.getNombre() + " (" + ev.getFecha() + ")");
            numeracion += 1;
        }
    }

    private void mostrarEventosEnCurso() {
        List<Evento> eventosEnCurso = eventos.stream()
                .filter(Evento::estanEnCurso)
                .toList();

        int numeracion = 1;
        System.out.println("Eventos en curso: ");

        for (Evento ev : eventosEnCurso) {
            System.out.println(numeracion + ".  " + ev.getNombre() + " (" + ev.getFecha() + ")");
            numeracion += 1;
        }
    }



    public void buscarEvento(Scanner teclado) {
        List<Evento> eventosEncontrados = new ArrayList<>();
        System.out.println("Ingresa nombre del evento:");
        String nombreEvento = teclado.next();
        for (Evento evento : eventos) {
            if (evento.getNombre().contains(nombreEvento)) {
                eventosEncontrados.add(evento);
            }
            if (eventosEncontrados.isEmpty()) {
                System.out.println("No hay eventos disponibles");
            } else {
                for (Evento ev : eventosEncontrados) {
                    System.out.println(ev.getNombre());
                }
            }

        }
    }

    private int leerNumeroEntero(Scanner teclado, String mensajeDeError) {
        int valor = 0;
        boolean seguirPidiendo = true;
        while (seguirPidiendo) {
            try {
                valor = teclado.nextInt();
                seguirPidiendo = false;
            } catch(InputMismatchException e){
                teclado.nextLine();
                System.out.println(mensajeDeError);
            }
        }
        return valor;
    }

    public void editarUbicacion(Scanner teclado, Evento eventoAEditar) {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("Ingresa el numero de opción que quieres editar:");
            System.out.println("Provincia: " + eventoAEditar.getUbicacion().getProvincia());
            System.out.println("Ciudad: " + eventoAEditar.getUbicacion().getCiudad());
            System.out.println("Codigo:  " + eventoAEditar.getUbicacion().getCodigoPostal());
            System.out.println("Numero:  " + eventoAEditar.getUbicacion().getNumero());
            System.out.println("Calle:  " + eventoAEditar.getUbicacion().getCalle());
            System.out.println(); //espacio entre el listado y el menu
            var menu = """
                    1 - Editar provincia
                    2 - Editar ciudad
                    3 - Editar codigo
                    4 - Editar numero
                    5 - Editar calle
                    0 - Volver al menu anterior
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:

                    editarProvincia(teclado, eventoAEditar);
                    break;
                case 2:

                    editarCiudad(teclado, eventoAEditar);
                    break;
                case 3:

                    editarCodigo(teclado, eventoAEditar);
                    break;
                case 4:
                    editarNumero(teclado, eventoAEditar);
                    break;
                case 5:
                    editarCalle(teclado, eventoAEditar);
                    break;
                case 0 :
                    System.out.println("Volviendo al menu principal");
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void editarProvincia(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa la nueva provincia:");
        String provincia = teclado.nextLine();
        eventoAEditar.getUbicacion().setProvincia(provincia);
    }

    private void editarCiudad(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa la nueva ciudad:");
        String ciudad = teclado.nextLine();
        eventoAEditar.getUbicacion().setCiudad(ciudad);
    }

    private void editarCodigo(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa el nuevo codigo:");
        int codigo = this.leerNumeroEntero(teclado,"El codigo postal debe ser un numero entero");
        eventoAEditar.getUbicacion().setCodigoPostal(codigo);
    }

    private void editarNumero(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa el nuevo numero:");
        int numero = this.leerNumeroEntero(teclado,"El numero de domicilio debe ser un numero entero");
        eventoAEditar.getUbicacion().setNumero(numero);
    }

    private void editarCalle(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa la nueva calle:");
        String calle = teclado.nextLine();
        eventoAEditar.getUbicacion().setCalle(calle);
    }

}





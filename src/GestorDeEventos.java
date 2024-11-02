
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorDeEventos {
    private List<Evento> eventos;

    public GestorDeEventos() {
        this.eventos = new ArrayList<>();
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
                    b - Elegir Evento
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.next().charAt(0);
            teclado.nextLine();

            switch (opcion) {
                case 'a':
                    crearEvento(teclado);
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
    private void editarEvento(Scanner teclado){
        System.out.println("Ingresa el numero de evento que quieres editar:");
        int numeracion = teclado.nextInt();
        if(numeracion!=0 && numeracion<=eventos.size()){
            Evento eventoAEditar = eventos.get(numeracion-1);

            int opcion = -1;
            while (opcion != 0) {
                System.out.println("Nombre: "+eventoAEditar.getNombre());
                System.out.println("Capacidad maxima: "+eventoAEditar.getCapacidadMaxima());
                System.out.println("Fecha:  "+eventoAEditar.getFecha());
                var menu = """
                        1 - Editar Nombre
                        2 - Editar fecha
                        3 - Editar capacidad
                        0 - Volver al menu anterior
                        """;
                System.out.println(menu);
                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {
                    case 1:

                        editarNombre(teclado,eventoAEditar);
                        break;
                    case 2:

                        editarFecha(teclado, eventoAEditar);
                        break;
                    case 3:

                        editarCapacidad(teclado,eventoAEditar);
                        break;
                }
            }
        }
    }

    private void editarNombre(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa el nuevo nombre");
        String nombre =  teclado.nextLine();
        eventoAEditar.setNombre(nombre);
    }
    private void editarFecha(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa la nueva fecha");
        String fecha =  teclado.nextLine();
        eventoAEditar.setFecha(fecha);
    }
    private void editarCapacidad(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa la nueva capacidad maxima");
        int capacidadMaxima =  teclado.nextInt();
        eventoAEditar.setCapacidadMaxima(capacidadMaxima);
    }


    private void mostrarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos disponibles");
        } else {
            int numeracion = 1;
            System.out.println("Eventos: ");
            for (Evento ev : eventos) {
                System.out.println(numeracion + ".  " + ev.getNombre() + " (" + ev.getFecha() + ")");
                numeracion += 1;
            }

        }

        System.out.println();
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

    public void crearEvento(Scanner teclado) {
        System.out.println("Ingresa nombre del evento:");
        String nombreEvento = teclado.nextLine();
        System.out.println("Ingresa capacidad maxima del evento: ");
        int capacidadMaxima = teclado.nextInt();
        System.out.println(" Ingresa fecha del evento:");
        String fechaEvento = teclado.next();
        Evento evento = new Evento(nombreEvento, capacidadMaxima, fechaEvento);
        eventos.add(evento);
    }
}


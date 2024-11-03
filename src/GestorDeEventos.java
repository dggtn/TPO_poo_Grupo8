
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
                    b - Elegir y editar Evento
                    c - 
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
                var menu = """
                        1 - Editar Nombre
                        2 - Editar fecha
                        3 - Editar capacidad
                        4 - Editar Ubicación
                        5 - Editar Descripcion 
                        6 - Agregar Integrantes
                        7 - Mostrar Lista de Integrantes
                        8 - Eliminar Integrantes
                        9 - Agregar Recursos
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
                        agregarIntegrantes(teclado, eventoAEditar);
                        break;
                    case 7:
                        mostrarIntegrantes(eventoAEditar);
                        break;
                    case 8:
                        eliminarIntegrante(teclado, eventoAEditar);
                        break;
                }
            }
        }
    }

    private void editarDescripcion(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa la nueva descripción");
        String descripcion = teclado.nextLine();
        eventoAEditar.setDescripcion(descripcion);
    }

    private void agregarIntegrantes(Scanner teclado, Evento eventoAEditar) {
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
        eventoAEditar.setFecha(fecha);
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
        System.out.println("Ingresa la descripción del evento:");
        String descripcionEvento = teclado.nextLine();
        System.out.println("Ingresa capacidad maxima del evento: ");
        int capacidadMaxima = teclado.nextInt();
        System.out.println(" Ingresa fecha del evento:");
        String fechaEvento = teclado.next();
        teclado.nextLine(); //para ignorar el enter
        System.out.println(" Ingresa ubicación del evento:");
        System.out.println("Ingresa provincia:");
        String provincia = teclado.nextLine();
        System.out.println("Ingresa ciudad:");
        String ciudad = teclado.nextLine();
        System.out.println("Ingresa codigo postal: ");
        int codigoPostal = teclado.nextInt();
        System.out.println(" Ingresa numero de domicilio:");
        int numero = teclado.nextInt();
        System.out.println(" Ingresa calle:");
        String calle = teclado.next();

        Ubicacion ubicacion = new Ubicacion(provincia, ciudad, codigoPostal, numero, calle);
        Evento evento = new Evento(nombreEvento, descripcionEvento, capacidadMaxima, fechaEvento, ubicacion);
        eventos.add(evento);
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
        int codigo = teclado.nextInt();
        eventoAEditar.getUbicacion().setCodigoPostal(codigo);
    }

    private void editarNumero(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa el nuevo numero:");
        int numero = teclado.nextInt();
        eventoAEditar.getUbicacion().setNumero(numero);
    }

    private void editarCalle(Scanner teclado, Evento eventoAEditar) {
        System.out.println("Ingresa la nueva calle:");
        String calle = teclado.nextLine();
        eventoAEditar.getUbicacion().setCalle(calle);
    }

}






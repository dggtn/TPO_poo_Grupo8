
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorDeEventos {
    private List <Evento>eventos;

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
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Crear evento 
                    2 - Mostrar eventos
                    3 - Buscar Evento
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    crearEvento(teclado);
                    break;
                case 2:
                    if (eventos.isEmpty()) {
                        System.out.println("No hay eventos disponibles");
                    }else {
                        for(Evento ev :eventos) {
                            System.out.println(ev.getNombre());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Escribe el nombre del evento para ver sus detalles(fecha,descripción,etc..");
                    buscarEvento(teclado);

                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        }

    }
    public void buscarEvento(Scanner teclado){
        List<Evento>eventosEncontrados = new ArrayList<>();
        System.out.println("Ingresa nombre del evento:");
        String nombreEvento = teclado.next();
       for (Evento evento:eventos){
           if(evento.getNombre().contains(nombreEvento)){
               eventosEncontrados.add(evento);
           }
       if (eventosEncontrados.isEmpty()) {
           System.out.println("No hay eventos disponibles");
       }else {
           for(Evento ev :eventosEncontrados) {
               System.out.println(ev.getNombre());
           }
       }

        }
    }
    public void crearEvento(Scanner teclado){
        System.out.println("Ingresa nombre del evento:");
        String nombreEvento = teclado.nextLine();
        System.out.println("Ingresa capacidad maxima del evento: ");
        int capacidadMaxima = teclado.nextInt();
        System.out.println(" Ingresa fecha del evento:");
        String fechaEvento = teclado.next();
        Evento evento = new Evento(nombreEvento, capacidadMaxima,fechaEvento);
        eventos.add(evento);
    }
}

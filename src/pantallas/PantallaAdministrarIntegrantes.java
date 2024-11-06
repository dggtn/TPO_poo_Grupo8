package pantallas;

import modelo.Evento;
import modelo.Persona;
import modelo.Teclado;

import java.util.List;

public class PantallaAdministrarIntegrantes {

    private final Teclado teclado;

    public PantallaAdministrarIntegrantes(Teclado teclado) {
        this.teclado = new Teclado();
    }
    public void iniciar(Evento eventoAEditar){
        int opcion = -1;
        while (opcion != 0) {
            mostrarIntegrantes(eventoAEditar);
            System.out.println(); //espacio entre el listado y el menu
            var menu = """
                    1 - Agregar
                    2 - Eliminar
                    0 - Volver al menu anterior
                    """;
            System.out.println(menu);
            opcion = teclado.leerNumero();
            teclado.leerTexto();

            switch (opcion) {
                case 1:
                    agregarIntegrante(eventoAEditar);
                    break;
                case 2:
                    eliminarIntegrante(eventoAEditar);
                    break;
                case 0 :
                    System.out.println("Volviendo al menu principal");
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
    private void eliminarIntegrante(Evento eventoAEditar) {
        System.out.println("Ingresa el numero del integrante a eliminar");
        int numero = teclado.leerNumero();
        int tamanioLista = eventoAEditar.cantidadIntegrantes();
        if (numero <= tamanioLista) {
            eventoAEditar.eliminarIntegrante(numero - 1);
        }

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
    private void agregarIntegrante(Evento eventoAEditar) {
        System.out.println("Ingresa el nombre a agregar");
        String nombre = teclado.leerTexto();
        eventoAEditar.agregarIntegrante(nombre);
    }

}

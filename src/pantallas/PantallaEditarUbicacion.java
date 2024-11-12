package pantallas;

import modelo.Evento;
import modelo.Teclado;

public class PantallaEditarUbicacion {
    private final Teclado teclado;
    public PantallaEditarUbicacion (Teclado teclado){
        this.teclado = new Teclado();
    }
    public void editarUbicacion(Evento eventoAEditar) {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("Ingresa el numero de opción que quieres editar:");
            System.out.println("Numero:  " + eventoAEditar.getUbicacion().getNumero());
            System.out.println("Calle:  " + eventoAEditar.getUbicacion().getCalle());
            System.out.println(); //espacio entre el listado y el menu
            var menu = """
                    1 - Editar numero
                    2 - Editar calle
                    0 - Volver al menu anterior
                    """;
            System.out.println(menu);
            opcion = teclado.leerNumeroEntero("Opción a elegir:  ","La opción debe ser numero entero");

            switch (opcion) {
                case 1:
                    editarNumero( eventoAEditar);
                    break;
                case 2:
                    editarCalle(eventoAEditar);
                    break;
                case 0 :
                    System.out.println("Volviendo al menu principal");
                default:
                    System.out.println("Opción inválida");
            }
        }
    }


    private void editarNumero(Evento eventoAEditar) {
        int numero = this.teclado.leerNumeroEntero("Ingresa el nuevo numero:","El numero de domicilio debe ser un numero entero");
        eventoAEditar.getUbicacion().setNumero(numero);
    }

    private void editarCalle(Evento eventoAEditar) {
        System.out.println("Ingresa la nueva calle:");
        String calle = teclado.leerLinea();
        eventoAEditar.getUbicacion().setCalle(calle);
    }



}

package pantallas;

import modelo.Evento;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PantallaEditarUbicacion {
    private final Scanner teclado;
    public PantallaEditarUbicacion (Scanner teclado){
        this.teclado = teclado;
    }
    public void editarUbicacion(Evento eventoAEditar) {
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


}

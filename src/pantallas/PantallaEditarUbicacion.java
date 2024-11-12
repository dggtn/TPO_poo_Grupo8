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
            opcion = teclado.leerNumeroEntero("Opción a elegir:  ","La opción debe ser numero entero");
            teclado.leerLinea();

            switch (opcion) {
                case 1:

                    editarProvincia(eventoAEditar);
                    break;
                case 2:
                    editarCiudad(eventoAEditar);
                    break;
                case 3:
                    editarCodigo(eventoAEditar);
                    break;
                case 4:
                    editarNumero( eventoAEditar);
                    break;
                case 5:
                    editarCalle(eventoAEditar);
                    break;
                case 0 :
                    System.out.println("Volviendo al menu principal");
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void editarProvincia( Evento eventoAEditar) {
        System.out.println("Ingresa la nueva provincia:");
        String provincia = teclado.leerLinea();
        eventoAEditar.getUbicacion().setProvincia(provincia);
    }

    private void editarCiudad(Evento eventoAEditar) {
        System.out.println("Ingresa la nueva ciudad:");
        String ciudad = teclado.leerLinea();
        eventoAEditar.getUbicacion().setCiudad(ciudad);
    }

    private void editarCodigo(Evento eventoAEditar) {
        int codigo = this.teclado.leerNumeroEntero("Ingresa el nuevo codigo:","El codigo postal debe ser un numero entero");
        eventoAEditar.getUbicacion().setCodigoPostal(codigo);
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

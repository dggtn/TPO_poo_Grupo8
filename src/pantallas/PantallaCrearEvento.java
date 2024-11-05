package pantallas;

import modelo.Evento;
import modelo.Teclado;
import modelo.Ubicacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PantallaCrearEvento {

    private final Teclado teclado;

    public PantallaCrearEvento(Teclado teclado) {
        this.teclado = new Teclado();
    }

    public Evento crear() {
        System.out.println("Ingresa nombre del evento:");
        String nombreEvento = teclado.leerLinea();

        System.out.println("Ingresa la descripción del evento:");
        String descripcionEvento =teclado.leerLinea();;

        System.out.println("Ingresa capacidad maxima del evento: ");
        int capacidadMaxima = this.teclado.leerNumeroEntero( "La capacidad maxima deber ser un numero mayor a 0");

        LocalDate fecha= teclado.leerFecha(" Ingresa fecha del evento (dd/MM/yyyy): ");
        teclado.leerLinea();;

        System.out.println(" Ingresa ubicación del evento:");
        System.out.println("Ingresa provincia:");
        String provincia = teclado.leerLinea();;
        System.out.println("Ingresa ciudad:");
        String ciudad = teclado.leerLinea();;
        System.out.println("Ingresa codigo postal: ");
        int codigoPostal = this.teclado.leerNumeroEntero("El codigo postal debe ser un numero entero");
        System.out.println(" Ingresa numero de domicilio:");
        int numero = this.teclado.leerNumeroEntero( "El numero de domicilio debe ser un numero entero");
        System.out.println(" Ingresa calle:");
        String calle = teclado.leerTexto();

        Ubicacion ubicacion = new Ubicacion(provincia, ciudad, codigoPostal, numero, calle);
        return new Evento(nombreEvento, descripcionEvento, capacidadMaxima, fecha, ubicacion);
    }


}

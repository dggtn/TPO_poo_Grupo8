package pantallas;

import modelo.Evento;
import modelo.Teclado;
import modelo.Ubicacion;

import java.time.LocalDate;


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
        int capacidadMaxima = this.teclado.leerNumeroEntero("Ingresa capacidad maxima del evento: ", "La capacidad maxima deber ser un numero mayor a 0");
        LocalDate fecha= teclado.leerFecha(" Ingresa fecha del evento (dd/MM/yyyy): ");
        teclado.leerLinea();

        System.out.println(" Ingresa ubicación del evento:");
        System.out.println("Ingresa provincia:");
        String provincia = teclado.leerLinea();;
        System.out.println("Ingresa ciudad:");
        String ciudad = teclado.leerLinea();;
        int codigoPostal = this.teclado.leerNumeroEntero("Ingresa codigo postal: ","El codigo postal debe ser un numero entero");
        int numero = this.teclado.leerNumeroEntero(" Ingresa numero de domicilio:", "El numero de domicilio debe ser un numero entero");
        String calle = teclado.leerTexto(" Ingresa calle:");

        Ubicacion ubicacion = new Ubicacion(provincia, ciudad, codigoPostal, numero, calle);
        return new Evento(nombreEvento, descripcionEvento, capacidadMaxima, fecha, ubicacion);
    }


}

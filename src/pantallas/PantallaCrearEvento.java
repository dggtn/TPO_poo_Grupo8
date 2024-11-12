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
        String descripcionEvento =this.teclado.leerLinea();;
        int capacidadMaxima = this.teclado.leerNumeroEntero("Ingresa capacidad maxima del evento: ", "La capacidad maxima deber ser un numero mayor a 0");
        LocalDate fecha= teclado.leerFecha("Ingresa fecha del evento en formato correcto: (dd/MM/yyyy): ");
        teclado.leerLinea();

        System.out.println(" Ingresa ubicación del evento:");
        int numero = this.teclado.leerNumeroEntero(" Ingresa numero de domicilio:", "El numero de domicilio debe ser un numero entero");
        String calle = teclado.leerTexto(" Ingresa calle:");

        Ubicacion ubicacion = new Ubicacion(numero, calle);
        return new Evento(nombreEvento, descripcionEvento, capacidadMaxima, fecha, ubicacion);
    }


}

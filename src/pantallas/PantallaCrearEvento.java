package pantallas;

import modelo.Evento;
import modelo.Ubicacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PantallaCrearEvento {

    private final Scanner teclado;

    public PantallaCrearEvento(Scanner teclado) {
        this.teclado = teclado;
    }

    public Evento crear() {
        System.out.println("Ingresa nombre del evento:");
        String nombreEvento = teclado.nextLine();

        System.out.println("Ingresa la descripción del evento:");
        String descripcionEvento = teclado.nextLine();

        System.out.println("Ingresa capacidad maxima del evento: ");
        int capacidadMaxima = this.leerNumeroEntero(teclado, "La capacidad maxima deber ser un numero mayor a 0");

        System.out.println(" Ingresa fecha del evento (dd/MM/yyyy): ");
        String fechaEvento = teclado.next();

        LocalDate fecha= LocalDate.parse(fechaEvento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        teclado.nextLine();

        System.out.println(" Ingresa ubicación del evento:");
        System.out.println("Ingresa provincia:");
        String provincia = teclado.nextLine();
        System.out.println("Ingresa ciudad:");
        String ciudad = teclado.nextLine();
        System.out.println("Ingresa codigo postal: ");
        int codigoPostal = this.leerNumeroEntero(teclado,"El codigo postal debe ser un numero entero");
        System.out.println(" Ingresa numero de domicilio:");
        int numero = this.leerNumeroEntero(teclado,"El numero de domicilio debe ser un numero entero");
        System.out.println(" Ingresa calle:");
        String calle = teclado.next();

        Ubicacion ubicacion = new Ubicacion(provincia, ciudad, codigoPostal, numero, calle);
        return new Evento(nombreEvento, descripcionEvento, capacidadMaxima, fecha, ubicacion);
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

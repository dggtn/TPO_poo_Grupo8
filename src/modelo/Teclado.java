package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Teclado {


    private final Scanner scanner;

    public Teclado() {
        this.scanner = new Scanner(System.in);
    }

    public String leerLinea() {
        return this.scanner.nextLine();
    }

    public String leerTexto() {
        return this.scanner.next();
    }

    public int leerNumero() {
        return this.scanner.nextInt();
    }

    public int leerNumeroEntero(String mensajeDeError) {
        int valor = 0;
        boolean seguirPidiendo = true;
        while (seguirPidiendo) {
            try {
                valor = this.scanner.nextInt();
                seguirPidiendo = false;
            } catch (InputMismatchException e) {
                this.scanner.nextLine();
                System.out.println(mensajeDeError);
            }
        }
        return valor;
    }

    public LocalDate leerFecha(String mensajeDeError) {
        LocalDate valor = null;
        boolean seguirPidiendo = true;
        while (seguirPidiendo) {
            try {
                String texto = this.scanner.next();
                valor =LocalDate.parse(texto, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                seguirPidiendo = false;
            } catch (DateTimeParseException e) {
                this.scanner.nextLine();
                System.out.println(mensajeDeError);
            }
        }
        return valor;
    }


}


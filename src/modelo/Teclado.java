package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Teclado {


    private final Scanner scanner;

    public Teclado() {
        this.scanner = new Scanner(System.in);
    }

    public String leerLinea() {
        return this.scanner.nextLine();
    }

    public String leerTexto(String titulo) {
        System.out.println(titulo);
        String valor = this.scanner.next();
        this.scanner.nextLine();
        return valor;
    }

    public int leerNumeroEntero(String titulo,String mensajeDeError) {
        System.out.println(titulo);
        int valor = 0;
        boolean seguirPidiendo = true;
        while (seguirPidiendo) {
            try {
                valor = this.scanner.nextInt();
                seguirPidiendo = false;
            } catch (InputMismatchException e) {
                System.out.println(mensajeDeError);
            }finally{
                this.scanner.nextLine();
            }
        }
        return valor;
    }

    public LocalDate leerFecha(String titulo, String mensajeDeError) {
        LocalDate valor = null;
        boolean seguirPidiendo = true;
        System.out.println(titulo);
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


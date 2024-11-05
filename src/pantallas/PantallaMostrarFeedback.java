package pantallas;

import modelo.Evento;
import modelo.Feedback;
import modelo.Teclado;

import java.util.List;
import java.util.Scanner;

public class PantallaMostrarFeedback {
    private final Teclado teclado;

    public PantallaMostrarFeedback(Teclado teclado) {
        this.teclado = new Teclado();
    }

    public void mostrarFeedback(Evento eventoAEditar) {
        int opcion = -1;
        while (opcion != 0) {
            if (eventoAEditar.tieneFeedbacks()) {
                int numeracion = 1;
                System.out.println("Feedbacks: ");
                List<Feedback> feedbacks = eventoAEditar.getFeedbacks();
                for (Feedback fe : feedbacks) {
                    System.out.println(numeracion + ".modelo.Feedback:  " + fe.getMensaje() + "Autor:  " + fe.getAutor());
                    numeracion += 1;
                }
            } else {
                System.out.println("Todavia no hay feedbacks para  este evento");
            }
            var menu = """
                    1 - Da tu feedback sobre el evento 
                    0 - Volver a menu principal
                    """;
            System.out.println(menu);
            opcion = teclado.leerNumero();
            teclado.leerTexto();

            switch (opcion) {
                case 1:
                    System.out.println("Escribe el feedback:");
                    String mensaje = teclado.leerTexto();
                    System.out.println("Escribe tu nombre:");
                    String autor = teclado.leerTexto();
                    eventoAEditar.darFeedback(mensaje, autor);
                    break;
                case 0:
                    System.out.println("Volviendo al menu principal");
                default:
                    System.out.println("Opción inválida");

            }
        }
    }
}


import java.util.ArrayList;
import java.util.Date;

public class Evento {
    private String descripcion;
    private String estado;
    private Date fecha;
    private String tipo;
    private int capacidadMaxima;
    private ArrayList<Persona>integrantes;
    private ArrayList<Recurso>recursos;
    private ArrayList<Feedback>feedbacks;


    public void escribirFeedback(String mensaje,Persona autor){

    }

    public Evento(String descripcion, String estado, Date fecha, String tipo, int capacidadMaxima) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha = fecha;
        this.tipo = tipo;
        this.capacidadMaxima = capacidadMaxima;
    }

    public void asignarRecursos(String nombre){

    }

    public void mostrarParticipantes(){

    }

    public void agregarIntegrante(Persona Integrante){

    }
    public void borrarParticipantes(Persona Integrante){

    }

    public void mostrarEstadoDelEvento(){

    }
    public void cancelarEvento(){

    }
}

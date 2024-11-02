import java.util.ArrayList;
import java.util.Date;

public class Evento {
    private String nombre;
    private String descripcion;
    private String estado;
    private String fecha;
    private String tipo;
    private int capacidadMaxima;
    private ArrayList<Persona>integrantes;
    private ArrayList<Recurso>recursos;
    private ArrayList<Feedback>feedbacks;

    public Evento() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public void escribirFeedback(String mensaje, Persona autor){
        System.out.println("Autor del mensaje:"+autor);
        System.out.println(mensaje);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Evento(String nombre, int capacidadMaxima, String fecha) {
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.fecha = fecha;
    }

    public Evento(String descripcion, String estado, String fecha, String tipo, int capacidadMaxima) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha = fecha;
        this.tipo = tipo;
        this.capacidadMaxima = capacidadMaxima;
    }

    public void asignarRecursos(String nombre){
        Recurso recurso = new Recurso();
        recursos.add(recurso);

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

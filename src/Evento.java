import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nombre;
    private String descripcion;
    private String estado;
    private String fecha;
    private String tipo;
    private int capacidadMaxima;
    private List<Persona> integrantes;
    private List<Recurso> recursos;
    private List<Feedback> feedbacks;


    public void agregarIntegrante(String nombre) {
        Persona persona = new Persona(nombre);
        integrantes.add(persona);
    }

    public void eliminarIntegrante(String nombre) {
        Persona persona = new Persona(nombre);
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

    public void escribirFeedback(String mensaje, Persona autor) {
        System.out.println("Autor del mensaje:" + autor);
        System.out.println(mensaje);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Evento(String nombre, String descripcion, int capacidadMaxima, String fecha) {
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.integrantes = new ArrayList<>();
        this.recursos = new ArrayList<>();
        this.feedbacks = new ArrayList<>();
    }

    public void asignarRecursos(String nombre) {
        Recurso recurso = new Recurso();
        recursos.add(recurso);

    }

    public boolean tieneIntegrantes() {
        return !this.integrantes.isEmpty();
    }

    public List<Persona> getIntegrantes() {
        return  this.integrantes;
    }

    public int cantidadIntegrantes(){
        return integrantes.size();
    }

    public void eliminarIntegrante(int posicion){
        if(posicion>=0 && posicion<integrantes.size()){
            integrantes.remove(posicion);
        }

    }
}

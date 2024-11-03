import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nombre;
    private String descripcion;
    private String estado;
    private LocalDate fecha;
    private String tipo;
    private int capacidadMaxima;
    private List<Persona> integrantes;
    private List<Recurso> recursos;
    private List<Feedback> feedbacks;
    private Ubicacion ubicacion;



    public void agregarRecurso(String nombre) {
        Recurso recurso = new Recurso(nombre);
        recursos.add(recurso);
    }


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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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

    public Evento(String nombre, String descripcion, int capacidadMaxima, LocalDate fecha, Ubicacion ubicacion) {
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.integrantes = new ArrayList<>();
        this.recursos = new ArrayList<>();
        this.feedbacks = new ArrayList<>();
        this.ubicacion = ubicacion;
    }


    public boolean tieneRecursos() {
        return !this.recursos.isEmpty();
    }


    public boolean tieneIntegrantes() {
        return !this.integrantes.isEmpty();
    }

    public List<Persona> getIntegrantes() {
        return this.integrantes;
    }

    public int cantidadIntegrantes() {
        return integrantes.size();
    }

    public void eliminarIntegrante(int posicion) {
        if (posicion >= 0 && posicion < integrantes.size()) {
            integrantes.remove(posicion);
        }
    }

    public String obtenerDetalleUbicacion() {
        return this.ubicacion.toString();
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public List<Recurso> getRecursos() {
        return this.recursos;
    }

    public List<Feedback> getFeedbacks() {
        return this.feedbacks;
    }
    public int cantidadRecursos() {
        return recursos.size();
    }

    public void eliminarRecurso(int posicion) {
        if (posicion >= 0 && posicion < recursos.size()) {
            recursos.remove(posicion);
        }
    }

    public Recurso obtenerRecurso(int posicion) {
        if (posicion >= 0 && posicion < recursos.size()) {
            return recursos.get(posicion);
        }
        return null;
    }
    public Persona obtenerIntegrante(int posicion) {
        if (posicion >= 0 && posicion < integrantes.size()) {
            return integrantes.get(posicion);
        }
        return null;
    }
    public void darFeedback(String mensaje,String autor){
        Feedback feedback = new Feedback(mensaje,autor);
        feedbacks.add(feedback);
    }

    public boolean tieneFeedbacks() {
        return !this.feedbacks.isEmpty();
    }

    public boolean yaSucedio() {
        return fecha.isBefore(LocalDate.now());
    }

    public boolean estanEnCurso() {
        return !yaSucedio();
    }
}

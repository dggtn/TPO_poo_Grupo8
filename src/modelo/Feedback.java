package modelo;

public class Feedback {
    private String mensaje;
    private String autor;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Feedback(String mensaje, String autor) {
        this.mensaje = mensaje;
        this.autor = autor;
    }

}


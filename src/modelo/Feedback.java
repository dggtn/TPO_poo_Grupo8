package modelo;

public class Feedback {
    private String mensaje;
    private String autor;

    public String getMensaje() {
        return mensaje;
    }


    public String getAutor() {
        return autor;
    }


    public Feedback(String mensaje, String autor) {
        this.mensaje = mensaje;
        this.autor = autor;
    }

}


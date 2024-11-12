package modelo;

public class Ubicacion {
    private String calle;
    private int numero;


    public Ubicacion(int numero, String calle) {
        this.numero = numero;
        this.calle = calle;
    }


    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Ubicacion:" +
                ", calle: '" + calle + '\'' +
                ", numero: " + numero ;
    }
}

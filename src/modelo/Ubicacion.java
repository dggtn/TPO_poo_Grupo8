package modelo;

public class Ubicacion {
    private String provincia;
    private String ciudad;
    private int codigoPostal;
    private String calle;
    private int numero;


    public Ubicacion(String provincia, String ciudad, int codigoPostal, int numero, String calle) {
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.numero = numero;
        this.calle = calle;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
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
        return "modelo.Ubicacion:" +
                "ciudad: '" + ciudad + '\'' +
                ", provincia: '" + provincia + '\'' +
                ", calle: '" + calle + '\'' +
                ", numero: " + numero ;
    }
}

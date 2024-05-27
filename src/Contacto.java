import java.util.ArrayList;
import java.io.*;
public class Contacto implements Serializable{
    private String nombre;
    private int numero;

    //Constructors
    public Contacto(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    //Getters i setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Numero: " + numero;
    }
    public static Contacto consultarContacto(ArrayList<Contacto> contactos, String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null;
    }
}

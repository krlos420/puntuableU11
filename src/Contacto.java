import java.util.ArrayList;
import java.io.*;
public class Contacto {
    private String nombre;
    private int numero;

    //Constructors
    public Contacto(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public Contacto() {
    }
    //Getters i setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "nombre= " + nombre + ", numero=" + numero;
    }
    public static Contacto consultarContacto(ArrayList<Contacto> contactos, String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null;
    }
    public static ArrayList<Contacto> importarContactos(String nombreArchivo) {
        ArrayList<Contacto> contactos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nombreArchivo)))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    try {
                        String nombre = partes[0];
                        int telefono = Integer.parseInt(partes[1]);
                        contactos.add(new Contacto(nombre, telefono));
                    } catch (NumberFormatException e) {
                        System.err.println("Error al convertir el teléfono a entero: " + partes[1]);
                    }
                }
            }
            System.out.println("Contactos importados desde " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return contactos;
    }
    public static void exportarContactos(ArrayList<Contacto> contactos, String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nombreArchivo)))) {
            for (Contacto contacto : contactos) {
                bw.write(contacto.toString());
                bw.newLine();
            }
            System.out.println("Contactos exportados a " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

}

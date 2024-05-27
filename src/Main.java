import java.util.ArrayList;
import java.io.*;
public class Main {
    private static ArrayList<Contacto> contactos = new ArrayList<>();
    public static void main(String[] args) {
        boolean av = true;
        while (av=true) {
            int menu;
            System.out.println("---Menu---");
            System.out.println("1. Dar de alta un contacto");
            System.out.println("2. Consultar un contacto por nombre");
            System.out.println("3. Cantidad de amigos grabados");
            System.out.println("4. Mostrar toda la agenda");
            System.out.println("5. Borrar un contacto");
            System.out.println("6. Modificar datos de un contacto");
            System.out.println("7. Importar datos");
            System.out.println("8. Exportar datos");
            System.out.println("9. Salir");
            menu = Leer.leerEntero("Que quieres hacer? ");

            if (menu == 1) {
                String continuar = "";
                do {
                    String nom = Leer.leerTexto("Nombre del contacto: ");
                    int numero = Leer.leerEntero("Numero del contacto: ");
                    Contacto contacto = new Contacto(nom, numero);
                    contactos.add(contacto);
                    continuar = Leer.leerTexto("Quieres añadir otro contacto? s/n ");
                } while (continuar.equalsIgnoreCase("s"));
            }
            if (menu == 2) {
                String nombreBuscado = Leer.leerTexto("Escribe el nombre del contacto que quieres consultar ");
                System.out.println(Contacto.consultarContacto(contactos, nombreBuscado));
            }
            if (menu == 3) {
                System.out.println("La agenda tiene " + contactos.size() + " amigos grabados");
            }
            if (menu == 4) {
                for (int i = 0; i < contactos.size(); i++) {
                    System.out.println(i + "-" + contactos.get(i));
                }
            }
            if (menu == 5) {
                for (int i = 0; i < contactos.size(); i++) {
                    System.out.println(i + "-" + contactos.get(i));
                }
                int b = Leer.leerEntero("Que numero de contacto quieres borrar? ");
                contactos.remove(b);
            }
            if (menu == 6) {
                for (int i = 0; i < contactos.size(); i++) {
                    System.out.println(i + "-" + contactos.get(i));
                }
                int modificar = Leer.leerEntero("Que numero de contacto quieres modificar? ");
                System.out.println("1. Cambiar nombre");
                System.out.println("2. Cambiar número");
                int m = Leer.leerEntero("Que quieres modificar? ");
                if (m == 1) {
                    String nuevoNombre = Leer.leerTexto("Indica el nuevo nombre ");
                    contactos.get(modificar).setNombre(nuevoNombre);
                }
                if (m == 2) {
                    int nuevoNumero = Leer.leerEntero("Indica el nuevo numero ");
                    contactos.get(modificar).setNumero(nuevoNumero);
                }
            }
            if (menu == 7) {
                String ArchivosImportar = Leer.leerTexto("Ingrese el nombre del archivo que quieres importar: ");
                File archivosImportar = new File(ArchivosImportar);
                contactos = Funciones.desdeFichero(archivosImportar);

            }
            if (menu == 8) {
                String ArchivosExportar = Leer.leerTexto("Ingrese el nombre del archivo para exportar: ");
                File archivosExportar = new File(ArchivosExportar);
                Funciones.aFichero(archivosExportar, contactos);
            }
            if (menu == 9) {
                break;
            }
        }
    }

}
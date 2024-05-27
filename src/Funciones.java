import java.io.*;
import java.util.ArrayList;

public class Funciones {
    public static ArrayList<Contacto> desdeFichero(File f){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<Contacto> contactos = new ArrayList<>();
        System.out.println("Leyendo lista de contactos...");

        try{
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            contactos = (ArrayList<Contacto>) ois.readObject();
        } catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ois.close();
                fis.close();
            } catch (IOException e){
                System.out.println(e);
            }
        }
        return contactos;
    }
    public static void aFichero (File f, ArrayList<Contacto> contactos){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        System.out.println("Guardant la agenda...");

        try {
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(contactos);
        } catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        } finally{
            try{
                oos.close();
                fos.close();
            } catch (IOException e){
                System.out.println(e);
            }
        }
    }
}

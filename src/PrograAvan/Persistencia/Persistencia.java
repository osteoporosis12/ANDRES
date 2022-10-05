package PrograAvan.Persistencia;

import java.io.*;

public class Persistencia {
    public Object recuperar(String nombre_arch) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(nombre_arch);
        ObjectInputStream ois = new ObjectInputStream(fis);
        //lee el objeto del archivo
        Object resul = ois.readObject();
        ois.close();
        return resul;
    }
    public void almacenar(String nombre_arch, Object objeto) throws IOException {
        FileOutputStream fos = null;
        fos = new FileOutputStream(nombre_arch);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        //escribe el objeto serializado a un archivo
        oos.writeObject(objeto);
        oos.flush();
        oos.close();
    }
}

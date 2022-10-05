import PrograAvan.NoLineal.ArbolBinario;

public class Principal {
    public static void main(String[] args) {
        Arbol_RN<Integer,String> lista=new Arbol_RN<>();
        lista.insertar(7,"Juan");
        lista.insertar(5,"pablo");
        lista.insertar(9,"perico");
        lista.insertar(4,"kratos");
        lista.insertar(6,"Ingridh");
        lista.insertar(8,"eduardo");
        lista.insertar(10,"julio");
        lista.profundidad();
        System.out.println("____________");
        lista.amplitud();
        //aloja?
        //prueba
    }
}

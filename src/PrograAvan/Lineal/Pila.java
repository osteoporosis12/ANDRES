package PrograAvan.Lineal;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Pila<T> implements Iterable<T>{
    private Nodo<T> primero;
    private int tam;

    public Pila() {
        primero = null;
        tam = 0;
    }

    public boolean esta_vacia(){
        return primero == null;
    }

    public int getTam() {
        return tam;
    }
    public void empilar(T item){
        Nodo<T> antiguo = primero;
        primero = new Nodo<T>();
        primero.item = item;
        primero.enlace = antiguo;
        tam++;
    }
    public T desempilar(){
        if (esta_vacia()) throw new NoSuchElementException("Pila vacia");
        T result = primero.item;
        primero= primero.enlace;
        tam--;
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(primero);
    }
    private class ListIterator implements Iterator<T>{
        private Nodo<T> actual;

        public ListIterator(Nodo<T> pri){
            actual = pri;
        }
        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T dato = actual.item;
            actual = actual.enlace;
            return dato;
        }
    }
}
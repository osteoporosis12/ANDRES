package PrograAvan.Lineal;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Cola<T> implements Iterable<T>{
    private T item;
    private Nodo<T> ultimo;
    private Nodo<T> primero;
    private int tam;

    public Cola() {
        primero = null;
        ultimo = null;
        tam = 0;
    }

    public int getTam() {
        return tam;
    }

    public boolean esta_vacio(){
        return primero == null;
    }

    public void encolar(T item){
        Nodo<T> ultimo_anterior = ultimo;
        ultimo = new Nodo<>();
        ultimo.item = item;
        ultimo.enlace = null;

        if (esta_vacio()){
            primero = ultimo;
        }
        else{
            ultimo_anterior.enlace = ultimo;
        }
        tam++;
    }



    public T desencolar(){
        if (esta_vacio()){
            throw new NoSuchElementException("ERROR:Cola esta vacia");
        }
        T result = primero.item;
        primero = primero.enlace;
        tam--;
        if (esta_vacio()){
            ultimo = null;
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListaIterador(primero);
    }
    private class ListaIterador implements Iterator<T>{
        private Nodo<T> actual;

        public ListaIterador(Nodo<T> actual){
            this.actual = actual;
        }


        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            T x = actual.item;
            actual = actual.enlace;
            return x;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}

package PrograAvan.Lineal;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Lista<T> implements Iterable<T>, Serializable {
    private Nodo<T> cabeza;
    private int tam;

    public Lista() {
        cabeza = null;
        tam = 0;
    }

    public boolean esta_vacia(){
        return tam == 0;
    }

    public int getTam() {
        return tam;
    }
    public void insertar(T item){
        cabeza = insertar(cabeza, item);
    }
    private Nodo insertar(Nodo x, T item){
        if (x == null){
            x = new Nodo();
            x.item = item;
            x.enlace = null;
            tam++;
            return x;
        }
        x.enlace = insertar(x.enlace, item);
        return x;
    }

    public T get(int indice){
        if (indice>= tam){
            throw new IllegalArgumentException("Indice "+indice+ " fuera de rango : "+ tam);
        }
        for (int i=0; i <indice;i++){
            cabeza = cabeza.enlace;
        }
        return cabeza.item;
    }

    public void cambiar(int p,int s){
        if (p>tam || s>tam) throw new NoSuchElementException();
        Nodo aux=cabeza;
        int auxpos=0;
        Nodo aux2=cabeza;
        int auxpos2=0;
        while(aux!=null && auxpos!=p){
            aux=aux.enlace;
            auxpos++;

        }
        while(aux2!=null && auxpos2!=s){
            aux2=aux2.enlace;
            auxpos2++;
        }

        T itemaux;
        itemaux= (T) aux.item;
        aux.item=(T) aux2.item;
        System.out.println("#"+aux.item);
        aux2.item=(T) itemaux;

    }
    public void eliminar(int p){
        if (p>tam) throw new NoSuchElementException();
        Nodo actual,anterior;
        actual=cabeza;
        anterior=null;
        int auxp=0;
        if(p==0){
            cabeza=cabeza.enlace;
            actual.enlace=null;
            tam--;
        }
        else {
            while(actual!=null)
            {
                if(auxp==p)
                {
                    anterior.enlace=actual.enlace;
                    actual.enlace=null;
                    tam--;
                    return;
                }
                anterior=actual;
                actual=actual.enlace;
                auxp++;
            }
        }

    }



    @Override
    public Iterator<T> iterator() {
        return new ListIterator(cabeza);
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
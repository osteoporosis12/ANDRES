package PrograAvan.NoLineal;

import PrograAvan.Lineal.Cola;
import PrograAvan.Lineal.Pila;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArbolBinario<Llave extends Comparable <Llave>,Valor> implements Iterable<Valor>{
    private Nodo raiz;
    private Pila <Nodo> p ;
    private Cola<Nodo> c ;
    private class Nodo{
        private Llave llave;
        private Valor valor;
        private Nodo izquierda;
        private Nodo derecho;
        private int tam;
        public int jaja;

        public Nodo(Llave llave,Valor valor,int tam){
            this.llave=llave;
            this.valor=valor;
            this.tam=tam;
        }
    }
    public ArbolBinario()
    {

    }
    public boolean estaVacio()
    {
        return raiz==null;
    }
    public int getTam()
    {
        return getTam(raiz);
    }
    public int getTam(Nodo x)
    {
        if(x==null) return 0;
        else {
            return x.tam;
        }
    }
    public Valor getElementByLlave(Llave l)
    {
        return getElementByLlave(raiz,l);
    }
    //BUSCAMOS LA LLAVE DE FORMA RECURSIVA Y TIRAMOS EL VALOR
    public Valor getElementByLlave(Nodo x,Llave l)
    {
        if(x==null) return null;
        int cmp=l.compareTo(x.llave);//compareto 1 si es mayor -1 si es menor y 0 si es igual
        if (cmp<0)
        {
            return getElementByLlave(x.izquierda,l);
        }
        else if(cmp>0){
            return getElementByLlave(x.derecho,l);
        }
        else {
            return x.valor;
        }
    }

    public void insertar(Llave l, Valor v){
        raiz=insertar(raiz,l,v);

    }
    private Nodo insertar(Nodo x,Llave l,Valor v)
    {
        if (x==null){
            return new Nodo(l,v,1);
        }

        int cmp=l.compareTo(x.llave);//compareto 1 si es mayor -1 si es menor y 0 si es igual
        if (cmp<0)
        {
            x.izquierda= insertar(x.izquierda,l,v);
        }
        else if (cmp>0){
            x.derecho= insertar(x.derecho,l,v);
        }
        else{
            throw new IllegalArgumentException();
        }

        x.tam= 1+getTam(x.izquierda)+getTam(x.derecho);
        return x;
    }

    public Llave get_min()
    {
        return get_min(raiz);
    }
    private Llave get_min(Nodo x)
    {
        if(x.izquierda==null){
            return x.llave;

        }
        return get_min(x.izquierda);
    }


    public void eliminarMin()
    {
        Nodo eliminado=eliminarMin(raiz,raiz);
        System.out.println("Se elimino a:"+eliminado.valor);
    }
    private Nodo eliminarMin(Nodo x,Nodo x1)
    {
        if(x.izquierda==null){
            if(x.derecho!=null){
                x1.izquierda=x.derecho;
                raiz.tam--;
                return x;
            }
            raiz.tam--;
            x1.izquierda=null;
            return x;

        }
        return eliminarMin(x.izquierda,x);
    }
    public void eliminarMax()
    {
        Nodo eliminado=eliminarMax(raiz,raiz);
        System.out.println("Se elimino a:"+eliminado.valor);
    }
    private Nodo eliminarMax(Nodo x,Nodo x1)
    {
        if(x.derecho==null){
            if(x.izquierda!=null){
                x1.derecho=x.izquierda;
                raiz.tam--;
                return x;
            }
            x1.derecho=null;
            raiz.tam--;
            return x;

        }
        return eliminarMax(x.derecho,x);
    }
    public Llave get_max()
    {
        return get_max(raiz);
    }
    private Llave get_max(Nodo x)
    {
        if(x.derecho==null){
            return x.llave;
        }
        return get_max(x.derecho);
    }
    public void profundidad(){
        p=new Pila<>();
        Nodo aux;
        p.empilar(raiz);
        while(!p.esta_vacia())
        {
            aux=p.desempilar();
            System.out.println(aux.llave);
            if(aux.izquierda!=null) p.empilar(aux.izquierda);
            if(aux.derecho!=null) p.empilar(aux.derecho);
        }
    }
    public void amplitud() {
        c = new Cola<>();
        Nodo aux;
        c.encolar(raiz);
        while (!c.esta_vacio()) {
            aux = c.desencolar();
            System.out.println(aux.llave);
            if (aux.izquierda != null) c.encolar(aux.izquierda);
            if (aux.derecho != null) c.encolar(aux.derecho);
        }

    }
    public Iterator<Valor> iterator(){
        return new ArbolIterator();
    }
    private class ArbolIterator implements Iterator<Valor>{

        private Nodo x;
        public ArbolIterator(){
        }
        @Override
        public boolean hasNext() {
            return raiz.tam!=0;
        }

        @Override
        public Valor next() {
            if(!hasNext())
            {
                throw new NoSuchElementException();
            }
            x=eliminarMin(raiz,raiz);
            return x.valor;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }

    }
}


import PrograAvan.Lineal.Cola;
import PrograAvan.Lineal.Pila;

public class Arbol_RN <Llave extends Comparable<Llave>,Valor>{
    private static final boolean ROJO=true;
    private static final boolean NEGRO=false;
    //Arbolazo
    private Nodo raiz;
    private Pila <Nodo> p ;
    private Cola<Nodo> c ;


    //XD

    class Nodo{
        private Llave llave;
        private Valor valor;
        private Nodo izquierdo;
        private Nodo derecho;
        private boolean color;
        private int tam;
        public Nodo(Llave l, Valor v, boolean color, int t){
            this.llave=l;
            this.valor=v;
            this.color=color;
            this.tam=t;
        }
    }

    public Arbol_RN() {
        p=new Pila<>();
        c=new Cola<>();
    }
    //Funcion para saber de que color es(Por lo general el NODO que enviamos es el hijo)
    private boolean es_rojo(Nodo x){
        if (x==null) return NEGRO;
        return x.color;
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
            return getElementByLlave(x.izquierdo,l);
        }
        else if(cmp>0){
            return getElementByLlave(x.izquierdo,l);
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
            return new Nodo(l,v,ROJO,1);
        }
        int cmp=l.compareTo(x.llave);
        if (cmp<0){
            x.izquierdo =insertar(x.izquierdo, l,v);
        }
        else {
            x.derecho =insertar(x.derecho, l, v);
        }
        //verificamos balanceo
        if(es_rojo(x.derecho) && !es_rojo(x.izquierdo))
        {
            x=rotarIzq(x);
        }
        if (es_rojo(x.izquierdo) && es_rojo(x.izquierdo.izquierdo))
        {
            x=rotarDer(x);
        }
        if (es_rojo(x.izquierdo) && es_rojo(x.derecho))
        {
            cambiarColor(x);
        }
        x.tam= 1+getTam(x.izquierdo)+getTam(x.derecho);
        return x;
    }

    private void cambiarColor(Nodo x) {
        x.color=!x.color;
        x.derecho.color=! x.derecho.color;
        x.izquierdo.color=! x.izquierdo.color;
    }

    private Nodo rotarDer(Nodo x) {
        Nodo aux=x.izquierdo;
        x.izquierdo=aux.derecho;
        aux.derecho=x;
        aux.color=aux.derecho.color;
        aux.derecho.color=ROJO;
        x.tam=getTam(x.izquierdo)+getTam(x.derecho);
        return x;
    }

    private Nodo rotarIzq(Nodo x){
        Nodo aux=x.derecho;
        x.derecho=aux.izquierdo;
        aux.izquierdo=x;
        aux.color=aux.izquierdo.color;
        aux.izquierdo.color=ROJO;
        aux.tam=x.tam;
        x.tam=getTam(x.izquierdo)+getTam(x.derecho)+1;
        return x;
    }

    public void profundidad(){

        Nodo aux;
        p.empilar(raiz);
        while(!p.esta_vacia())
        {
            aux=p.desempilar();
            System.out.println(aux.llave);
            if(aux.izquierdo!=null) p.empilar(aux.izquierdo);
            if(aux.derecho!=null) p.empilar(aux.derecho);
        }
    }
    public void amplitud(){

        Nodo aux;
        c.encolar(raiz);
        while(!c.esta_vacio())
        {
            aux=c.desencolar();
            System.out.println(aux.llave);
            if(aux.izquierdo!=null) c.encolar(aux.izquierdo);
            if(aux.derecho!=null) c.encolar(aux.derecho);
        }
    }
}

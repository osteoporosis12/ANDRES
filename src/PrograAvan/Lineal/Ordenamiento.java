package PrograAvan.Lineal;

public class Ordenamiento {
    public static void burbuja(Comparable[] a){
        Comparable aux;
        for (int i=0; i < a.length; i++){
            for (int j = i + 1; j < a.length; j++){
                if (a[i].compareTo(a[j])>0){
                    intercambiar(a, i, j);
                }
            }
        }
    }

    public static void merge_sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        merge_sort(a, aux, 0, a.length-1);
    }
    private static void merge_sort(Comparable[] a, Comparable[] aux, int ii, int is){
        if (is <= ii) return;
        int mitad = ii + (is - ii) / 2;
        merge_sort(a, aux, ii, mitad);
        merge_sort(a, aux, mitad + 1, is);
        merge(a, aux, ii, mitad, is);
    }
    private static void merge(Comparable[] a, Comparable[] aux, int ii, int mitad, int is){
        // copiar a en aux
        for (int k = ii; k <= is; k++){
            aux[k] = a[k];
        }
        // union
        int i = ii;
        int j = mitad + 1;

        for (int k = ii; k <= is; k++){
            if (i > mitad){
                a[k] = aux[j++];
            }
            else if (j > is){
                a[k] = aux[i++];
            }
            else if (aux[j].compareTo(aux[i])<0){
                a[k] = aux[j++];
            }
            else{
                a[k] = aux[i++];
            }
        }
    }

    private static void intercambiar(Object[] a, int pos1, int pos2) {
        Object aux = a[pos1];
        a[pos1] = a[pos2];
        a[pos2]= aux;
    }

}

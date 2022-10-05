package PrograAvan.NoLineal;

import java.util.Arrays;

public class Grupos02 {
    private int[] padres;
    private int num_grupos;

    public Grupos02(int n) {
        padres = new int[n];
        num_grupos = n;
        for (int i = 0; i < n; i++){
            padres[i] = i;
        }
    }

    public int getNum_grupos() {
        return num_grupos;
    }

    public int get_grupo(int p){
        while (p != padres[p]){
            p = padres[p];
        }
        return p;
    }

    public boolean conectados(int p, int q){
        return get_grupo(p) == get_grupo(q);
    }

    public void conectar(int p, int q){
        int raiz_p = get_grupo(p);
        int raiz_q = get_grupo(q);
        if (raiz_p == raiz_q){
            return;
        }
        padres[raiz_p] = raiz_q;
        num_grupos--;
    }

    @Override
    public String toString() {
        return "QuickUnion{" +
                "nodos=" + Arrays.toString(padres) +
                ", numGrupos=" + num_grupos +
                '}';
    }
}

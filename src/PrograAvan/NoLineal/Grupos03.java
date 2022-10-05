package PrograAvan.NoLineal;

public class Grupos03 {
    private int[] padres;
    private int[] tam;
    private int num_grupos;

    public Grupos03(int n) {
        num_grupos = n;
        padres = new int[n];
        for (int i = 0; i < n; i++){
            padres[i] = i;
            tam[i] = 1;
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

    public boolean conectado(int p, int q){
        return get_grupo(p) == get_grupo(q);
    }

    public void union(int p, int q){
        int raizP = get_grupo(p);
        int raizQ = get_grupo(q);
        if (raizP == raizQ){
            return;
        }
        if (tam[raizP] < tam[raizQ]){
            padres[raizP] = raizQ;
            tam[raizQ] += tam[raizP];
        }
        else{
            padres[raizQ] = raizP;
            tam[raizP] += tam[raizQ];
        }
        num_grupos--;
    }

}

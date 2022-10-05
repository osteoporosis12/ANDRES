package PrograAvan.NoLineal;

public class Grupos04 {
    private int[] padres;
    private byte[] nivel;
    private int num_grupos;

    public Grupos04(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.num_grupos = n;
        this.padres = new int[n];
        this.nivel = new byte[n];

        for (int i = 0; i < n; i++) {
            this.padres[i] = i;
            this.nivel[i] = 0;
        }
    }

    private void validar ( int buscado){
        if (buscado < 0 || buscado >= this.getNum_grupos()) {
            throw new IllegalArgumentException("Nodo no encontrado");
        }
    }

    public int get_grupo(int p){
        this.validar(p);
        while (p != padres[p]) {
            padres[p] = padres[padres[p]];
            p = padres[p];
        }
        return p;
    }

    public boolean conectados ( int p, int q){
        return get_grupo(p) == get_grupo(q);
    }

    public void conectar(int p, int q){
        int raizP = get_grupo(p);
        int raizQ = get_grupo(q);

        if (raizP == raizQ) {
            return;
        }

        if (nivel[raizP] < nivel[raizQ])
            padres[raizP] = raizQ;
        else if (nivel[raizP] > nivel[raizQ])
            padres[raizQ] = raizP;
        else {
            padres[raizQ] = raizP;
            nivel[raizP]++;
        }

        num_grupos--;
    }

    public int getNum_grupos() {
        return this.num_grupos;
    }
}

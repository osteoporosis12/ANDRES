package PrograAvan.NoLineal;

import java.util.Arrays;

public class Grupos01 {

    private int[] indices;
    private int num_grupos;

    public Grupos01(int n) {
        num_grupos = n;
        indices = new int[n];
        for (int i = 0; i < n; i++){
            indices[i] = i;
        }
    }

    public int get_grupo(int p){
        return indices[p];
    }

    public boolean conectado(int p, int q){
        return get_grupo(p) == get_grupo(q);
    }

    public void conectar(int p, int q){
        if (conectado(p, q)){
            return;
        }
        int idP = indices[p];
        for (int i = 0; i < indices.length; i++){
            if (indices[i] == idP){
                indices[i] = indices[q];
            }
        }
        num_grupos--;
    }

    public int getNum_grupos(){
        return num_grupos;
    }

    @Override
    public String toString() {
        return "Union{" +
                "nodos=" + Arrays.toString(indices) +
                ", numGrupo=" + num_grupos +
                '}';
    }
}
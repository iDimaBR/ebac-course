public class Matriz3x3 {

    private static final int[][] MATRIZ = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    public static void main(String[] args) {
        imprimir(MATRIZ);
    }

    private static void imprimir(int[][] matriz) {
        for (int[] linha : matriz) {
            imprimirLinha(linha);
        }
    }

    private static void imprimirLinha(int[] linha) {
        StringBuilder saida = new StringBuilder();

        for (int i = 0; i < linha.length; i++) {
            if (i > 0) {
                saida.append(' ');
            }
            saida.append(linha[i]);
        }

        System.out.println(saida);
    }
}
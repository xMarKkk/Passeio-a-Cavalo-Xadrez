public class PasseioDoCavalo {
    static int N; // tamanho do tabuleiro NxN
    static int[][] tabuleiro;
    static int[] movX = {2, 1, -1, -2, -2, -1, 1, 2}; // movimentos possíveis na horizontal
    static int[] movY = {1, 2, 2, 1, -1, -2, -2, -1}; // movimentos possíveis na vertical
    static boolean achouSolucao = false;

    public static void main(String[] args) {
        N = 5; // muda aqui pra testar tamanho diferente(ex.: N = 5)
        tabuleiro = new int[N][N];

        // Inicializa o tabuleiro com zeros
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                tabuleiro[i][j] = 0;

        // Começa o passeio na posição (0,0)
        tabuleiro[0][0] = 1;
        tenta(2, 0, 0);

        if (achouSolucao) {
            System.out.println("Solução encontrada:");
            imprimeTabuleiro();
        } else {
            System.out.println("Não há solução!");
        }
    }

    // Método recursivo de backtracking
    public static void tenta(int i, int x, int y) {
        if (i > N * N) {
            achouSolucao = true;
            return;
        }

        for (int m = 0; m < 8; m++) {
            int xn = x + movX[m];
            int yn = y + movY[m];

            if (movimentoValido(xn, yn)) {
                tabuleiro[xn][yn] = i;
                tenta(i + 1, xn, yn);

                if (achouSolucao) return;

                // backtrack se não der bom
                tabuleiro[xn][yn] = 0;
            }
        }
    }

    // Verifica se a posição tá dentro do tabuleiro e não foi visitada ainda
    public static boolean movimentoValido(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && tabuleiro[x][y] == 0;
    }

    // Imprime o tabuleiro formatado
    public static void imprimeTabuleiro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%2d ", tabuleiro[i][j]);
            }
            System.out.println();
        }
    }
}

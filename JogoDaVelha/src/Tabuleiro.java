
class Tabuleiro {
    private char[][] matriz;

    public Tabuleiro() {
        matriz = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = '-';
            }
        }
    }

    public void exibir() {
        System.out.println("\nTabuleiro Atual:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean realizarJogada(int linha, int coluna, char simbolo) {
        if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && matriz[linha][coluna] == '-') {
            matriz[linha][coluna] = simbolo;
            return true;
        }
        return false;
    }

    public boolean verificarVencedor(char simbolo) {
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0] == simbolo && matriz[i][1] == simbolo && matriz[i][2] == simbolo) {
                return true; // Linha
            }
            if (matriz[0][i] == simbolo && matriz[1][i] == simbolo && matriz[2][i] == simbolo) {
                return true; // Coluna
            }
        }
        return (matriz[0][0] == simbolo && matriz[1][1] == simbolo && matriz[2][2] == simbolo) || 
               (matriz[0][2] == simbolo && matriz[1][1] == simbolo && matriz[2][0] == simbolo); // Diagonais
    }
}

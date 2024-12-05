import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogadorX = new Jogador('X');
        Jogador jogadorO = new Jogador('O');
        Scanner scanner = new Scanner(System.in);

        Jogador jogadorAtual = jogadorX;
        boolean vencedor = false;
        int jogadas = 0;

        System.out.println("Bem-vindo ao Jogo da Velha!");
        System.out.println("Insira as coordenadas no formato linha e coluna (1-3).");

        while (!vencedor && jogadas < 9) {
            tabuleiro.exibir();

            System.out.println("Jogador '" + jogadorAtual.getSimbolo() + "', faça sua jogada.");
            System.out.print("Linha (1-3): ");
            int linha = scanner.nextInt() - 1;
            System.out.print("Coluna (1-3): ");
            int coluna = scanner.nextInt() - 1;

            if (tabuleiro.realizarJogada(linha, coluna, jogadorAtual.getSimbolo())) {
                jogadas++;
                vencedor = tabuleiro.verificarVencedor(jogadorAtual.getSimbolo());
                if (!vencedor) {
                    jogadorAtual = (jogadorAtual == jogadorX) ? jogadorO : jogadorX;
                }
            } else {
                System.out.println("Jogada inválida! Tente novamente.");
            }
        }

        tabuleiro.exibir();

        if (vencedor) {
            System.out.println("Parabéns! O jogador '" + jogadorAtual.getSimbolo() + "' venceu!");
        } else {
            System.out.println("O jogo terminou em empate!");
        }

        scanner.close();
    }
}
package ui;

import time.Time;
import opcoes.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner teclado;
    ServiceOpcoes opcoes;

    public Menu() {

        String linha;
        int opcao = -1;
        opcoes = new ServiceOpcoes();
        System.out.println("service opcoes inicializado");

        teclado = new Scanner(System.in);

        try {

            do {
                Opcoes.mostrarOpcoes();
                opcao = teclado.nextInt();

                if (opcao < 0 || opcao >= Opcoes.values().length) {
                    throw new InputMismatchException();
                }

                if (Opcoes.values()[opcao] == Opcoes.MOSTRAR_TABELA) {

                    ServiceOpcoes.imprimirTabela();
                }

                if (Opcoes.values()[opcao] == Opcoes.ADICIONAR_TIME) {
                    String[] valores = new String[9];

                    System.out.println("Digite as seguintes informacoes do time:");
                    System.out.print("Nome: ");
                    valores[0] = teclado.nextLine();
                    System.out.print("Pontos: ");
                    valores[1] = teclado.nextLine();
                    System.out.print("Qtd. jogos: ");
                    // Limitar cascata de jogos
                    valores[2] = teclado.nextLine();
                    System.out.print("Qtd. vitorias:");
                    valores[3] = teclado.nextLine();
                    System.out.print("Qtd. empates: ");
                    valores[4] = teclado.nextLine();
                    System.out.print("Qtd. derrotas: ");
                    valores[5] = teclado.nextLine();
                    System.out.print("Qtd. GP: ");
                    valores[7] = teclado.nextLine();
                    System.out.print("Qtd. GC: ");
                    valores[8] = teclado.nextLine();

                    ServiceOpcoes.adicionarTime(new Time(valores));
                }

            } while (opcao != 0);

        } catch (InputMismatchException e) {
            System.out.println("\nOpcao invalida.\n");
            teclado.nextLine();
        }

        System.out.println("Programa encerrado!");
    }
}

package ui;

import time.Time;
import opcoes.Opcoes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final String caminhoArquivo;
    private BufferedReader in;
    private Scanner teclado;

    public Menu() {

        String linha;
        int opcao = -1;
        teclado = new Scanner(System.in);
        caminhoArquivo = "src\\arquivotabela\\tabela_brasileirao.csv";
        List<Time> listaTimes = new ArrayList<Time>();

        try {

            in = new BufferedReader(new FileReader(caminhoArquivo));

            int i = 0;
            while ((linha = in.readLine()) != null) { // Faz a leitura do arquivo
                String[] valores = linha.split(",");

                if (i != 0) {
                    listaTimes.add(new Time(valores));
                } else {
                    i = 1;
                }
            }

            do {
                Opcoes.mostrarOpcoes();
                opcao = teclado.nextInt();

                if (opcao < 0 || opcao >= Opcoes.values().length) {
                    throw new InputMismatchException();
                }

                if (Opcoes.values()[opcao] == Opcoes.MOSTRAR_TABELA) {

                    Opcoes.imprimirTabela();
                }

                if (Opcoes.values()[opcao] == Opcoes.ADICIONAR_TIME) {
                    System.out.println("");
                }

            } while (opcao != 0);

        } catch (IOException e) {
            System.out.println("\nNao foi possivel abrir o arquivo no caminho: " + caminhoArquivo);
        } catch (InputMismatchException e) {
            System.out.println("\nOpcao invalida.\n");
            teclado.nextLine();
        }
        //}while(opcao != 0);

        System.out.println("Programa encerrado!");
    }

    /*public void imprimirTabela(List<Time> listaTimesinterno) {

        // Cabeçalho da tabela
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("%-21s%-7s%-5s%-5s%-5s%-4s%-7s%-5s%-5s%-12s%n",
                "Time", "Pts", "J", "V", "E", "D", "Saldo", "GP", "GC", "Rend.");
        System.out.println("----------------------------------------------------------------------");

        for (Time time : listaTimesinterno) {
            System.out.printf("%-21s%-7d%-5d%-5d%-5d%-5d%-6d%-5d%-5d%-12.2f%n",
                    time.getNome(), time.getPontos(), time.getJogos(), time.getVitorias(),
                    time.getEmpates(), time.getDerrotas(), time.getSaldo(), time.getGp(),
                    time.getGc(), time.getRendimento());
        }

        System.out.println("----------------------------------------------------------------------");
    }*/
}

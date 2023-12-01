package opcoes;

import time.Time;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class ServiceOpcoes {

    String caminhoArquivo, caminhoArquivoSaida;
    static List<Time> listaTimes;
    private BufferedReader in;
    String linha;

    public ServiceOpcoes() {
        caminhoArquivo = "src/arquivostabelas/tabela_brasileirao.csv";
        caminhoArquivoSaida = "src/arquivostabelas/tabela_brasileirao_out.csv";

        listaTimes = new ArrayList<Time>();

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

            in.close();

        } catch (IOException e) {
            System.out.println("\nNao foi possivel encontrar o arquivo no caminho: " + caminhoArquivo);
        }
    }

    public static void adicionarTime(Time time) {
        listaTimes.add(time);
    }

    public static void removerTime(Time time) { listaTimes.remove(time); }

    public static void registrarPartida(Time timeUm, Time timeDois, int golsUm, int golsDois) {
        timeUm.adicionarPartida(golsUm, golsDois);
        timeDois.adicionarPartida(golsDois, golsUm);
    }

    public static boolean timeExiste(String nomeTime) {
        for (Time time : listaTimes) {
            if(time.getNome().equalsIgnoreCase(nomeTime))
                return true;
        }

        return false;
    }

    public static Time getTime(String nomeTime) {
        for (Time time : listaTimes) {
            if(time.getNome().equalsIgnoreCase(nomeTime))
                return time;
        }
        return null;
    }

    public static void imprimirTabela() {

        // Garante que a lista seja ordenada pela pontuação do maior para o menor
        Collections.sort(listaTimes, Comparator.comparingInt(Time::getPontos).reversed());

        // Cabeçalho da tabela
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("%-21s%-7s%-5s%-5s%-5s%-4s%-7s%-5s%-5s%-12s%n",
                "Time", "Pts", "J", "V", "E", "D", "Saldo", "GP", "GC", "Rend.");
        System.out.println("----------------------------------------------------------------------");

        for (Time time : listaTimes) {
            System.out.printf("%-21s%-7d%-5d%-5d%-5d%-5d%-6d%-5d%-5d%-12.2f%n",
                    time.getNome(), time.getPontos(), time.getJogos(), time.getVitorias(),
                    time.getEmpates(), time.getDerrotas(), time.getSaldo(), time.getGp(),
                    time.getGc(), time.getRendimento());
        }

        System.out.println("----------------------------------------------------------------------");
    }
}

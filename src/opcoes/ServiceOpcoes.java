package opcoes;

import time.Time;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServiceOpcoes {

    String caminhoArquivo;
    static List<Time> listaTimes;
    private BufferedReader in;
    String linha;

    public ServiceOpcoes() {
        caminhoArquivo = "src/arquivotabela/tabela_brasileirao.csv";

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
        }catch(IOException e) {
            System.out.println("\nNao foi possivel abrir o arquivo no caminho: " + caminhoArquivo);
        }
    }

    public static void adicionarTime(Time time) {
        listaTimes.add(time);
    }

    public void registrarPartida(Time timeUm, Time timeDois, int golsUm, int golsDois){
        if(golsUm > golsDois){
            timeUm.setVitorias(timeUm.getVitorias() + 1);
            timeDois.setDerrotas(timeDois.getDerrotas() + 1);
            return;
        }
        if(golsUm < golsDois){
            timeDois.setVitorias(timeDois.getVitorias() + 1);
            timeUm.setDerrotas(timeUm.getDerrotas() + 1);
            return;
        }
        timeUm.setEmpates(timeUm.getEmpates() + 1);
        timeDois.setEmpates(timeDois.getEmpates() + 1);
    }

    public static void imprimirTabela() {

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
package opcoes;

import time.Time;

import java.util.List;

public class ServiceOpcoes {

    private List<Time> times;

    public ServiceOpcoes(List<Time> times) {
        this.times = times;
    }

    public void adicionarTime(Time time){
        times.add(time);
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

    public void imprimirTabela() {

        // Cabeçalho da tabela
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("%-21s%-7s%-5s%-5s%-5s%-4s%-7s%-5s%-5s%-12s%n",
                "Time", "Pts", "J", "V", "E", "D", "Saldo", "GP", "GC", "Rend.");
        System.out.println("----------------------------------------------------------------------");

        for (Time time : times) {
            System.out.printf("%-21s%-7d%-5d%-5d%-5d%-5d%-6d%-5d%-5d%-12.2f%n",
                    time.getNome(), time.getPontos(), time.getJogos(), time.getVitorias(),
                    time.getEmpates(), time.getDerrotas(), time.getSaldo(), time.getGp(),
                    time.getGc(), time.getRendimento());
        }

        System.out.println("----------------------------------------------------------------------");
    }
}

package opcoes;

import time.Time;

import java.util.List;

public enum Opcoes {
    SAIR("Sair"),
    ADICIONAR_TIME("Adicionar time"),
    REMOVER_TIME("Remover time"),
    REGISTRAR_PARTIDA("Registrar partida"),
    MOSTRAR_TABELA("Mostrar tabela");

    public static void imprimirTabela(List<Time> listaTimesinterno) {

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
    }

    private final String descricao;

    Opcoes(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static void mostrarOpcoes() {
        int i = 0;
        System.out.println("Opcoes:");
        for (Opcoes opcao : values()) {
            System.out.println(i + ". " + opcao.getDescricao());
            i++;
        }
        System.out.print("Escolha uma das opcoes acima: ");
    }
}

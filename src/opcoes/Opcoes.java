package opcoes;

public enum Opcoes {
    SAIR("Sair"),
    ADICIONAR_TIME("Adicionar time"),
    REGISTRAR_PARTIDA("Registrar partida"),
    MOSTRAR_TABELA("Mostrar tabela");

    private final String descricao;

    Opcoes(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static void mostrarOpcoes() {
        int i = 0;
        for (Opcoes opcao : values()) {
            System.out.println(i + ". " + opcao.getDescricao());
            i++;
        }
        System.out.print("Escolha uma das opcoes acima: ");
    }
}

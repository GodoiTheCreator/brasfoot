package time;

public class Time {

    private String nome;
    private int pontos, jogos, vitorias, empates, derrotas, saldo, gp, gc;
    private double rendimento;

    public Time(String[] valores) {
        this.nome = valores[0];
        this.pontos = Integer.parseInt(valores[1]);
        this.jogos = Integer.parseInt(valores[2]);
        this.vitorias = Integer.parseInt(valores[3]);
        this.empates = Integer.parseInt(valores[4]);
        this.derrotas = Integer.parseInt(valores[5]);
        //this.saldo = Integer.parseInt(valores[6]);
        this.saldo = Integer.parseInt(valores[7]) - Integer.parseInt(valores[8]);
        this.gp = Integer.parseInt(valores[7]);
        this.gc = Integer.parseInt(valores[8]);
        this.rendimento = (double) (pontos /((double) jogos * 3));
    }

    /*public Time(String nome, int pontos, int jogos, int vitorias, int empates, int derrotas, int saldo, int gp, int gc, double rendimento) {
        this.nome = nome;
        this.pontos = pontos;
        this.jogos = jogos;
        this.vitorias = vitorias;
        this.empates = empates;
        this.derrotas = derrotas;
        this.saldo = saldo;
        this.gp = gp;
        this.gc = gc;
        this.rendimento = rendimento;
    }*/

    public Time(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.jogos = 0;
        this.saldo = 0;
        this.gp = 0;
        this.gc = 0;
        this.rendimento = 0;
    }

    public void adicionarPartida(int golsPRO, int golsContra) {

        if(golsPRO > golsContra) {
            this.pontos += 3;
            this.vitorias++;
        }
        else if(golsPRO < golsContra){
            this.derrotas++;
        }
        else {
            this.pontos++;
            this.empates++;
        }

        this.jogos++;
        this.gp += golsPRO;
        this.gc += golsContra;
        this.saldo = this.gp - this.gc;
        this.rendimento = (double) this.pontos / (this.jogos * 3);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getGp() {
        return gp;
    }

    public void setGp(int gp) {
        this.gp = gp;
    }

    public int getGc() {
        return gc;
    }

    public void setGc(int gc) {
        this.gc = gc;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    @Override
    public String toString() {
        return "time.Time{" +
                "nome='" + nome + '\'' +
                ", pontos=" + pontos +
                ", jogos=" + jogos +
                ", vitorias=" + vitorias +
                ", empates=" + empates +
                ", derrotas=" + derrotas +
                ", saldo=" + saldo +
                ", gp=" + gp +
                ", gc=" + gc +
                ", rendimento=" + rendimento +
                '}';
    }
}

public class Partida {

    private Time timeUm, timeDois;
    private int golsTimeUm, golsTimeDois;

    public Partida(Time timeUm, Time timeDois, int golsTimeUm, int golsTimeDois) {
        this.timeUm = timeUm;
        this.timeDois = timeDois;
        this.golsTimeUm = golsTimeUm;
        this.golsTimeDois = golsTimeDois;
    }

    public void atualizarResultado(){
        if(this.golsTimeUm > this.golsTimeDois){
            this.timeUm.setVitorias(this.timeUm.getVitorias()+1);
            this.timeDois.setDerrotas(this.timeDois.getDerrotas()+1);
            return;
        } else if(this.golsTimeUm < this.golsTimeDois){
            this.timeDois.setVitorias(this.timeDois.getVitorias()+1);
            this.timeUm.setDerrotas(this.timeUm.getDerrotas()+1);
            return;
        }
        this.timeUm.setEmpates(this.timeUm.getEmpates()+1);
        this.timeDois.setEmpates(this.timeDois.getEmpates()+1);
        return;
    }


}

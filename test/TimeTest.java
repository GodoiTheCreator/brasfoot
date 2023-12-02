import org.junit.Test;
import time.Time;

import static org.junit.Assert.assertEquals;

public class TimeTest {

    @Test
    public void testeAdicionarPartida() {
        String[] valoresTime = {"Time A", "0", "0", "0", "0", "0", "0", "0", "0"};
        Time time = new Time(valoresTime);

        // Adicionando uma partida e verificando se os valores são atualizados corretamente
        time.adicionarPartida(2, 1); // Simulando uma partida com 2 gols a favor e 1 contra

        assertEquals(3, time.getPontos());
        assertEquals(1, time.getVitorias());
        assertEquals(1, time.getJogos());
        assertEquals(2, time.getGp());
        assertEquals(1, time.getGc());
        assertEquals(1, time.getSaldo());
        assertEquals(1.0, time.getRendimento(), 0.01);
    }

    @Test
    public void testNovoTime() {
        String nomeTime = "Novo Time";
        Time time = new Time(nomeTime);

        // Verifica se os valores iniciais do novo time foram configurados corretamente
        assertEquals(nomeTime, time.getNome());
        assertEquals(0, time.getPontos());
        assertEquals(0, time.getVitorias());
        assertEquals(0, time.getJogos());
        assertEquals(0, time.getGp());
        assertEquals(0, time.getGc());
        assertEquals(0, time.getSaldo());
        assertEquals(0.0, time.getRendimento(), 0.01);
    }

}

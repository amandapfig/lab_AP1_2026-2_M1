import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EquipeTest {
    //Arrange
    Equipe equipeA;
    Equipe equipeB;
    PartidaDeVolei PartidaDeVolei;
    @BeforeEach 
    void criarUmaPartida(){
        equipeA = new Equipe("Brasil");
        equipeB= new Equipe("Espanha");
        PartidaDeVolei= new PartidaDeVolei(equipeA, equipeB);
    }
    
    @Test 
    void registraPartidaCorretamente(){
        //ACT
        int partida=equipeA.registrarPartida(PartidaDeVolei);

        //ASSERT
        assertEquals(partida, 1);
    }

    @Test
    void calculaAproveitamentoTotalCorretamente() {
        //ARRANGE
        PartidaDeVolei.registrarPlacarSet(25, 23);
        PartidaDeVolei.registrarPlacarSet(26, 24);
        PartidaDeVolei.registrarPlacarSet(21, 25);
        PartidaDeVolei.registrarPlacarSet(25, 19);
        equipeA.registrarPartida(PartidaDeVolei);
        //ACT 
        double aproveitamento = equipeA.aproveitamentoTotal();
        //ASSERT
        assertEquals(aproveitamento, Double.MAX_VALUE, 0.01);
    }

    @Test
    void calculaAproveitamentoSetsCorretamente() {
        //ARRANGE
        PartidaDeVolei.registrarPlacarSet(25, 0);
        PartidaDeVolei.registrarPlacarSet(25, 0);
        PartidaDeVolei.registrarPlacarSet(25, 0);
         equipeA.registrarPartida(PartidaDeVolei);
        //ACT
        double setsGanhos = equipeA.aproveitamentoSets();
        //ASSERT
        assertEquals(setsGanhos, Double.MAX_VALUE, 0.01);
    }   
}
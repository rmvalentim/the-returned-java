/*
********************************************************************************************************
* Desenvolvido por: Rafael Moraes Valentim - rmoraesvalentim@gmail.com                                 *
********************************************************************************************************
* Jogo desenvolvido durante a realização do Trabalho de Conclusão de Curso                             *
* no Instituto Federal de Educação, Ciência e Tecnologia de São Paulo - Campus São João da Boa Vista   *
* como requisito para a obtenção do título de Tecnologo em Sistemas para Internet                      *
******************************************************************************************************** 
*/
package jogo2d;

import jplay.Keyboard;
import jplay.Scene;
import jplay.Sound;
import jplay.Time;
import jplay.Window;

/**
 *
 * @author Rafael.Valentim
 */
public class Cenario0 extends Cenario{
    private Window janela;
    private Scene cena;
    private Jogador jogador;
    private Keyboard teclado;
    private Time tempo = new Time(0,5,0, 340, 27, false);
    Sound s;
    
    
    // Cria a cena, carrega o Arquivo .scn que contém o mapa e cria o jogador
    public Cenario0( Window window){
        
        janela = window;
        cena = new Scene();
        cena.loadFromFile("src/recursos/scn/Cenario0.scn");
        jogador = new Jogador(400,400);
        teclado = janela.getKeyboard();
        
        s = new Sound("src/recursos/audio/home.wav");
        s.setRepeat(true);
        s.play();
        
        run();
    }
    
    // Método contendo o Loop onde o jogo corre no Cenario 0
    private void run() {
        while(true){
            
            if(tempo.getTotalSecond() <= 0){
                s.stop();
                new TempoEsgotado(janela);
            }
            
            cena.moveScene(jogador);
            
            jogador.mover(janela, teclado);
            jogador.caminho(cena);
                        
            jogador.x += cena.getXOffset();
            jogador.y += cena.getYOffset();
            
            jogador.energia(janela);
            
            tempo.draw();
            
            jogador.draw();
            janela.update();
            
            mudarCenario();
        }
    }
    
    private void mudarCenario(){
        // Se o jogador colidir com o tile 11 ou 12
        // ele vai para o cenario 1
        if((tileCollision(11, jogador, cena) == true) ||
                (tileCollision(12, jogador, cena) == true)){
            //Som.stop();
            s.stop();
            new Cenario1(janela, jogador.energia, tempo.getMinute(), tempo.getSecond());
        }
    }
}

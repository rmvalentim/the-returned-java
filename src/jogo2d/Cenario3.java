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

import java.util.Random;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Sound;
import jplay.Time;
import jplay.Window;

/**
 *
 * @author Rafael.Valentim
 */
public class Cenario3 extends Cenario {
    private Window janela;
    private Scene cena;
    private Jogador jogador;
    private Keyboard teclado;
    private Inimigo[] array;
    private Time tempo = new Time(0,0,0, 340, 27, false);
    private Random random = new Random();
    private int xMinimo = 70;
    private int xMaximo = 1000;
    private int yMinimo = 350;
    private int yMaximo = 700;
    private static final int INIMIGOS = 10;
    Sound s;
    
    // Cria a cena, carrega o Arquivo .scn que contém o mapa e cria o jogadore e inimigos
    public Cenario3( Window window, double energ, long minutos, long segundos){
        
        janela = window;
        array = new Inimigo[INIMIGOS];
        for(int i = 0; i < INIMIGOS; i++){
            array[i] = new Inimigo((random.nextInt((xMaximo - xMinimo) + 1) + xMinimo),(random.nextInt((yMaximo - yMinimo) + 1) + yMinimo), janela);
        }
        
        tempo.setMinute((int) minutos);
        tempo.setSecond((int) segundos);
        
        cena = new Scene();
        cena.loadFromFile("src/recursos/scn/Cenario3.scn");
        jogador = new Jogador(30,440);
        jogador.energia = energ;
        teclado = janela.getKeyboard();
        
        s = new Sound("src/recursos/audio/horror.wav"); 
        s.setRepeat(true);
        s.play();
        
        run();
    }
    
    // Método contendo o Loop onde o jogo corre no Cenario 1
    private void run() {
        while(true){
            
            if(tempo.getTotalSecond() <= 0){
                s.stop();
                new TempoEsgotado(janela);
            }
            
            jogador.mover(janela, teclado);
            jogador.caminho(cena);
            
            for(int i = 0; i < INIMIGOS; i++){
                array[i].caminho(cena);
                array[i].perseguir(jogador.x, jogador.y);
            }
            
            cena.moveScene(jogador);
            
            jogador.x += cena.getXOffset();
            jogador.y += cena.getYOffset();
            
          for(int i = 0; i < INIMIGOS; i++){
                jogador.atirar(janela, cena, teclado, array[i]);
            }
            
            for(int i = 0; i < INIMIGOS; i++){
                array[i].morrer();
                array[i].atacar(jogador, s);
            } 
            
            jogador.energia(janela);
            tempo.draw();
            
            for(int i = 0; i < INIMIGOS; i++){
                array[i].x += cena.getXOffset();
                array[i].y += cena.getYOffset();
            }  
            
            jogador.draw();
            
            for(int i = 0; i < INIMIGOS; i++){
                array[i].draw();
            }
            
            janela.update();
            
            mudarCenario();
        }
    }
    
    private void mudarCenario(){
        // Se o jogador colidir com o tile 8, 9, 10 ou 11
        // ele vai para o cenario 2
        if(tileCollision(8, jogador, cena) == true ||
                tileCollision(9, jogador, cena) == true ||
                tileCollision(10, jogador, cena) == true ||
                tileCollision(11, jogador, cena) == true) {
           
           // FIM DE JOGO 
           s.stop();
           new Creditos(janela, jogador.energia, tempo.getMinute(), tempo.getSecond());
            
        }
    }
}

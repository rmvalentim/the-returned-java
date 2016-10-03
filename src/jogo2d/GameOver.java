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

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

/**
 *
 * @author Rafael.Valentim
 */
public class GameOver {
    
    GameImage plano = new GameImage("src/recursos/sprites/game_over.png");
    private Window janela;
    private Keyboard teclado;
   
    public GameOver( Window window){
        janela = window;
        teclado = janela.getKeyboard();
        plano.draw();
        janela.update();
        
        Som.play("src/recursos/audio/game_over.wav");
            
        while(true){
           
            if(teclado.keyDown(Keyboard.ENTER_KEY)){
                new Cenario0(janela);
            }
            
            if(teclado.keyDown(Keyboard.ESCAPE_KEY)){
                System.exit(0);                
            }
        }
    }   
}

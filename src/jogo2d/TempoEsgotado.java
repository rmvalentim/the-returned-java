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
public class TempoEsgotado {
    GameImage plano = new GameImage("src/recursos/sprites/tempo_esgotado.png");
    private Window janela;
    private Keyboard teclado;
   
    public TempoEsgotado( Window window){
        janela = window;
        teclado = janela.getKeyboard();
        plano.draw();
        janela.update();
        
        Som.play("src/recursos/audio/explosao.wav");
            
        while(true){
           
            // Recomeça o jogo
            if(teclado.keyDown(Keyboard.ENTER_KEY)){
                new Cenario0(janela);
            }
            
            // Sai do jogo
            if(teclado.keyDown(Keyboard.ESCAPE_KEY)){
                System.exit(0);                
            }
        }
    } 
}

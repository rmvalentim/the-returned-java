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

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Time;
import jplay.Window;

/**
 *
 * @author Rafael.Valentim
 */
public class Creditos {
    GameImage plano = new GameImage("src/recursos/sprites/creditos.png");
    private Window janela;
    private Keyboard teclado;
      
    public Creditos( Window window, double energ, long minutos, long segundos){
        janela = window;
        teclado = janela.getKeyboard();
        
        plano.draw();
        janela.update();
        
        Som.play("src/recursos/audio/win.wav");
        
        while(true){
           
            // Reinicia o jogo
            if(teclado.keyDown(Keyboard.ENTER_KEY)){
                new Cenario0(janela);
            }
            
            // Encerra o jogo
            if(teclado.keyDown(Keyboard.ESCAPE_KEY)){
                System.exit(0);                
            }
        }
    } 
}

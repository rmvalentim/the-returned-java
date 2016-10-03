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
 * @author rafae
 */
public class Submenu {
    GameImage plano = new GameImage("src/recursos/sprites/submenu.png");
    private Window janela;
    private Keyboard teclado;
   
    public Submenu( Window window){
        janela = window;
        teclado = janela.getKeyboard();
        plano.draw();
        janela.update();
                    
        while(true){
           
            // Inicia o jogo no Cenario 0.
            // quando a tecla ENTER é pressionada.
            if(teclado.keyDown(Keyboard.ENTER_KEY)){
                new Cenario0(janela);
                
            }
            
            // Sai do jogo quando a tecla ESC é pressionada.
            if(teclado.keyDown(Keyboard.ESCAPE_KEY)){
                System.exit(0);                
            
            }
        }
    } 
}

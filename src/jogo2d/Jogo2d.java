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
public class Jogo2d {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        // Cria janela onde o jogo vai acontecer com o tamanho de 800x600 pixels.
        Window janela = new Window(800,600);
        janela.setFullScreen();
        
        // Cria um plano, e define uma imagem para o menu inicial do jogo.
        GameImage plano = new GameImage("src/recursos/sprites/menu.png");
        
        // Cria um objeto que detecta quando uma tecla é apertada no teclado.
        Keyboard teclado = janela.getKeyboard();
        
        //Loop do jogo
        while(true){
        
            plano.draw();
            janela.update();
            
            // Direciona para o Submenu (Anterior ao inicio da partida)
            // quando a tecla ENTER é pressionada.
            if(teclado.keyDown(Keyboard.ENTER_KEY)){
                new Submenu(janela);
            }
            
            // Sai do jogo quando a tecla ESC é pressionada.
            if(teclado.keyDown(Keyboard.ESCAPE_KEY)){
                System.exit(0);                
            }
        }
    }
}
    


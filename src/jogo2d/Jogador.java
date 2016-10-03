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
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import jplay.Keyboard;
import jplay.Window;
import jplay.Scene;

/**
 *
 * @author Rafael.Valentim
 */
public class Jogador extends Ator{
    
    public Jogador(int x, int y) {
        super ("src/recursos/sprites/jogador.png", 20);
        this.x = x;
        this.y = y;
        this.setTotalDuration(2000);
    }
    
    ControleTiros tiros = new ControleTiros();
    public void atirar(Window janela, Scene cena, Keyboard teclado, Ator inimigo){
        if(teclado.keyDown(KeyEvent.VK_SPACE)){
            tiros.adicionaTiro(x + 5, y + 12, direcao, cena);
        }
        tiros.run(inimigo);
    }
    
    public void mover(Window janela, Keyboard teclado){
        
        
            if(teclado.keyDown(Keyboard.ESCAPE_KEY)){
                System.exit(0);                
            }

            // Tecla Esquerda pressionada, realiza movimentação e 
            // roda a sequencia de 4 até 8 do Sprite do personagem.
            if(teclado.keyDown(Keyboard.LEFT_KEY)){
            
                if(this.x > 0){
                    this.x -= velocidade;
                }
                if(direcao != 1){
                    setSequence(4,8);
                    direcao = 1;
                    
                }
                movendo = true;
                
            // Tecla Direita pressionada, realiza movimentação e 
            // roda a sequencia de 8 até 12 do Sprite do personagem.    
            }else  if(teclado.keyDown(Keyboard.RIGHT_KEY)){
                
                if(this.x < janela.getWidth() - 60){
                    this.x += velocidade;
                }
                if(direcao != 2){
                    setSequence(8,12);
                    direcao = 2;
                }
                movendo = true;
                
            // Tecla Cima pressionada, realiza movimentação e 
            // roda a sequencia de 12 até 16 do Sprite do personagem.
            }else  if(teclado.keyDown(Keyboard.UP_KEY)){
            
                if(this.y > 0){
                    this.y -= velocidade;
                }
                if(direcao != 4){
                    setSequence(12,16);
                    direcao = 4;
                }
                movendo = true;
                
            // Tecla Baixo pressionada, realiza movimentação e 
            // roda a sequencia de 0 até 4 do Sprite do personagem.    
            }else  if(teclado.keyDown(Keyboard.DOWN_KEY)){
              
                if(this.y < janela.getHeight() - 60){
                    this.y += velocidade;
                }
                if(direcao != 5){
                    setSequence(0,4);
                    direcao = 5;
                }
                movendo = true;
            }
            
        if(movendo){
        
            update();
            movendo = false;
        }
    }
    
    Font f = new Font("arial",Font.BOLD,20);
    
    public void energia(Window janela){
        
        Graphics g = janela.getGameGraphics();
        FontMetrics fm = g.getFontMetrics();
        
        if(this.energia >= 500){
            janela.drawText("Energia: ", 30, 27, Color.green, f);
            g.setColor( Color.green );
        }else if(this.energia <= 500 && this.energia > 200){
            janela.drawText("Energia: ", 30, 27, Color.yellow, f);
            g.setColor( Color.yellow );
        } else {
            janela.drawText("Energia: ", 30, 27, Color.red, f);
            g.setColor( Color.red );
        }     
        
        g.fillRect( 115, 10, (int) this.energia / 5, 20);
    }
}

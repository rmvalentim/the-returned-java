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
import java.awt.Graphics;
import java.util.Random;
import jplay.Sound;
import jplay.Window;

/**
 *
 * @author Rafael.Valentim
 */
public class Inimigo extends Ator{
    
    private double ataque = 1;
    private boolean somMorte = true;
    private Window janela;
    
    private int cont1;
    private int cont2;
    private boolean controle = true;
    private Random random = new Random();
    
    private int xMinimo = 70;
    private int xMaximo = 1500;
    private int yMinimo = 70;
    private int yMaximo = 1100;
    
    private int AleX;
    private int AleY;
    

    public Inimigo(int x, int y, Window window) {
        super("src/recursos/sprites/inimigo.png",16);
        this.x = x;
        this.y = y;
        this.setTotalDuration(1000);
        this.velocidade = 0.3;
        this.janela = window;
    }
    
    @Override
    public void draw() {
        super.draw(); //To change body of generated methods, choose Tools | Templates.
        Graphics g = janela.getGameGraphics().create();
        g.setColor( Color.red );
        g.fillRect((int) x, (int) y-7,(int) (48*energia/1000), 7);
        g.dispose();
    }
    
    public void perseguir(double x, double y){
        
        // Perseguir o usuario por 1000 iterações.
        if(cont1 < 1000){
           cont1++;
            
            //ANDA PARA A ESQUERDA
           if(this.x > x && this.y <= y + 50 && this.y >= y - 50){
               moveTo(x, y, velocidade);
               if(direcao != 1 ){
                   setSequence(5,8);
                   direcao = 1;
               }
               movendo = true;
           }
           // ANDA PARA BAIXO
           else if(this.y < y && direcao != 2){
               moveTo(x, y, velocidade);
               if(direcao != 5){
                  setSequence(1,4);
                   direcao = 5;
               }
               movendo = true;
           }
           // ANDA PARA A DIREITA
           else if(this.x < x && this.y < y + 50 && this.y >= -50){
               moveTo(x, y, velocidade);
               if(direcao != 2){
                   setSequence(9, 12);
                   direcao = 2;
               }
               movendo = true;
           }
           // ANDA PARA CIMA
           else if(this.y > y){
               moveTo(x, y, velocidade);
               if(direcao != 4){
                   setSequence(13, 16);
                   direcao = 4;
               } 
               movendo = true;
           }

           if(movendo){
               update();
               movendo = false;
           }
        }
        
        // Andar aleatóriamente por 1000 iterações.
        if(cont2 < 1000 && cont1 == 1000){
            cont2++;
            
            if(controle){
            AleX = (random.nextInt((xMaximo - xMinimo) + 1) + xMinimo);
            AleY = (random.nextInt((yMaximo - yMinimo) + 1) + yMinimo);
            controle = false;
            }

            //ANDA PARA A ESQUERDA
           if(this.x > AleX && this.y <= AleY + 50 && this.y >= AleY - 50){
               moveTo(AleX, AleY, velocidade);
               if(direcao != 1 ){
                   setSequence(5,8);
                   direcao = 1;
               }
               movendo = true;
           }
           // ANDA PARA BAIXO
           else if(this.y < AleY && direcao != 2){
               moveTo(AleX, AleY, velocidade);
               if(direcao != 5){
                  setSequence(1,4);
                   direcao = 5;
               }
               movendo = true;
           }
           // ANDA PARA A DIREITA
           else if(this.x < AleX && this.y < AleY + 50 && this.y >= -50){
               moveTo(AleX, AleY, velocidade);
               if(direcao != 2){
                   setSequence(9, 12);
                   direcao = 2;
               }
               movendo = true;
           }
           // ANDA PARA CIMA
           else if(this.y > AleY){
               moveTo(AleX, AleY, velocidade);
               if(direcao != 4){
                   setSequence(13, 16);
                   direcao = 4;
               } 
               movendo = true;
           }

           if(movendo){
               update();
               movendo = false;
           }
        }
        // Limpa controles e reinicia a sequencia
        if(cont1 == 1000 && cont2 == 1000){
            controle = true;
            cont1 = 0;
            cont2 = 0;
        }
    }

    //Morte do Inimigo
    public void morrer() {
        if(this.energia <= 0){
            
            if(somMorte){
            Som.play("src/recursos/audio/inimigo_morte.wav");
            somMorte = false;}   
            
            this.velocidade = 0;
            this.ataque = 0;
            this.direcao = 0;
            this.movendo = false;
            this.x = 1_000_000;
            this.y = 1_000_000;
        } 
    }
    
    public void atacar(Jogador jogador, Sound s){
        //Decrementa a energia do jogador
        if(this.collided(jogador)){
            jogador.energia -= this.ataque;
        }
        // Jogador morre
        if(jogador.energia <= 0){
            s.stop();
            new GameOver(janela);
        }
    }
}

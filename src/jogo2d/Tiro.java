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

import jplay.Sprite;

/**
 *
 * @author Rafael.Valentim
 */
public class Tiro extends Sprite{
    
    public static final int LEFT = 1, RIGHT = 2, STOP = 3, UP = 4, DOWN = 5;
    
    protected static final int VELOCIDADE_TIRO = 1;
    protected int caminho = STOP;
    protected boolean movendo = false;
    protected int direcao = 3;
    
    public Tiro(double x, double y, int caminho){
        super("src/recursos/sprites/flecha.png",12);
        this.caminho = caminho;
        this.x = x;
        this.y = y;
    }
    
    public void mover(){
        if(caminho == LEFT){
            this.x -= VELOCIDADE_TIRO;
            if(direcao != 1){
                setSequence(3,6);
            }
            movendo = true;
        }
        if(caminho == RIGHT){
            this.x += VELOCIDADE_TIRO;
            if(direcao != 2){
                setSequence(6,9);
            }
            movendo = true;
        }
        if(caminho == UP){
            this.y -= VELOCIDADE_TIRO;
            if(direcao != 4){
                setSequence(9,12);
            }
            movendo = true;
        }
        if(caminho == DOWN || caminho == STOP){
            this.y += VELOCIDADE_TIRO;
            if(direcao != 5){
                setSequence(0,3);
            }
            movendo = true;
        }
        if(movendo = true){
            update();
            movendo = false;
        }
    }

    boolean collided() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

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

import java.util.LinkedList;
import jplay.Scene;
import jplay.Sound;

/**
 *
 * @author Rafael.Valentim
 */
public class ControleTiros {
    LinkedList<Tiro> tiros = new LinkedList<>();
    
    public void adicionaTiro(double x, double y, int caminho, Scene cena){
        Tiro tiro = new Tiro(x, y, caminho);
        tiros.addFirst(tiro);
        cena.addOverlay(tiro);
        somDisparo();
    }
    
    public void run(Ator inimigo){
        for (int i = 0; i < tiros.size(); i++) {
            Tiro tiro = tiros.removeFirst();
            tiro.mover();
            tiros.addLast(tiro);
            
            if(tiro.collided(inimigo)){
            tiro.x = 10_000_000;
            tiro.y = 10_000_000;
            inimigo.energia -= 125;
            }
        }
    }
    
    private void somDisparo(){
               
        Som.play("src/recursos/audio/tiro.wav");
    }
}

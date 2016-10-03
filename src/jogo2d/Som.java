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

import jplay.Sound;

/**
 *
 * @author Rafael.Valentim
 */
public class Som {
    
    private static Sound musica;
    
    public static void play(String audio){
    
        musica = new Sound(audio);
        
        Som.musica.play();
        Som.musica.setRepeat(false);
    }
    
    public static void stop(){
        
        Som.musica.stop();
        
        /*if(Som.musica != null){
        
            Som.musica.stop();
        }*/
    }
}

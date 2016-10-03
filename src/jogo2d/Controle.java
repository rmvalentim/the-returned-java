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

import jplay.GameObject;
import jplay.TileInfo;

/**
 *
 * @author Rafael.Valentim
 */
public class Controle {
    
    // Controle se o tile é transponivel através de sua numeração
    public boolean colisao(GameObject obj, TileInfo tile){
    
        if((tile.id >= 500) && (obj.collided(tile)) ){
        return true;
        }
    return false;
    }
}


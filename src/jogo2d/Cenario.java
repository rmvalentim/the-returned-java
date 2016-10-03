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

import java.awt.Point;
import java.util.Vector;
import jplay.GameObject;
import jplay.Scene;
import jplay.TileInfo;

/**
 *
 * @author Rafael.Valentim
 */
public abstract class Cenario {
    
    protected boolean tileCollision(int value, Jogador jogador, Scene cena){
        Point min = new Point((int) jogador.x, (int) jogador.y);
        Point max = new Point((int) (jogador.x + jogador.width), (int) (jogador.y + jogador.height));
        Vector<?> tiles = cena.getTilesFromPosition(min, max);
        for(int i = 0; i < tiles.size(); i++){
            TileInfo tile = (TileInfo) tiles.elementAt(i);
            if(tileCollision(jogador, tile, value) == true){
                return true;
            }
        } return false;
    }
    
    private boolean tileCollision(GameObject object, TileInfo tile, int value){
        if((tile.id == value) && object.collided(tile)){
            return true;
        }
        return false;
    }
    
}

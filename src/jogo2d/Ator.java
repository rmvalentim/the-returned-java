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
import jplay.Sprite;

/**
 *
 * @author Rafael.Valentim
 */
public class Ator extends Sprite{
    
    double velocidade = 1;
    protected int direcao = 3;
    boolean movendo = false;
    
    Controle controle = new Controle();
    public double energia = 1000;

    public Ator(String fileName, int numFrames) {
        super(fileName, numFrames);
    }

// Metodo que controla bloqueio de travessia de Tiles
    
    public void caminho(Scene cena) {
    
        Point min = new Point((int)this.x,(int) this.y);
        Point max = new Point((int)this.x + this.width,(int) this.y + this.height);
        
        Vector<?>tiles = cena.getTilesFromPosition(min, max);
        
        for(int i = 0; i < tiles.size(); i++){
        
            TileInfo tile = (TileInfo) tiles.elementAt(i);
            
            if(controle.colisao(this, tile) == true){
            
                if(colisaoVertical(this, tile)){
                    
                    if(tile.y + tile.height - 2 < this.y){

                        this.y = tile.y + tile.height;

                    }else if(tile.y > this.y + this.height - 2){

                        this.y = tile.y - this.height;

                    }
                }
                if(colisaoHorizontal(this,tile)){
                
                    if(tile.x > this.x + this.width - 2){
                    
                        this.x = tile.x - this.width;
                    
                    } else {
                    
                        this.x = tile.x + tile.width;
                    }
                }
            }
        }
    }
    
    private boolean colisaoVertical(GameObject obj, GameObject obj2){
    
        if(obj2.x + obj2.width <= obj.x){
        
            return false;
        }
        if(obj.x + obj.width <= obj2.x){
        
            return false;
        }
    return true;
    }
    
    private boolean colisaoHorizontal(GameObject obj, GameObject obj2){
    
        if(obj2.y + obj2.height <= obj.y){
        
            return false;
        }
        if(obj.y + obj.height <= obj2.y){
        
            return false;
        }
    return true;
    }
}
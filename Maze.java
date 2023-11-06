/***
 *** Maze1～9の基底クラス
 ***/
import java.awt.*;

public abstract class Maze{
    private GameManager gm;
    
    // 生成
    public Maze(GameManager gm){
        this.gm = gm;
    }
        
     // 描画
    public abstract void draw(Graphics g);

     // 次のゲームパネル
    public abstract Maze next(int n);
}

/***
 *** Maze8
 ***/
import java.awt.*;
import java.util.ArrayList;

public class Maze_8 extends Maze{
    private GameManager gm;
    private Wall wall[] = new Wall[19];
    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private int a = 16;
    private Shop shop[] = new Shop[2];
    private ArrayList<Shop> shops = new ArrayList<Shop>();
    
    // 生成
    public Maze_8(GameManager gm){
        super(gm);
        this.gm = gm;
        wall[0] = new Wall(0, 240, a, 240);
        wall[1] = new Wall(0, 540, a, 120);
        wall[2] = new Wall(300, 600, 600, a);
        wall[3] = new Wall(600, 240, a, 480);
        wall[4] = new Wall(180, 0, 360, a);
        wall[5] = new Wall(540, 0, 120, a);
        
        wall[6] = new Wall(180, 120, 120, a);
        wall[7] = new Wall(420, 120, 120, a);
        wall[8] = new Wall(60, 240, 120, a);
        wall[9] = new Wall(480, 240, 240, a);
        wall[10] = new Wall(240, 360, 240, a);
        wall[11] = new Wall(180, 480, 120, a);

        wall[12] = new Wall(120, 60, a, 120);
        wall[13] = new Wall(480, 60, a, 120);
        wall[14] = new Wall(240, 180, a, 120);
        wall[15] = new Wall(120, 300, a, 120);
        wall[16] = new Wall(360, 420, a, 120);
        wall[17] = new Wall(480, 480, a, 240);
        wall[18] = new Wall(120, 540, a, 120);
        
        for(int i= 0; i < 19; i++){
            walls.add(wall[i]);
        }

        gm.walls = this.walls;

        shop[0] = new Shop(3, 540, 60); // モクドナルド
        shop[1] = new Shop(5, 180, 540); // 吉田家

        for(int i= 0; i < 2; i++){
            shops.add(shop[i]);
        }

        gm.shops = this.shops;
    }
        
     // 描画
     public void draw(Graphics g){
        for(Wall w:walls) w.draw(g);
        for(Shop s:shops) s. draw(g);
    }

     // 次のゲームパネル
    public Maze next(int n){
        switch(n){
            case 0 : return new Maze_5(gm);
            case 1 : // なし
            case 2 : return new Maze_9(gm);
            case 3 : return new Maze_7(gm);
            default : return this;
        }
    }
}

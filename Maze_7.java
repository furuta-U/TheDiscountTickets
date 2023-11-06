/***
 *** Maze7
 ***/
import java.awt.*;
import java.util.ArrayList;

public class Maze_7 extends Maze{
    private GameManager gm;
    private Wall wall[] = new Wall[18];
    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private int a = 16;
    private Shop shop[] = new Shop[3];
    private ArrayList<Shop> shops = new ArrayList<Shop>();
    
    // 生成
    public Maze_7(GameManager gm){
        super(gm);
        this.gm = gm;
        wall[0] = new Wall(0, 300, a, 600);
        wall[1] = new Wall(300, 600, 600, a);
        wall[2] = new Wall(600, 540, a, 120);
        wall[3] = new Wall(600, 240, a, 240);
        wall[4] = new Wall(420, 0, 120, a);
        wall[5] = new Wall(180, 0, 120, a);
        
        wall[6] = new Wall(300, 120, 120, a);
        wall[7] = new Wall(540, 120, 120, a);
        wall[8] = new Wall(180, 240, 120, a);
        wall[9] = new Wall(60, 360, 120, a);
        wall[10] = new Wall(420, 360, 120, a);

        wall[11] = new Wall(120, 120, a, 240);
        wall[12] = new Wall(360, 60, a, 120);
        wall[13] = new Wall(480, 60, a, 120);
        wall[14] = new Wall(240, 180, a, 120);
        wall[15] = new Wall(360, 360, a, 240);
        wall[16] = new Wall(240, 480, a, 240);
        wall[17] = new Wall(480, 480, a, 240);
        
        for(int i= 0; i < 18; i++){
            walls.add(wall[i]);
        }

        gm.walls = this.walls;

        shop[0] = new Shop(1, 420, 60); // RAWSON
        shop[1] = new Shop(6, 180, 180); // ムーンバックス
        shop[2] = new Shop(4, 420, 420); // ガヌト

        for(int i= 0; i < 3; i++){
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
            case 0 : return new Maze_4(gm);
            case 1 : // なし
            case 2 : return new Maze_8(gm);
            case 3 : // なし
            default : return this;
        }
    }
}

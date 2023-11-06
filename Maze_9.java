/***
 *** Maze9
 ***/
import java.awt.*;
import java.util.ArrayList;

public class Maze_9 extends Maze{
    private GameManager gm;
    private Wall wall[] = new Wall[16];
    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private int a = 16;
    private Shop shop[] = new Shop[2];
    private ArrayList<Shop> shops = new ArrayList<Shop>();
    
    // 生成
    public Maze_9(GameManager gm){
        super(gm);
        this.gm = gm;
        wall[0] = new Wall(0, 240, a, 480);
        wall[1] = new Wall(300, 600, 600, a);
        wall[2] = new Wall(600, 300, a, 600);
        wall[3] = new Wall(420, 0, 360, a);
        wall[4] = new Wall(60, 0, 120, a);

        wall[5] = new Wall(180, 240, 120, a);
        wall[6] = new Wall(420, 240, 120, a);
        wall[7] = new Wall(240, 360, 240, a);
        wall[8] = new Wall(60, 480, 120, a);
        wall[9] = new Wall(420, 480, 120, a);

        wall[10] = new Wall(240, 60, a, 120);
        wall[11] = new Wall(360, 120, a, 240);
        wall[12] = new Wall(120, 180, a, 120);
        wall[13] = new Wall(480, 300, a, 120);
        wall[14] = new Wall(240, 420, a, 360);
        wall[15] = new Wall(360, 540, a, 120);

        
        for(int i= 0; i < 16; i++){
            walls.add(wall[i]);
        }

        gm.walls = this.walls;

        shop[0] = new Shop(8, 480, 120); // マツモトキヨコ
        shop[1] = new Shop(1, 180, 300); // RAWSON

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
            case 0 : return new Maze_6(gm);
            case 1 : // なし
            case 2 : // なし
            case 3 : return new Maze_8(gm);
            default : return this;
        }
    }
}

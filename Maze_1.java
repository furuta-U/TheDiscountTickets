/***
 *** Maze1
 ***/
import java.awt.*;
import java.util.ArrayList;

public class Maze_1 extends Maze{
    private GameManager gm;
    private Wall wall[] = new Wall[15];
    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private int a = 16;
    private Shop shop[] = new Shop[4];
    private ArrayList<Shop> shops = new ArrayList<Shop>();
    
    // 生成
    public Maze_1(GameManager gm){
        super(gm);
        this.gm = gm;
        wall[0] = new Wall(300, 0, 600, a);
        wall[1] = new Wall(0, 300, a, 600);
        wall[2] = new Wall(120, 600, 240, a);
        wall[3] = new Wall(420, 600, 120, a);

        wall[4] = new Wall(600, 120, a, 240);
        wall[5] = new Wall(600, 480, a, 240);

        wall[6] = new Wall(180, 240, 120, a);
        wall[7] = new Wall(420, 240, 120, a);
        wall[8] = new Wall(60, 360, 120, a);
        wall[9] = new Wall(360, 480, 240, a);

        wall[10] = new Wall(360, 120, a, 240);
        wall[11] = new Wall(240, 240, a, 240);
        wall[12] = new Wall(120, 420, a, 120);
        wall[13] = new Wall(360, 420, a, 120);
        wall[14] = new Wall(480, 420, a, 360);

        for(int i= 0; i < 15; i++){
            walls.add(wall[i]);
        }

        gm.walls = this.walls;

        shop[0] = new Shop(8, 480, 120);  // マツモトキヨコ
        shop[1] = new Shop(11, 120, 120); // YAMATA電機
        shop[2] = new Shop(1, 60, 420); // RAWSON
        shop[3] = new Shop(3, 420, 420); // モクドナルド

        for(int i= 0; i < 4; i++){
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
            case 0 : // なし
            case 1 : return new Maze_4(gm);
            case 2 : return new Maze_2(gm);
            case 3 : // なし
            default : return this;
        }
    }
}

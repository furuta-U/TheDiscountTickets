/***
 *** Maze4
 ***/
import java.awt.*;
import java.util.ArrayList;

public class Maze_4 extends Maze{
    private GameManager gm;
    private Wall wall[] = new Wall[19];
    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private int a = 16;
    private Shop shop[] = new Shop[3];
    private ArrayList<Shop> shops = new ArrayList<Shop>();
    
    // 生成
    public Maze_4(GameManager gm){
        super(gm);
        this.gm = gm;
        wall[0] = new Wall(120, 0, 240, a);
        wall[1] = new Wall(420, 0, 120, a);
        wall[2] = new Wall(0, 300, a, 600);
        wall[3] = new Wall(180, 600, 120, a);
        wall[4] = new Wall(420, 600, 120, a);
        wall[5] = new Wall(600, 120, a, 240);
        wall[6] = new Wall(600, 480, a, 240);

        wall[7] = new Wall(360, 120, 480, a);
        wall[8] = new Wall(540, 240, 120, a);
        wall[9] = new Wall(60, 360, 120, a);
        wall[10] = new Wall(300, 360, 120, a);
        wall[11] = new Wall(540, 360, 120, a);
        wall[12] = new Wall(420, 480, 120, a);

        wall[13] = new Wall(240, 60, a, 120);
        wall[14] = new Wall(360, 180, a, 120);
        wall[15] = new Wall(120, 180, a, 120);
        wall[16] = new Wall(480, 420, a, 120);
        wall[17] = new Wall(240, 480, a, 240);
        wall[18] = new Wall(360, 540, a, 120);

        
        for(int i= 0; i < 19; i++){
            walls.add(wall[i]);
        }

        gm.walls = this.walls;

        shop[0] = new Shop(3, 180, 60); //　モクドナルド
        shop[1] = new Shop(1, 540, 180); // RAWSON
        shop[2] = new Shop(6, 540, 420); // ムーンバックス

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
            case 0 : return new Maze_1(gm);
            case 1 : return new Maze_7(gm);
            case 2 : return new Maze_5(gm);
            case 3 : // なし
            default : return this;
        }
    }
}

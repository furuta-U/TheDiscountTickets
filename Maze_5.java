/***
 *** Maze5
 ***/
import java.awt.*;
import java.util.ArrayList;

public class Maze_5 extends Maze{
    private GameManager gm;
    private Wall wall[] = new Wall[18];
    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private int a = 16;
    private Shop shop[] = new Shop[3];
    private ArrayList<Shop> shops = new ArrayList<Shop>();
    
    // 生成
    public Maze_5(GameManager gm){
        super(gm);
        this.gm = gm;
        wall[0] = new Wall(300, 0, 600, a);
        wall[1] = new Wall(0, 120, a, 240);
        wall[2] = new Wall(0, 480, a, 240);
        wall[3] = new Wall(180, 600, 360, a);
        wall[4] = new Wall(540, 600, 120, a);
        wall[5] = new Wall(600, 180, a, 360);
        wall[6] = new Wall(600, 540, a, 120);

        wall[7] = new Wall(180, 120, 120, a);
        wall[8] = new Wall(360, 240, 240, a);
        wall[9] = new Wall(60, 240, 120, a);
        wall[10] = new Wall(540, 360, 120, a);
        wall[11] = new Wall(240, 480, 240, a);
        wall[12] = new Wall(540, 480, 120, a);

        wall[13] = new Wall(240, 60, a, 120);
        wall[14] = new Wall(360, 120, a, 240);
        wall[15] = new Wall(120, 300, a, 120);
        wall[16] = new Wall(240, 300, a, 120);
        wall[17] = new Wall(360, 540, a, 120);
        
        for(int i= 0; i < 18; i++){
            walls.add(wall[i]);
        }

        gm.walls = this.walls;

        shop[0] = new Shop(10, 480, 120); // ミニマムバリュー
        shop[1] = new Shop(6, 180, 60); // ムーンバックス
        shop[2] = new Shop(5, 300, 540); // 吉田家

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
            case 0 : return new Maze_2(gm);
            case 1 : return new Maze_8(gm);
            case 2 : return new Maze_6(gm);
            case 3 : return new Maze_4(gm);
            default : return this;
        }
    }
}

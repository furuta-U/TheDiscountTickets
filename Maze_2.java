/***
 *** Maze2
 ***/
import java.awt.*;
import java.util.ArrayList;

public class Maze_2 extends Maze{
    private GameManager gm;
    private Wall wall[] = new Wall[17];
    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private int a = 16;
    private Shop shop[] = new Shop[3];
    private ArrayList<Shop> shops = new ArrayList<Shop>();
    
    // 生成
    public Maze_2(GameManager gm){
        super(gm);
        this.gm = gm;
        wall[0] = new Wall(300, 0, 600, a);
        wall[1] = new Wall(0, 120, a, 240);
        wall[2] = new Wall(0, 480, a, 240);
        wall[3] = new Wall(300, 600, 600, a);
        wall[4] = new Wall(600, 180, a, 360);
        wall[5] = new Wall(600, 540, a, 120);

        wall[6] = new Wall(540, 120, 120, a);
        wall[7] = new Wall(300, 240, 120, a);
        wall[8] = new Wall(420, 360, 120, a);
        wall[9] = new Wall(180, 360, 120, a);
        wall[10] = new Wall(300, 480, 120, a);
        
        wall[11] = new Wall(240, 180, a, 120);
        wall[12] = new Wall(480, 180, a, 120);
        wall[13] = new Wall(120, 300, a, 120);
        wall[14] = new Wall(360, 300, a, 120);
        
        wall[15] = new Wall(480, 480, a, 240);
        wall[16] = new Wall(240, 540, a, 120);

        for(int i= 0; i < 17; i++){
            walls.add(wall[i]);
        }

        gm.walls = this.walls;

        shop[0] = new Shop(7, 120, 480); // ミトリ
        shop[1] = new Shop(5, 540, 60); // 吉田家
        shop[2] = new Shop(4, 300, 540); // ガヌト
        
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
            case 0 : // 無し
            case 1 : return new Maze_5(gm);
            case 2 : return new Maze_3(gm);
            case 3 : return new Maze_1(gm);
            default : return this;
        }
    }
}

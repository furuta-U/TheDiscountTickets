/***
 *** Maze3
 ***/
import java.awt.*;
import java.util.ArrayList;

public class Maze_3 extends Maze{
    private GameManager gm;
    private Wall wall[] = new Wall[13];
    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private int a = 16;
    private Shop shop[] = new Shop[3];
    private ArrayList<Shop> shops = new ArrayList<Shop>();
    
    // 生成
    public Maze_3(GameManager gm){
        super(gm);
        this.gm = gm;
        wall[0] = new Wall(300, 0, 600, a);
        wall[1] = new Wall(0, 180, a, 360);
        wall[2] = new Wall(0, 540, a, 120);
        wall[3] = new Wall(60, 600, 120, a);
        wall[4] = new Wall(420, 600, 360, a);
        wall[5] = new Wall(600, 300, a, 600);

        wall[6] = new Wall(300, 240, 360, a);
        wall[7] = new Wall(180, 480, 120, a);
        
        wall[8] = new Wall(360, 120, a, 240);
        wall[9] = new Wall(120, 240, a, 240);
        wall[10] = new Wall(480, 360, a, 240);
        wall[11] = new Wall(360, 480, a, 240);
        wall[12] = new Wall(120, 540, a, 120);
        
        for(int i= 0; i < 13; i++){
            walls.add(wall[i]);
        }

        gm.walls = this.walls;

        shop[0] = new Shop(1, 60, 540); // RAWSON
        shop[1] = new Shop(9, 480, 120); // TOHUシネマズ
        shop[2] = new Shop(10, 240, 120); // ミニマムバリュー

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
            case 0 : // なし
            case 1 : return new Maze_6(gm);
            case 2 : // なし
            case 3 : return new Maze_2(gm);
            default : return this;
        }
    }
}

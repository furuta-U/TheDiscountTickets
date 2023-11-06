/***
 *** プレーヤ―クラス
 ***/

import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Player extends GameChar implements KeyListener{
    
    // 座標（x, y）はGameCharが所持
    private int dx, dy; // 移動量
    private GameManager gm;
    private ArrayList<Wall> walls;
    private ArrayList<Shop> shops;
    private int dir; // 方向
    private int a = 20;

    // 生成
    public Player (int x, int y){
        px = x;
        py = y;
        dx = 0;
        dy = 0;
        dir = 0;
        setSize(5, 5); // 衝突判定の大きさ
        setCenter(px, py - 15); // 衝突判定の中心（三角形の先端）
        walls = new ArrayList<Wall>();
        shops = new ArrayList<Shop>();
    }

    // ゲームマネージャーのセット
    public void setGM(GameManager gm){
        this.gm = gm;
        this.walls = gm.walls;
        this.shops = gm.shops;
    }
    
    // 移動
    public void move() {
        System.out.println(dx +" "+ dy);
        px += dx;
        py += dy;
        dx = 0;
        dy = 0;  
    }

    // パネル外へ出た方向の判定
    public int out(){
        if(py < 0) return 0;
        if(py > 600) return 1;
        if(px > 600) return 2;
        if(px < 0) return 3;
        else return 4;
    }

    // プレイヤーがウィンドウから出た後の座標
    public void out_xy(int n){
        switch(n){
            case 0 : py += 600; break;
            case 1 : py -= 600; break;
            case 2 : px -= 600; break;
            case 3 : px += 600; break; 
            default : break;
        }
    }

    // 店との衝突判定
    public int crush_PS(){
        int no = 0;
        for(Shop s:shops){
            System.out.println(overlap(s));
            if(overlap(s) == true){
                return no;
            }
            no++;
        }
        return no;
    }

    // 描画
    public void draw (Graphics g) {
        int[] x = new int[3];
        int[] y = new int[3];
        if(dir == 0){ // 上
            x[0] = (int)px;
            x[1] = (int)px - 10;
            x[2] = (int)px + 10;
            y[0] = (int)py - 15;
            y[1] = (int)py + 10;
            y[2] = (int)py + 10;
        }else if(dir == 1){ // 下
            x[0] = (int)px;
            x[1] = (int)px - 10;
            x[2] = (int)px + 10;
            y[0] = (int)py + 15;
            y[1] = (int)py - 10;
            y[2] = (int)py - 10;
        }else if(dir == 2){ // 右
            x[0] = (int)px + 15;
            x[1] = (int)px - 10;
            x[2] = (int)px - 10;
            y[0] = (int)py;
            y[1] = (int)py + 10;
            y[2] = (int)py - 10;
        }else{ // 左
            x[0] = (int)px - 15;
            x[1] = (int)px + 10;
            x[2] = (int)px + 10;
            y[0] = (int)py;
            y[1] = (int)py + 10;
            y[2] = (int)py - 10;
        }
        setCenter(x[0], y[0]); // 衝突判定中心の更新
        g.setColor (new Color (255,255, 100)); // 明るい黄色で
        g.fillPolygon (x, y, 3);               // 塗りつぶして
        g.setColor (new Color (255,200,20) );  // 暗い黄色で
        g.drawPolygon (x, y, 3);               // 枠を描く
    }

    // キーリスナー
    public void keyTyped(KeyEvent ev) {}

    public void keyPressed(KeyEvent ev) {
        if(gm.stage.lap > 3){
            if(ev.getKeyCode()==KeyEvent.VK_UP){
                if(dir == 0){
                    dy = -1 * a;
                    for(Wall w:walls){
                        if(overlap(w) == true){
                            dy = 0;
                            break;
                        }
                    }
                }
                dir = 0;
            }
            if(ev.getKeyCode()==KeyEvent.VK_DOWN){
                if(dir == 1){
                    dy = a;
                    for(Wall w:walls){
                        if(overlap(w) == true){
                        dy = 0;
                        break;
                        }
                    }
                }
                dir = 1;
            }
            if(ev.getKeyCode()==KeyEvent.VK_RIGHT){
                if(dir == 2){
                    dx = a;
                    for(Wall w:walls){
                        if(overlap(w) == true){
                            dx = 0;
                            break;
                        }
                    }
                }
                dir = 2;
            }
            if(ev.getKeyCode()==KeyEvent.VK_LEFT){
                if(dir == 3){
                    dx = -1 * a;
                    for(Wall w:walls){
                        if(overlap(w) == true){
                            dx = 0;
                            break;
                        }
                    }
                }
                dir = 3;
            }
        }
    }

    public void keyReleased(KeyEvent ev) {}   
}
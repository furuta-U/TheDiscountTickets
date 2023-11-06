/***
 *** 迷路の壁
 ***/

import java.awt.*;

public class Wall extends GameChar{
    private int dx, dy;
    
    // 生成
    public Wall(int x, int y, int dx, int dy){
        this.px = x;
        this.py = y;
        this.dx = dx;
        this.dy = dy;
        setCenter(x, y); // 衝突判定の中心
        setSize(dx + 10, dy + 10); // 衝突判定の範囲
    }

    // 描画
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect((int)(px - dx/2), (int)(py - dy/2), (int)dx, (int)dy);
    }
}
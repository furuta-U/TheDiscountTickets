/***
 *** 現在時刻を表示するパネル 
 ***/

import java.awt.*;
import javax.swing.*;

public class TimePanel extends JPanel{
    private GameManager gm;

    // 生成
    public TimePanel(GameManager gm){
        this.gm = gm;
       setBackground(Color.cyan);
    }

    // 描画
    public void draw(Graphics g){
        String s_money= String.valueOf(gm.money);
        String z1 = "", z2 = "";
        
        if(gm.hour < 10){
            z1 = "0";
        }
        if(gm.minute < 10){
            z2 = "0";
        }
        if(gm.money < 0){
            s_money = "----";
        }
        
        g.setColor(Color.black);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
        g.drawString(gm.day + "日目  " + z1 + gm.hour + ":" + z2 + gm.minute, 62, 40);

        g.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
        g.drawString("残金" + s_money + "円   得した金額" + gm.score + "円", 20, 80);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
}

/***
 *** バックパネル
 ***/

import java.awt.*;
import javax.swing.*;

public class BackPanel extends JPanel {
    private GameManager gm;
    
    // 生成
    public BackPanel(){
        setBackground(Color.gray);
        setFocusable(true);
    }

    // ゲーム管理者のセット
    public void setGM(GameManager gm){
        this.gm = gm;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        gm.drawMsgs(g);
    }
}
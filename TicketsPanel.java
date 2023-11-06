/***
 *** クーポン券パネル
 ***/

import java.awt.*;
import javax.swing.*;

public class TicketsPanel extends JPanel{
    private GameManager gm;
    private TimePanel timePanel; // 現在時刻表示欄
    public CouponPanel couponPanel; // クーポン表示欄

    // 生成
    public TicketsPanel(){
        setBackground(Color.black);
    }

    // ゲーム管理者のセット
    public void setGM(GameManager gm){
        this.gm = gm;
        setLayout(null);
        timePanel = new TimePanel(gm);
        timePanel.setBounds(0, 0, 300, 100);
        add(timePanel);

        couponPanel = new CouponPanel(gm);
        couponPanel.setBounds(0, 100, 300, 500);
        add(couponPanel);
    }

    // 描画
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        timePanel.paintComponents(g);
        couponPanel.paintComponents(g);
    }
}
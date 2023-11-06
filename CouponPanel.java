/***
 *** クーポン券パネル 
 ***/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;

public class CouponPanel extends JPanel implements ActionListener{
    private GameManager gm;
    private JButton button[] = new JButton[5];
    private Coupon coupon[] = new Coupon[5];
    private ArrayList<Shop> shops;
    
    Random rd = new Random();
    Color b_Color = new Color(180, 180, 180); // ボタンのデフォルト色
    int a = 95; // ボタンの高さ(y)
    Integer c[] = new Integer[5]; // クーポンの店
    Integer life[] = new Integer[5] ;

    // 生成
    public CouponPanel(GameManager gm){
        this.gm = gm;
        this.shops = gm.shops;
        setBackground(Color.black);        

        for(int i = 0; i < 5; i++){
            button[i] = new JButton();
            button[i].setActionCommand(String.valueOf(i));
            button[i].addActionListener(this);
            set_default(button[i]);
            life[i] = 0;
            add(button[i]);
            c[i] = 0;
        }
    }

    // クーポンボタンの初期化
    private void set_default(JButton bt){
        bt.setForeground(Color.black);
        bt.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
        bt.setText("");
        bt.setBackground(b_Color);
        bt.setPreferredSize(new Dimension(300, a));
        bt.setEnabled(false);
    }

    // 全てのクーポンボタンの初期化
    public void set_default_All(){
        for(int i = 0; i < 5; i++){
            set_default(button[i]);
        }
    }

    //  クーポンとボタン生成
    public void make_Coupon_Button(){
        int n = 0;
        for(int i = 0; i < 5; i++){
            if(button[i].getText() == ""){
                if(n == 0){
                    System.out.println("クーポン生成");
                    coupon[i] = new Coupon(gm);
                    c[i] = coupon[i].s_no;
                    System.out.println(coupon[i].s_name + "  " + coupon[i].name + "\r\n" + String.valueOf(coupon[i].price) + "  →  " + String.valueOf(coupon[i].d_price));
                    life[i] = coupon[i].life;
                    button[i].setText("<html>" + coupon[i].s_name + "  " + coupon[i].name + "<br/>" + String.valueOf(coupon[i].price) + "円   →  " + String.valueOf(coupon[i].d_price) + "円<br>" + coupon[i].life_S);
                    button[i].setBackground(get_Shop_Color(coupon[i].s_no));
                    n ++;
                }   
            }   
        }
    }

    // クーポンの色を取得
    public Color get_Shop_Color(int s_no){
        Color color;
        switch(s_no){
            case 1 : color = new Color(40, 120, 255); break;
            case 2 : color = new Color(255, 150, 150); break;
            case 3 : color = new Color(255, 255, 80); break;
            case 4 : color = new Color(170, 80, 80); break;
            case 5 : color = new Color(220, 180, 50); break;
            case 6 : color = new Color(30, 220, 40); break;
            case 7 : color = new Color(100, 255, 150); break;
            case 8 : color = new Color(150, 150, 50); break;
            case 9 : color = new Color(220, 50, 50); break;
            case 10 : color = new Color(180, 80, 150); break;
            case 11 : color = new Color(80, 180, 180); break;
            default : color = new Color(0, 0, 0); break;
        }
        return color;
    }

    // 有効期限の確認
    public void d_life(int n){
        for(int i = 0; i < 5; i++){
            if(life[i] > 0){
                life[i] -= n;
            }
            if(life[i] <= 0){
                set_default(button[i]);
                c[i] = 0;
            }
        }
    }

    // 店との接触によるクーポン券の更新
    public void activeCoupon(){
        int no = gm.player.crush_PS();
        this.shops = gm.shops;
        int sArray_no = shops.size();
        System.out.println(no);
        System.out.println(sArray_no);
        if(no < sArray_no){
            int n = shops.get(no).no;
            System.out.println(n);
            for(int i = 0; i < 5; i++ ){
                if(c[i] == n){
                    if(coupon[i].min_time <= gm.hour && gm.hour < coupon[i].max_time){
                        button[i].setEnabled(true);
                    }
                }
            }
        }else{
            for(int i = 0; i < 5; i++){
                button[i].setEnabled(false);
            }
        }
    }
    
    // 描画
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    // アクションリスナー
    public void actionPerformed(ActionEvent e){
        String e_button = e.getActionCommand();
        int n = Integer.valueOf(e_button).intValue();
        
        c[n] = 0;
        System.out.println(button[n]);
        if(gm.money > coupon[n].d_price){
            gm.score += coupon[n].price - coupon[n].d_price;
            gm.minute += coupon[n].c_time;
            d_life(coupon[n].c_time / 5);
        }
        gm.money -= coupon[n].d_price;
        
        set_default(button[n]);
        for(int i = n + 1; i < 5; i++){
            button[i].setFocusable(false);
        }
    }
}

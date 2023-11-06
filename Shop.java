/***
 *** 店
 ***/
import java.awt.*;

public class Shop extends GameChar{
    public Color color;
    private int n; // 店の大きさ
    public int no; // 店番号
    private String s_shop; // 店名

    public Shop(int s_no, int x, int y){
        px=x; py=y;
        cx=x; cy=y;
        this.no = s_no;

        switch(no){
            case 1 : make_RAWSON(); break;
            case 2 : make_INUQLO(); break;
            case 3 : make_Mk(); break;
            case 4 : make_GANUTO(); break;
            case 5 : make_YOSHIDAYA(); break;
            case 6 : make_MOON(); break;
            case 7 : make_MITORI(); break;
            case 8 : make_MATSUMOTO(); break;
            case 9 : make_TOHU(); break;
            case 10 : make_MINVALUE(); break;
            case 11 : make_YAMATA(); break;
        }
    }

    private void make_RAWSON(){ // 1
        n = 1;
        setSize(100, 100);
        color = new Color(40, 120, 255);
        s_shop = new String("RAWSON");
    }

    private void make_INUQLO(){ // 2
        n = 2;
        setSize(200, 200);
        color = new Color(255, 150, 150);
        s_shop = new String("INUQLO");
    }

    private void make_Mk(){ // 3
        n = 1;
        setSize(100, 100);
        color = new Color(255, 255, 80);
        s_shop = new String("モクドナルド");
    }

    private void make_GANUTO(){ // 4
        n = 1;
        setSize(100, 100);
        color = new Color(170, 80, 80);
        s_shop = new String("ガヌト");
    }

    private void make_YOSHIDAYA(){ // 5
        n = 1;
        setSize(100, 100);
        color = new Color(220, 180, 50);
        s_shop = new String("吉田家");
    }

    private void make_MOON(){ // 6
        n = 1;
        setSize(100, 100);
        color = new Color(30, 220, 40);
        s_shop = new String("ムーンバックス");
    }

    private void make_MITORI(){ // 7
        n = 2;
        setSize(200, 200);
        color = new Color(100, 255, 150);
        s_shop = new String("ミトリ");
    }

    private void make_MATSUMOTO(){ // 8
        n = 2;
        setSize(200, 200);
        color = new Color(150, 150, 50);
        s_shop = new String("マツモトキヨコ");
    }

    private void make_TOHU(){ // 9
        n = 2;
        setSize(200, 200);
        color = new Color(220, 50, 50);
        s_shop = new String("TOHUシネマズ");
    }

    private void make_MINVALUE(){ // 10
        n = 2;
        setSize(200, 200);
        color = new Color(180, 80, 150);
        s_shop = new String("ミニマムバリュー");
    }

    private void make_YAMATA(){ // 11
        n = 2;
        setSize(200, 200);
        color = new Color(80, 180, 180);
        s_shop = new String("YAMATA電機");
    }

    // 描画
    public void draw(Graphics g){
        int[] x1 = new int[3];
        int[] y1 = new int[3];
        x1[0] = (int)px;
        y1[0] = (int)py - n * 30;
        x1[1] = (int)px + n * 40;
        y1[1] = (int)py - n * 5;
        x1[2] = (int)px - n * 40;
        y1[2] = (int)py - n * 5;

        int x2 = px - n * 30;
        int y2 = py - n * 5;

        FontMetrics fm = g.getFontMetrics();
		Rectangle rectText = fm.getStringBounds(s_shop, g).getBounds();
		
        int x3 = px - rectText.width/2;
        int y3 = py + n * 20 - rectText.height/2;

        g.setColor (this.color);
        g.fillPolygon (x1 , y1, 3);               
        g.fillRect(x2, y2, n * 60, n * 45);

        g.setColor(Color.black);
        g.drawString(s_shop, x3, y3);  
    }
}
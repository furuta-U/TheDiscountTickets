/***
 *** クーポン券 
 ***/
import java.util.Random;

public class Coupon {
    public String s_name = new String(); // 店舗名
    public String name = new String(); // 商品名
    public int price; // 定価
    public int d_price; // 割引価格
    public int life; // 有効期限
    public int s_no; // 使用可能店舗
    public String life_S; // 有効期限を示す文字列
    public int c_time; // 使用したときの経過時間
    public int min_time; // 使用可能開始時刻
    public int max_time; // 使用可能終了時刻

    GameManager gm;
    Random rd = new Random();
    int r;
    
    public Coupon(GameManager gm){
        this.gm = gm;
        if(gm.hour >= 10 && gm.hour < 18){
            r = rd.nextInt(11);
            switch(r){
                case 0 : make_RAWSON_C(); s_name = "RAWSON"; break;
                case 1 : make_INUQLO_C(); s_name = "INUQLO"; break;
                case 2 : make_Mk_C(); s_name = "モクドナルド"; break;
                case 3 : make_GANUTO_C(); s_name = "ガヌト"; break;
                case 4 : make_YOSHIDAYA_C(); s_name = "吉田家"; break;
                case 5 : make_MOON_C(); s_name = "ムーンバックス"; break;
                case 6 : make_MITORI_C(); s_name = "ミトリ"; break;
                case 7 : make_MATSUMOTO_C(); s_name = "マツモトキヨコ"; break;
                case 8 : make_TOHU_C(); s_name = "TOHUシネマズ"; break;
                case 9 : make_MINVALUE_C(); s_name = "ミニマムバリュー"; break;
                case 10 : make_YAMATA_C(); s_name = "YAMATA電機"; break;
            }
        }
        else if(gm.hour >= 8 && gm.hour < 21){
            r = rd.nextInt(8);
            switch(r){
                case 0 : make_RAWSON_C(); s_name = "RAWSON"; break;
                case 1 : make_Mk_C(); s_name = "モクドナルド"; break;
                case 2 : make_GANUTO_C(); s_name = "ガヌト"; break;
                case 3 : make_YOSHIDAYA_C(); s_name = "吉田家"; break;
                case 4 : make_MOON_C(); s_name = "ムーンバックス"; break;
                case 5 : make_MATSUMOTO_C(); s_name = "マツモトキヨコ"; break;
                case 6 : make_TOHU_C(); s_name = "TOHUシネマズ"; break;
                case 7 : make_MINVALUE_C(); s_name = "ミニマムバリュー"; break;
            }
        }
        else{
            r = rd.nextInt(5);
            switch(r){
                case 0 : make_RAWSON_C(); s_name = "RAWSON"; break;
                case 1 : make_Mk_C(); s_name = "モクドナルド"; break;
                case 2 : make_GANUTO_C(); s_name = "ガヌト"; break;
                case 3 : make_YOSHIDAYA_C(); s_name = "吉田家"; break;
                case 4 : make_MINVALUE_C(); s_name = "ミニマムバリュー"; break;
            }
        }
    }

    public Coupon(GameManager gm, int n){
        make_COUPON(12, "", 0, 0, 10000, 0);
        s_name = "";
    }


    private void make_COUPON(int s_no, String name, int price, int d_price, int life, int c_time){
        this.s_no = s_no;
        this.name = name;
        this.price = price;
        this.d_price = d_price;
        this.life = life;
        this.c_time = c_time;
        setLife();
    }

    private void make_RAWSON_C(){
        r = rd.nextInt(3);
        min_time = 0;
        max_time = 24;
        switch(r){
            case 0 : make_COUPON(1, "Rチキ", 180, 160, 60, 5); break;
            case 1 : make_COUPON(1, "とんかつ弁当", 560, 520, 100, 5); break;
            case 2 : make_COUPON(1, "アイスコーヒーS", 100, 0, 20, 5); break;
        }
    }

    private void make_INUQLO_C(){
        r = rd.nextInt(3);
        min_time = 10;
        max_time = 20;
        switch(r){
            case 0 : make_COUPON(2, "Tシャツ", 1380, 980, 60, 20); break;
            case 1 : make_COUPON(2, "ジーンズ", 3990, 2990, 40, 20); break;
            case 2 : make_COUPON(2, "コート", 5990, 4590, 25, 20); break;
        }
    }

    private void make_Mk_C(){
        r = rd.nextInt(3);
        min_time = 0;
        max_time = 24;
        switch(r){
            case 0 : make_COUPON(3, "コーラ S", 100, 0, 40, 10); break;
            case 1 : make_COUPON(3, "ポテト L", 330, 150, 60, 10); break;
            case 2 : make_COUPON(3, "ハンバーガーセット", 790, 490, 75, 10); break;
        }
    }

    private void make_GANUTO_C(){
        r = rd.nextInt(3);
        min_time = 0;
        max_time = 24;
        switch(r){
            case 0 : make_COUPON(4, "ミニサラダ", 290, 260, 60, 10); break;
            case 1 : make_COUPON(4, "パフェ", 690, 620, 70, 15); break;
            case 2 : make_COUPON(4, "ハンバーグセット", 990, 860, 50, 30); break;
        }
    }

    private void make_YOSHIDAYA_C(){
        r = rd.nextInt(3);
        min_time = 0;
        max_time = 24;
        switch(r){
            case 0 : make_COUPON(5, "牛丼", 430, 380, 60, 10); break;
            case 1 : make_COUPON(5, "温玉", 80, 0, 25, 5); break;
            case 2 : make_COUPON(5, "特盛牛丼", 780, 630, 50, 15); break;
        }
    }

    private void make_MOON_C(){
        r = rd.nextInt(3);
        min_time = 8;
        max_time = 23;
        switch(r){
            case 0 : make_COUPON(6, "ドリップコーヒー Short", 310, 0, 15, 5); break;
            case 1 : make_COUPON(6, "カフェラテ Tall", 420, 380, 75, 5); break;
            case 2 : make_COUPON(6, "フラッペ Grande", 580, 460, 50, 5); break;
        }
    }

    private void make_MITORI_C(){
        r = rd.nextInt(3);
        min_time = 11;
        max_time = 20;
        switch(r){
            case 0 : make_COUPON(7, "クッション", 680, 560, 75, 20); break;
            case 1 : make_COUPON(7, "デスク", 5980, 4280, 50, 30); break;
            case 2 : make_COUPON(7, "ソファ", 8980, 5980, 30, 45); break;
        }
    }

    private void make_MATSUMOTO_C(){
        r = rd.nextInt(3);
        min_time = 9;
        max_time = 23;
        switch(r){
            case 0 : make_COUPON(8, "エナジードリンク", 210, 0, 15, 5); break;
            case 1 : make_COUPON(8, "シャンプー", 480, 340, 60, 5); break;
            case 2 : make_COUPON(8, "日焼け止めクリーム", 850, 690, 50, 5); break;
        }
    }

    private void make_TOHU_C(){
        r = rd.nextInt(3);
        min_time = 8;
        max_time = 22;
        switch(r){
            case 0 : make_COUPON(9, "ソフトドリンク", 380, 190, 60, 5); break;
            case 1 : make_COUPON(9, "ポップコーン", 490, 290, 50, 5); break;
            case 2 : make_COUPON(9, "無料鑑賞券", 1900, 0, 12, 120); break;
        }
    }

    private void make_MINVALUE_C(){
        r = rd.nextInt(3);
        min_time = 0;
        max_time = 24;
        switch(r){
            case 0 : make_COUPON(10, "から揚げ", 380, 190, 60, 15); break;
            case 1 : make_COUPON(10, "みかん", 290, 100, 50, 15); break;
            case 2 : make_COUPON(10, "国産牛肉", 2990, 1590, 30, 15); break;
        }
    }

    private void make_YAMATA_C(){
        r = rd.nextInt(3);
        min_time = 10;
        max_time = 20;
        switch(r){
            case 0 : make_COUPON(11, "乾電池", 780, 490, 80, 15); break;
            case 1 : make_COUPON(11, "ヘッドホン", 12990, 7990, 50, 45); break;
            case 2 : make_COUPON(11, "電子レンジ", 21700, 13800, 30, 60); break;
        }
    }

    private void setLife(){
        int m = gm.minute + life * 5 ;
        int life_m = m % 60;
        int h = gm.hour + (m - life_m) / 60;
        int life_h = h % 24;
        int life_d = gm.day + (h - life_h) / 24;
        String z1 = "", z2 = "";
/*
        if(life_h >= max_time || life_h < min_time){
            life_h = max_time;
            life_m = 0;
        }*/
        if(life_h < 10){
            z1 = "0";
        }
        if(life_m < 10){
            z2 = "0";
        }

        life_S = (life_d + "日目  " + z1 + life_h + ":" + z2 + life_m + "まで有効");
    }
}

/***
 *** ゲーム管理者
 ***/

import java.awt.*;
import java.util.*;

public class GameManager extends Thread {
    private MazePanel mp; // 迷路パネル
    private TicketsPanel tp; // クーポン券パネル
    private BackPanel bp; // バックパネル
    private Maze maze; // 迷路
    public Player player; // プレーヤー
    public ArrayList<Wall> walls; // 壁リスト
    public ArrayList<Shop> shops; // 店リスト
    public ArrayList<Msg> msgs; // メッセージリスト
    public Stage stage; // ステージ
    public int hour; // 時
    public int minute; // 分
    public int day; // 日
    public int money; // 所持金
    public int score; // 得した金額・スコア
    public int pc; // プレイ回数
    
    // 生成
    public GameManager (MazePanel mp, TicketsPanel tp, BackPanel bp) {
        this.mp = mp;
        this.tp = tp;
        this.bp = bp;
        pc = 0;
        walls = new ArrayList<Wall>();
        shops = new ArrayList<Shop>();
        msgs=new ArrayList<Msg>(); // メッセージのリスト
        stage=new StageStart(this); // 最初のステージ
        initGame();
    }

    // 初期化
    public void initGame(){
        if(stage.stageN == 2){
            pc++;
            maze = new Maze_7(this);
            msgs.clear();
            mp.setVisible(true);
            tp.setVisible(true);
            player = new Player(120, 480);
            player.setGM(this);
            bp.addKeyListener(player);    
            tp.couponPanel.set_default_All();
            hour = 6;
            minute = 0;
            day = 1;
            money = 20000;
            score = 0;
        }
        else{
            msgs.clear();
            mp.setVisible(false);
            tp.setVisible(false);
            bp.setVisible(true);
            bp.addKeyListener(stage);   
        }
    }
    
    // 実行
    public void run() {
        long t = 0;
        
        while(true) {
            if(stage.stageN == 2){ // ゲーム中
                if(t % 250 == 0 && stage.lap > 4) {
                    time(); // 現在時刻の更新
                    tp.couponPanel.d_life(1); // クーポンの有効期限の確認と更新
                }
                if(t % 50 == 0) player.move(); // プレーヤーの移動
                if(t % 160 == 0) tp.couponPanel.activeCoupon(); // 店との接触によるクーポン券ボタンの状態の更新
                if(t % 200 == 0){
                    int n = player.out(); // プレーヤーが迷路画面から出ていないか
                    if(n != 4){ // 出ていたら
                        maze = maze.next(n); // 迷路を更新
                        player.out_xy(n); // 次の迷路での座標へ変換
                        player.setGM(this); // ゲームマネージャーの再セット
                    } 
                }
                if(t % 2500 == 0)tp.couponPanel.make_Coupon_Button(); // クーポン券とクーポンボタンの生成
                mp.repaint(); // 迷路を再描画
                tp.repaint(); // クーポンパネルを再描画
                if(t % 300 == 0){ // ゲーム終了判定
                    if(!stage.proceed(t)){
                        stage=stage.next();
                        initGame();
                    }
                }
                try{
                    sleep(2);
                } catch (InterruptedException e){}
                t++;
            }
            else{ // スタート(スコア)画面
                if(t % 30 == 0) playAllMessages(); // 30回に1回メッセージを動作
                bp.repaint();
                if(t % 50 == 0){ // ゲームスタート判定
                    if(!stage.proceed(t)){
                        stage=stage.next();
                        initGame();
                        t = -1;
                    }
                }
                try{
                    sleep(2);
                } catch (InterruptedException e){}
                t++;
            }
        }
    }

    // すべてのメッセージを動作
    private void playAllMessages(){
        Iterator<Msg> it=msgs.iterator();
        while(it.hasNext()){
            Msg m=it.next();
            if(!m.play()){
                it.remove();
            }
        }
    }

    // 迷路パネルを得る
    public BackPanel getBP(){
        return bp;
    }

    // 現在時刻
    public void time(){
        minute += 5;
        if(minute >= 60){
            minute -= 60;
            hour += 1;
            if(hour >= 24){
                hour = 0;
                day += 1;
            }
        }
    }
   
    // メッセージの追加
    public void addMessage(Msg m){
        msgs.add(m);
    }

    // 描画
    public void draw (Graphics g) {
        player.draw(g); // プレイヤーを描画
        maze.draw(g);   // 迷路を描画
        drawMsgs(g);
    }

    public void drawMsgs(Graphics g){
        for(Msg m:msgs) m.draw(g,900,600); // すべてのメッセージを描画
    }
}
/***
 *** ステージの基底クラス
 ***/

import java.awt.event.*;

public abstract class Stage implements KeyListener {
    public int lap; // 経過時間
    protected int max; // 最大時間
    protected GameManager gm; // ゲーム管理者
    public boolean start;
    public int stageN;

    // 生成
    public Stage(GameManager gm){
      lap=0;
      max=0;
      this.gm=gm;
    }

    // 進行
    public abstract boolean proceed(long t);

    // 次のステージ
    public abstract Stage next();
    
    // キーリスナー
    public abstract void keyPressed(KeyEvent ev);
    public abstract void keyReleased(KeyEvent ev);
    public abstract void keyTyped(KeyEvent ev);
}

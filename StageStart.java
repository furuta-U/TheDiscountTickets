/***
 *** ゲームスタート画面・スコア画面
 ***/
import java.awt.*;
import java.awt.event.*;

public class StageStart extends Stage {
  
  // 生成
  public StageStart(GameManager gm){
    super(gm);
    start=false;
    stageN = 1;
  }

  // 進行
  public boolean proceed(long t){
    if(lap==0){ 
      if(gm.pc == 0){ // 初めてのプレイ
        gm.addMessage(new MsgBrink("T h e   D i s c o u n t   T i c k e t s",200,Color.orange,32));
        gm.addMessage(new MsgBrink("Press S key to Start !!",350,Color.white,24));
      }else{ // ２回目以上のプレイ（プレイ終了後）
        gm.addMessage(new MsgBrink("S c o r e   :   " + gm.score + "円",200,Color.red,32));
        gm.addMessage(new MsgBrink("Press S key to Restart !!",350,Color.white,24));
      } 
    }
    lap++;
    return !start;
  }

  // 次のステージ
  public Stage next(){
    return new StageGame(gm);
  }

  // キーリスナー
  public void keyPressed(KeyEvent ev){
    if(ev.getKeyCode()==KeyEvent.VK_S){
      start=true;
    }
  }
  public void keyReleased(KeyEvent ev){}
  public void keyTyped(KeyEvent ev){}
}
